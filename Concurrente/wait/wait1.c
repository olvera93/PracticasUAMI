#include <sys/types.h>
#include <unistd.h>
#include <sys/wait.h>
#include <stdio.h>

int main() {
	int tid;
	int pid_hijo;
	int status;

	tid = fork();

	if (tid != 0) {
		printf("soy el PADRE voy a esperar a mi HIJO ----  mi pid es %d, el pid de mi papa es %d, el pid de mi hijo es %d\n", getpid(), getppid(), tid);

		pid_hijo = wait(&status); //status es un parametro o argumento de salida - es decir tiene algo cuando termina el wait

		printf("soy el PADRE mi HIJO que terminó es %d\n", pid_hijo);

	}

	else {
		printf("soy el HIJO mi pid es %d, el pid de mi PAPA es %d\n", getpid(),getppid());
		sleep(10);
	}

}

