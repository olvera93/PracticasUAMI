#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>
#include <string.h>

void parse(char *linea, char **argv){
	while(*linea != '\0'){
		while(*linea == ' ' || *linea == '\t' || *linea == '\n')
			*linea++ = '\0';
		*argv++ = linea;
		while(*linea != '\0' && *linea != ' ' && *linea != '\t' && *linea != '\n')
			linea++;
	}
	*argv = '\0';
}

void ejecutar(char **argv){
	pid_t pid;

	if( (pid=fork()) < 0){
		printf("Error al crear proceso hijo");
		exit(1);
	}else if(pid == 0){
		if(execvp(*argv, argv) < 0){
			printf("\nError al ejecutar exec \n");
			exit(1);
		}
	}else{
		while(wait(NULL) != pid);
	}
}



int main(){
	char linea[1024];
	char *argv[64];

	while(1){
		printf("Shell ->> ");
		fgets(linea, 1024, stdin);
		printf("\n");
		parse(linea, argv);
		if(strcmp(argv[0], "exit") == 0)
			exit(0);
		ejecutar(argv);
	}
}