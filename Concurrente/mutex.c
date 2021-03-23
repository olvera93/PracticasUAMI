#include <stdio.h>
#include <pthread.h>
#include <stdlib.h>

#define NUM_THREAD 4
#define TAM 1000

int total;
int array[TAM];
pthread_mutex_t m1;

void *Sum (void *threadId){
	
	long id = (long) threadId;; 
	int i, parcial = 0;
	int inicio = (TAM / NUM_THREAD) * id; 
	int fin = (TAM / NUM_THREAD) * (id + 1);	
	
	for(i = inicio; i < fin; i++){
		parcial +=  array[i];
	}
	
	printf("\nSoy el thread: %ld\n Comienzo en: %d\n Termino en %d\n Parcial es: %d\n", id, inicio, fin, parcial);
		
	pthread_mutex_lock(&m1);
	total += parcial;
	pthread_mutex_unlock(&m1);
	

	pthread_exit (NULL);
}

int main (int argc, char *argv[]){
	
	int i, threadId[NUM_THREAD];
	pthread_t threads[NUM_THREAD];
	pthread_mutex_init (&m1, NULL);
	
	for(i = 0; i < TAM; i++){
		array[i] = i + 1;
	}
	
	for(i = 0; i < NUM_THREAD; i++){
		threadId[i] = i;
		pthread_create (&threads[i], NULL, Sum, (void *)threadId[i]);
	}
	
	for(i = 0; i < NUM_THREAD; i++) {
		pthread_join(threads[i], NULL);
	}
	
	printf("\nEl total es: %d", total);
	
	return 0;
}

