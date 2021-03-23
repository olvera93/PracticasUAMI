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
Es el tamanio de productores que va a decir el usuario
para crear varios productores.
*/
int s;

/*
Es el tamanio que cada productor va a producir en el buffer
el valor lo va a decidir el usuario
*/
int k;

int contador =0; // Su funcion es que va a depositar un valor en cada casilla del buffer


void depositar_dato();
void waitS(int semaforo); // Recibe el indice del semaforo al que se le aplicara wait: -1
void signalS(int semaforo); // Recibe el indice del semaforo al que se le aplicara el signal: +1


int main(){

	pid_t pid;
	
	printf("\nDame el valor de s para el tamanio de los productores: ");
	scanf("%d", &s);
	printf("\nDame el valor de k para producir: ");
	scanf("%d", &k);
	
	
	//Su funcion del for va a crear los productores que proporcione el usuario
	for(int i = 0; i < s; i++) {
		pid = fork();
		
		if(pid < 0){
			perror("Fallo el fork");
			exit(1);
		}
		
		/*
		Se verifica si el hijo es igual a 0
		Para crear a los "s" productores que dio el usuario
		*/
		if( pid == 0){
			sleep(1);
			printf("\n\n\t     ___________________________________________\n");
			printf("\n\t\tProceso %d, voy a producir %d elementos\n", i+1, k);
			
			/*
			Su funcion del for es que cada "s" productor que proporciono el usuario
			Cada uno va a producir "k" elementos 
			*/
			for(int j =0; j < k; j++) {
				sleep(1);
				printf("\n\t\t************************************\n");
				printf("\t\tP: Esperando por espacio disponible... \n");
				waitS(VACIO);
				sleep(1);
				printf("\t\tP: Esperando acceso a la Region Critica... \n");
				waitS(MUTEX);
				contador ++; // Va a depositar en la siguiente casilla del buffer
				depositar_dato(); // Region Critica
				sleep(1);
				printf("\t\tP: Liberando acceso a buffer\n");
				signalS(MUTEX);
				sleep(1);
				printf("\t\tP: Hay un elemento mas en buffer\n");
				signalS(LLENO);
				printf("\t\t************************************\n");
		    }
		    
		    printf("\t     ___________________________________________\n\n");

		} else {
	       break;
		}
		

	} //Fin del for principal
	
	
	
	
	
	
}

// Es el equivalente al x++ del programa sin
// memoria compartida y sin semaforos de C
void depositar_dato(){
	int llave, shm_id, *buffer;;
	
	int item = 0; // Es el valor que se va a depositar en el buffer
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
			/*
			Su funcion del for es que va a depositar el valor 
			*/
			for(j = 0; j < k; j++) {
				sleep(1);

				item = j + 10 ; // Va a depositar el valor "10" en el buffer
				buffer[contador] = item; // Se va a depositar el valor de [10] en cada casilla del arreglo
				*buffer = *buffer + 1; // Se pasa a la siguiente casilla 
				printf("\t\tProductor produce {%d} en la posicion [%d]\n", item, (*buffer -1));
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


