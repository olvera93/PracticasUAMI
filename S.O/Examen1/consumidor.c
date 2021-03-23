/*
      ************************
       Olvera Monroy Gonzalo 
             Examen #1
      ************************
*/

#include <stdio.h>
#include <stdlib.h>
#include <errno.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <sys/ipc.h>
#include <sys/sem.h>
#include <sys/shm.h>
#include <unistd.h>

/*
Claves para semaforos. Estos valores son INDICES.
0 LLENO: Valor inicial será 0. Cuantos lugares estan ocupados en el buffer
1 VACIO:  Valor inicial el tamaño de buffer. Indica cuantos lugares hay disponibles para consumir
2 MUTEX: Valor inicial 1. Este da permiso o bloquea el acceso a la región critica
*/
#define LLENO 0
#define VACIO 1
#define MUTEX 2	

/*
Es el tamanio de consumidores que va a proporcionar el usuario
para crear varios t consumidores.
*/
int t;

/*
Es el tamanio que cada consumidor va a consumir k elementos en el buffer
el valor lo va a decidir el usuario
*/
int k;

int contador = 0; // Su funcion es va a estar quitando el valor que hay en cada casilla del buffer



void consumir();
void waitS(int semaforo); // Recibe el indice del semaforo al que se le aplicara wait: -1
void signalS(int semaforo); // Recibe el indice del semaforo al que se le aplicara el signal: +1


int main(){
	pid_t pid;
	printf("\nDame el valor de t para el tamanio de los consumidores: ");
	scanf("%d", &t);
	
	printf("\nDame el valor de k para consumir: ");
	scanf("%d", &k);
	
	//Su funcion del for va a crear los consumidore que proporcione el usuario
	for(int i = 0; i < t; i++) {
		pid = fork();
		
		
		if(pid < 0) { //Se verificar que el valor del pid no sea negativo
			perror("Fallo el fork");
			exit(1);
		}
		
		/*
		Se verifica si el hijo es igual a 0
		Para crear a los "t" consumidores que dio el usuario
		*/
		if( pid == 0){
			sleep(1);
			printf("\n\n\t     ___________________________________________\n");
			printf("\n\t\tProceso %d, voy a consumir %d elementos\n", i+1, k);
			
			/*
			Su funcion del for es que cada "t" consumidor que proporciono el usuario
			Cada uno va a consumir "k" elementos 
			*/
			for(int j =0; j < k; j++) {
				sleep(1);
				printf("\n\t\t************************************\n");
				printf("\t\tC: Esperando por espacio disponible... \n");
				waitS(LLENO);
				sleep(1);
				printf("\t\tC: Esperando acceso a la Recion Critica... \n");
				waitS(MUTEX);
				contador++;
				consumir(); // Region Critica
				contador--; // Es quitar el valor que tiene el buffer 
				sleep(1);
				printf("\t\tP: Liberando acceso a bufer\n");
				signalS(MUTEX);
				sleep(1);
				printf("\t\tC: Hay un elemento fuera del buffer\n");
				signalS(VACIO);
				printf("\t\t************************************\n");
			
			}
			printf("\t     ___________________________________________\n\n");
		} else {
			break;
		}	
	}	
}

// Es el equivalente al x++ del programa sin
// memoria compartida y sin semaforos de C
void consumir(){
	int llave, shm_id, *buffer;
	int item = 0; // Es el valor que se va a consumir en el buffer

	
	int j;
		
	// Creamos la llave
	llave = ftok(".", 'G');
	
	if( llave == -1 )
		perror("\nError al crear la llave\n");
	else{
		shm_id = shmget(llave, sizeof(int), 0666);
		if(shm_id == -1)
			perror("\nError al encontrar la variable\n");
		else{
			buffer = (int *)shmat(shm_id, 0, 0);

			for(j = 0; j < k; j++){ // Se va a quitar el valor del buffer 
				sleep(1);
				item = buffer[contador]; //Se quita el valor {10} que contiene el buffer
				*buffer = *buffer - 1; // Se retrocede una casilla 
				printf("\t\tConsumidor: consumo {%d} en la posicion: [%d]\n", item, *buffer);
				break;
			}
			shmdt((char *) buffer);
		}
	}
	
}


// Se le pasa el indice del semaforo al que se aplicara wait
void waitS(int semaforo){
	int llave, sem_id;
	struct sembuf s_ops;
	
	llave = ftok(".", 'G');
	
	if( llave == -1)
		perror("\nError al crear llave\n");
	else{
		sem_id = semget(llave, 3, 0666);
		if( sem_id == -1)
			perror("\nError al encontrar los semaforos\n");
		else{
			s_ops.sem_num = semaforo; // numero del semaforo a actualizar
			s_ops.sem_op = -1;    // operacion wait
			s_ops.sem_flg = 0;
			semop(sem_id, &s_ops, 1);  // Se le aplica la operacion wait a semaforo
		}
	}	
}





// Se le pasa el indice del semaforo al que se aplicara signal
void signalS(int semaforo){
	int llave, sem_id;
	struct sembuf s_ops;
	
	llave = ftok(".", 'G');
	
	if( llave == -1)
		perror("\nError al crear llave\n");
	else{
		sem_id = semget(llave, 3, 0666);
		if( sem_id == -1)
			perror("\nError al encontrar los semaforos\n");
		else{
			s_ops.sem_num = semaforo; // numero del semaforo a actualizar
			s_ops.sem_op = 1;    // operacion signal
			s_ops.sem_flg = 0;
			semop(sem_id, &s_ops, 1);  // Se le aplica la operacion wait a semaforo
		}
	}
	
	
}
