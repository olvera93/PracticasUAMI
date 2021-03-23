#include <stdio.h>
#include <sys/types.h>
#include <unistd.h>
#include <stdlib.h>

int main(int argc, char *argv[]) {
	
	if(argc != 2) {
	  printf("No se puede pasar mas de un argumento");
	  exit(1);
	}

	int i = 0;
	pid_t pid;
	int nivel = atoi(argv[1]);

	while((nivel - 1) > 0 && i < 2) {
	     pid = fork();

	     switch(pid) {
		
		case -1:
		    printf("Error al crear el proceso \n");
		    exit(-1);

		case 0:
		    printf("Soy el proceso hijo con pid: %d\n", getpid());
		    nivel--;
		    i =0;
		    break;

		default:
		    printf("Soy el proceso padre con pid: %d", getppid());
		    i ++;
	     }
	}
	
	while(1);

	return 0;
}
