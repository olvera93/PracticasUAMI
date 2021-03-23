#include <stdio.h>
#include <unistd.h>

int main(){
	fork();
	printf("Hola\n");
	fork();
	sleep(10);
}
