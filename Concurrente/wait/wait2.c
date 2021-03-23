#include <sys/types.h>
#include <unistd.h>
#include <sys/wait.h>
#include <stdio.h>

int main() {
	int tid1, tid2;
	int pid_hijo;
	int status;

	tid1 = fork();

	if (tid1 != 0) {     //soy el PADRE

		tid2 = fork();

		if (tid2 != 0) {
			printf("soy el PADRE voy a esperar por mi SEGUNDO HIJO ------  mi pid es %d, el pid de mi papa es %d, el pid de mi primer hijo es %d el de mi segundo hijo es %d\n",getpid(), getppid(), tid1, tid2);

			pid_hijo = waitpid(tid2, &status, 0); //status es un parametro o argumento de salida - es decir tiene algo cuando termina el wait

			printf("soy el PADRE, SEGUNDO HIJO por el que espere es %d\n", pid_hijo);
		}

		else {
			printf("soy el SEGUNDO hijo me voy a dormir 10 segundos ------  mi pid es %d, el pid de mi papa es %d\n",getpid(), getppid());
			sleep(10);
			printf("soy el SEGUNDO hijo ya desperte\n");
		}
	}    //fin del if GRANDE

	else {
		printf("soy el PRIMER hijo me voy a dormir 5 segundos ------ mi pid es %d, el pid de mi papa es %d\n",getpid(), getppid());
		sleep(5);
		printf("soy el PRIMER hijo ya desperte\n");
	}
}

