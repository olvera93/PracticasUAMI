//Olvera Monroy Gonzalo

#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define TAMANIO 500 // Es la capacidad de la memoria 
#define CONTADOR 5 // Es el limite que puede estar un proceso en memoria 

// ocupado + desocupado = particion
struct Nodo{
	int posicion;
	int tamanio_particion;
	int tamanio_ocupado;
	int tamanio_desocupado;
	int contador_proceso;
	struct Nodo *siguiente_nodo;
};

// Si el primer nodo es nulo entonces la lista está vacia
int esta_vacia(struct Nodo *primer_nodo){
	return primer_nodo == NULL;
}

// Genera numeros aleatorios en un rango.
int generador_random(int l, int r) { //Este generara un numero aleatoroi en un rango l y r
   return (rand() % (r - l + 1)) + l;
}


// Creación de nuevo nodo
// struct Nodo *siguiente_nodo  es  la flecha que apunta a otro nodo o a null
// En Java este sería el constructor para un Nodo
struct Nodo *crea_nodo(int tamanio_particion, struct Nodo *siguiente_nodo){
	
	struct Nodo *nuevo_nodo = (struct Nodo*) malloc(sizeof(struct Nodo));
	
	if(nuevo_nodo == NULL){
		printf("\nProblema al crear el nuevo nodo\n");
		exit(0);
	}
	
	nuevo_nodo->posicion = 0;
	nuevo_nodo->tamanio_particion = tamanio_particion;
	nuevo_nodo->tamanio_ocupado = 0;
	nuevo_nodo->tamanio_desocupado = tamanio_particion;
	nuevo_nodo->contador_proceso = 0;
	nuevo_nodo->siguiente_nodo = siguiente_nodo;
	
	return nuevo_nodo;
}

struct Nodo *inserta_inicio(struct Nodo *primer_nodo, int tamanio_particion){
	struct Nodo *nuevo_nodo = crea_nodo(tamanio_particion, primer_nodo);
	primer_nodo = nuevo_nodo;
	return primer_nodo;	
}

/*
Metodo que crea la lista con numeros aleatorios en un rango 
Entre los numeros 5 y 10.
Y la suma de ellos deben de dar 500.
*/
struct Nodo *crea_nodo_lista_random(struct Nodo *primer_nodo){
	int total = 0, num_random, posicion=0, contador_proceso = 0;
	struct Nodo *aux;

	while (total <= TAMANIO) { 
    	num_random = generador_random(5, 10); // Genera los numeros aleatorios.
    	primer_nodo = inserta_inicio(primer_nodo, num_random); // Se insertan los numeros a la lista.
    	total += num_random; // Suma todos los numeros para que la suma sea 500
   }

   	aux = primer_nodo;
	while(aux != NULL){ 
		aux->contador_proceso = 0; // Contabiliza que proceso lleva mas tiempo ocupado
		aux->posicion = posicion; // Contabiliza los nodos de la lista
		posicion++;
		aux = aux->siguiente_nodo;
	}

	//printf("Total: %d", total);
	return primer_nodo;	
}

struct Nodo *insertar_medio(struct Nodo *primer_nodo, int tamanio_particion) {
	struct Nodo *nuevo_nodo = crea_nodo(tamanio_particion, primer_nodo);
	struct Nodo *aux = primer_nodo;

	while(aux->siguiente_nodo!=NULL){
		aux = aux->siguiente_nodo;
	}
	
	aux->siguiente_nodo = nuevo_nodo;
	nuevo_nodo->siguiente_nodo = aux->siguiente_nodo;
		
	return primer_nodo;
	
}

struct Nodo *inserta_final(struct Nodo *primer_nodo, int tamanio_particion){
	if(esta_vacia(primer_nodo))
		return inserta_inicio(primer_nodo, tamanio_particion);

	// Creamos el nuevo nodo
	struct Nodo *nuevo_nodo =  crea_nodo(tamanio_particion, NULL);
	// Creamos el aux y lo posicionamos en el último nodo actual
	struct Nodo *aux = primer_nodo;
	while(aux->siguiente_nodo != NULL)
		aux = aux->siguiente_nodo;
		
	aux->siguiente_nodo = nuevo_nodo;
	return primer_nodo;
}

struct Nodo *borrar_inicio(struct Nodo *primer_nodo){
	if(esta_vacia(primer_nodo)){
		printf("\nNo hay nodos por borrar\n");
		return NULL;
	}
	struct Nodo *aux = primer_nodo;
	primer_nodo = primer_nodo->siguiente_nodo;
	free(aux);
	return primer_nodo;
}

struct Nodo *borrar_final(struct Nodo *primer_nodo){
	if(esta_vacia(primer_nodo)){
		printf("\nLa lista esta vacia\n");
		return NULL;
	}
	
	// Si solo hay un nodo
	if(primer_nodo->siguiente_nodo == NULL)
		return borrar_inicio(primer_nodo);
		
	struct Nodo *aux1 = primer_nodo;
	struct Nodo *aux2 = primer_nodo->siguiente_nodo;
	
	while(aux2->siguiente_nodo != NULL){
		aux1 = aux1->siguiente_nodo;
		aux2 = aux2->siguiente_nodo;
	}
	
	aux1->siguiente_nodo = NULL;
	free(aux2);
	
	return primer_nodo;
}

void imprime_lista(struct Nodo *primer_nodo){
	// Si la lista está vacia, solo mandamos un mensaje
	if(esta_vacia(primer_nodo)){
		printf("\nLa lista esta vacia\n");
		return;
	}
	
	printf("\nElementos de la lista ligada\n");
	while(primer_nodo != NULL){
		printf(" %d ",primer_nodo->tamanio_particion);
		primer_nodo = primer_nodo->siguiente_nodo; // avanza al siguiente nodo
	}
}
	
	
int buscar_nodo(struct Nodo *primer_nodo, int tamanio_particion){
	if(esta_vacia(primer_nodo)){
		printf("\nNo hay nodos\n");
		return -1;
	}
	
	while(primer_nodo != NULL){
		if(tamanio_particion == primer_nodo->tamanio_particion)
			return 1;
		primer_nodo = primer_nodo->siguiente_nodo;
	}
	return 0;	
}

/*
 * Metodo que encuentra la posicion de bloque de memoria que mejor se ajuste al proceso insertado
*/
int buscar_best_nodo(struct Nodo *primer_nodo, int tamanio_particion) {
	int best_posicion = -1; // Empieza desde afuera de la lista 
	int tamanio_nodo = 0; // Es el tamanio que tiene el nodo

	if(esta_vacia(primer_nodo)){ //Verifica que la lista este vacia 
		printf("\nNo hay nodos\n"); 
		return -1;
	}

	while (primer_nodo != NULL ){ //Recorre la lista 
		if(primer_nodo->tamanio_ocupado != 0) { // Contabiliza si un proceso tiene un valor en espacio ocupado
			primer_nodo->contador_proceso++; // Se aumenta el contador 
			if(primer_nodo->contador_proceso > CONTADOR) { // Si un proceso ya lleva mas de 5 unidades de tiempo se reinicia 
				primer_nodo->tamanio_ocupado = 0; // El tamanio ocupado se iniicaliza en 0 
				primer_nodo->tamanio_desocupado = primer_nodo->tamanio_particion; // El tamanio desocupado se reinicia al valor que tenia antes
				primer_nodo->contador_proceso = 0;	// Contador se inicializa en 0
			} 		
		} else {
			if (primer_nodo->tamanio_desocupado >= tamanio_particion) { // Verifica para poder insertar el proceso en el mejor bloque de memoria que se ajusta
				/*
				Comience eligiendo cada proceso y encuentre el tamanio de bloque mínimo 
				que se puede asignar al proceso por insertar
				*/
				if(best_posicion == -1) { 
					tamanio_nodo = primer_nodo->tamanio_desocupado;  
					best_posicion = primer_nodo->posicion;
				} else {
					/*
					Si no, deja ese proceso y sigue revisando
   					los procesos posteriores.
					*/
					if (tamanio_nodo > primer_nodo->tamanio_desocupado) { 
						best_posicion = primer_nodo->posicion; 
						tamanio_nodo = primer_nodo->tamanio_desocupado; 
					}
						
				}
			}
		}
		primer_nodo = primer_nodo->siguiente_nodo;
	}

	return best_posicion; // Se regresa la mejor posicion 
}

/*
 * Metodo que encuentra la posicion de bloque de memoria que peor se ajuste al proceso insertado
*/
int buscar_worst_nodo(struct Nodo *primer_nodo, int tamanio_particion) {
	int worst_posicion = -1; // Empieza desde afuera de la lista 
	int tamanio_nodo = 0; // Es el tamanio que tiene el nodo

	if(esta_vacia(primer_nodo)){ //Verifica que la lista este vacia 
		printf("\nNo hay nodos\n");
		return -1;
	}

	while (primer_nodo != NULL ){ //Recorre la lista 
		if(primer_nodo->tamanio_ocupado != 0) { // Contabiliza si un proceso tiene un valor en espacio ocupado
			primer_nodo->contador_proceso++;
			if(primer_nodo->contador_proceso > CONTADOR) {// Si un proceso ya lleva mas de 5 unidades de tiempo se reinicia 
				primer_nodo->tamanio_ocupado = 0; // El tamanio ocupado se iniicaliza en 0 
				primer_nodo->tamanio_desocupado = primer_nodo->tamanio_particion; // El tamanio desocupado se reinicia al valor que tenia antes
				primer_nodo->contador_proceso = 0;	// Contador se inicializa en 0
			} 		
		} else {
			if (primer_nodo->tamanio_desocupado >= tamanio_particion) { // Verifica para poder insertar el proceso en el peor bloque de memoria 
				/*
				Comience eligiendo cada proceso y encuentre el tamanio de bloque maximo 
				que se puede asignar al proceso por insertar
				*/
				if(worst_posicion == -1) {
					tamanio_nodo = primer_nodo->tamanio_desocupado;
					worst_posicion = primer_nodo->posicion;
				} else {
					/*
					Si no, deja ese proceso y sigue revisando
   					los procesos posteriores.
					*/
					if (tamanio_nodo < primer_nodo->tamanio_desocupado) { 
						worst_posicion = primer_nodo->posicion;
						tamanio_nodo = primer_nodo->tamanio_desocupado;
					}
				}
			}
		}
		primer_nodo = primer_nodo->siguiente_nodo;
	}
	return worst_posicion; // Se regresa la peor posicion para insertar
}

/*
 * Metodo que encuentra la posicion de bloque de memoria con el valor mas grande.
*/
int buscar_block_split(struct Nodo *primer_nodo, int tamanio_particion) {
	int worst_posicion = -1; // Empieza desde afuera de la lista 
	int tamanio_nodo = 0; // Es el tamanio que tiene el nodo
	int aux = (primer_nodo->tamanio_desocupado) / TAMANIO;


	if(esta_vacia(primer_nodo)){ //Verifica que la lista este vacia 
		printf("\nNo hay nodos\n");
		return -1;
	}

	while (primer_nodo != NULL ){ //Recorre la lista 
		if(primer_nodo->tamanio_ocupado != 0) { // Contabiliza si un proceso tiene un valor en espacio ocupado
			primer_nodo->contador_proceso++;
			if(primer_nodo->contador_proceso > CONTADOR) {// Si un proceso ya lleva mas de 5 unidades de tiempo se reinicia 
				primer_nodo->tamanio_ocupado = 0; // El tamanio ocupado se iniicaliza en 0 
				primer_nodo->tamanio_desocupado = primer_nodo->tamanio_particion; // El tamanio desocupado se reinicia al valor que tenia antes
				primer_nodo->contador_proceso = 0;	// Contador se inicializa en 0
			} 		
		} else {
			if (primer_nodo->tamanio_desocupado >= tamanio_particion) { // Verifica para poder insertar el proceso en el peor bloque de memoria 
				/*
				Comience eligiendo cada proceso y encuentre el tamanio de bloque maximo 
				que se puede asignar al proceso por insertar
				*/
				if(worst_posicion == -1) {
					tamanio_nodo = primer_nodo->tamanio_desocupado;
					worst_posicion = primer_nodo->posicion;
				} else {
					/*
					Si no, deja ese proceso y sigue revisando
   					los procesos posteriores.
					*/
					if (tamanio_nodo < primer_nodo->tamanio_desocupado/tamanio_particion ) { // Divido el tamanio_desocupado para que proceso pueda ser insertado
						worst_posicion = primer_nodo->posicion;
						tamanio_nodo = primer_nodo->tamanio_desocupado;
					}
				}
			}
		}
		primer_nodo = primer_nodo->siguiente_nodo;
	}
	return worst_posicion; // Se regresa la posicion con el valor mas grande para insertar
}

//Imprime solo una particion de la memoria
void imprimir_particion(struct Nodo *primer_nodo) {
	printf("       \t%d      \t|  %d      \t%d       \t%d    |",primer_nodo->contador_proceso,primer_nodo->tamanio_particion, 
	primer_nodo->tamanio_ocupado, primer_nodo->tamanio_desocupado);
}

//Imprime toda la memoria	
void estado_memoria(struct Nodo *primer_nodo) { 
    printf("\n*********************** MEMORIA *************************************\n");
    printf("\n    Contador     Valor      Ocupados      Desocupados");
    while (primer_nodo != NULL) { 
    	printf("\n");
        imprimir_particion(primer_nodo);
        primer_nodo = primer_nodo->siguiente_nodo; 
    } 
    printf("\n");
    printf("\n*********************************************************************\n");

} 


/*
Busca en la lista agujeros libres en la lista y asigna el primero en la lista que
sea lo suficientemente grande para acomodar al proceso deseado.
*/
void first_fit(struct Nodo *primer_nodo ){
    int i,tamanio_particion;
    
   	if(esta_vacia(primer_nodo)) { // Verifica que la lista este vacia 
		printf("\nLa lista esta vacia\n");
		return;
	}

	for(i = 0; i < 100; i++) { // Se le asigna 100 veces una particion a la lista
		tamanio_particion = generador_random(3, 10); // Genera los numeros aleatorios entre 3 y 10
		while(primer_nodo != NULL){ // Recorre la lista
			if(primer_nodo->tamanio_ocupado != 0) { // Contabiliza si un proceso tiene un valor en espacio ocupado
				primer_nodo->contador_proceso ++; // Se aumenta el contador 
				if(primer_nodo->contador_proceso  > CONTADOR){ // Si un proceso ya lleva mas de 5 unidades de tiempo se reinicia 
					primer_nodo->tamanio_ocupado = 0; // El tamanio ocupado se iniicaliza en 0 
					primer_nodo->tamanio_desocupado = primer_nodo->tamanio_particion; // El tamanio desocupado se reinicia al valor que tenia antes
					primer_nodo->contador_proceso = 0; // Contador se inicializa en 0
				}
			} else {
				if(tamanio_particion <= primer_nodo->tamanio_desocupado) { // Inserta el valor en el nodo 
					primer_nodo->tamanio_ocupado += tamanio_particion; // Se suma el valor insertado en el espacio ocupado
					primer_nodo->tamanio_desocupado -= tamanio_particion;// Resta el valor que tiene el tamnio desocupador menos el valor insertado
																			
					break;
				} 
			}
			primer_nodo = primer_nodo->siguiente_nodo; // Avanza al siguiente nodo
		}
	}
}

/*
Este metodo compara el tamaño de memoria requerido por el proceso con los agujeros libres
en la lista. Le asigna al proceso el agujero más pequeño que se ajuste al proceso.
*/
void best_fit(struct Nodo *primer_nodo) {
	int tamanio_particion, i;
	int best_posicion = -1;

	if(esta_vacia(primer_nodo)){ // Verifica que la lista este vacia 
		printf("\nLa lista esta vacia\n");
		return;
	}

	for (i = 0; i < 100; i++){ // Se le asigna 100 veces una particion a la lista
		tamanio_particion = generador_random(3, 10); // Genera los numeros aleatorios entre 3 y 10
		best_posicion = buscar_best_nodo(primer_nodo, tamanio_particion); // Empieza la busqueda para inserta el proceso 
		if( best_posicion != -1) { // Si se puede encontrar un bloque de memoria para el proceso insertado
			while (primer_nodo != NULL){ // Empieza a recorrer la lista 
				if(best_posicion == primer_nodo->posicion) { // Si el la posicion del bloque de memoria es igual a la posicion del nodo
					primer_nodo->tamanio_desocupado -= tamanio_particion; // Se suma el valor insertado en el espacio ocupado
					primer_nodo->tamanio_ocupado += tamanio_particion; // Resta el valor que tiene el tamnio desocupador menos el valor insertado
					break;
				}
				primer_nodo = primer_nodo->siguiente_nodo; // Avanza al siguiente nodo
			}
		}
	}
}

/*
Este metodo compara el tamaño de memoria requerido por el proceso con los agujeros libres
en la lista. Le asigna al proceso el agujero más grande.
*/
void worst_fit(struct Nodo *primer_nodo) {
	int i, tamanio_particion;
	int worst_posicion = -1;

	if(esta_vacia(primer_nodo)){ // Verifica que la lista este vacia 
		printf("\nLa lista esta vacia\n");
		return;
	}

	for (i = 0; i < 100; i++){ // Se le asigna 100 veces una particion a la lista
		tamanio_particion = generador_random(3, 10);  // Genera los numeros aleatorios entre 3 y 10
		worst_posicion = buscar_worst_nodo(primer_nodo, tamanio_particion); // Empieza la busqueda para inserta el proceso 
		if( worst_posicion != -1) { // Si se puede encontrar un bloque de memoria para el proceso insertado
			while (primer_nodo != NULL){ // Empieza a recorrer la lista 
				if(worst_posicion == primer_nodo->posicion) { // Si el la posicion del bloque de memoria es igual a la posicion del nodo
					primer_nodo->tamanio_desocupado -= tamanio_particion; // Se suma el valor insertado en el espacio ocupado
					primer_nodo->tamanio_ocupado += tamanio_particion; // Resta el valor que tiene el tamnio desocupador menos el valor insertado
					break;
				}
				primer_nodo = primer_nodo->siguiente_nodo; // Avanza al siguiente nodo
			}
		}
	}
}
/*
void fusionar_siguiente_nodo(struct Nodo *primer_nodo) {
    struct Nodo *siguiente_nodo = primer_nodo->siguiente_nodo;
    if (siguiente != NULL && !siguiente_nodo->tamanio_ocupado) {
       	// agrega el tamaño del siguiente bloque al bloque actual
        primer_nodo->tamanio_desocupado += primer_nodo->tamanio_desocupado;
        primer_nodo->tamanio_desocupado += TAMANIO;

		// eliminar el siguiente bloque de la lista
        primer_nodo->siguiente_nodo = primer_nodo->siguiente_nodo;
        if (primer_nodo->siguiente_nodo != NULL) {
            primer_nodo->siguiente_nodo->prev = primer_nodo;
        }
    }

}

void fusionar_anterior_nodo(struct Nodo *current_mem_node) {
    struct Nodo *anterior_nodo = primer_nodo->prev;
    if (anterior_nodo != NULL && !anterior_nodo->tamanio_ocupado) {
		// agrega el tamaño del bloque anterior al bloque actual        
		anterior_nodo->tamanio_desocupado += primer_nodo->tamanio_desocupado;
        anterior_nodo->tamanio_desocupado += TAMANIO;


		// eliminar el nodo actual de la lista
        anterior_nodo->siguiente_nodo = primer_nodo->siguiente_nodo;
        if (primer_nodo->siguiente_nodo != NULL) {
            primer_nodo->siguiente_nodo->prev = anterior_nodo;
        }
    }
}

void mem_free(struct Nodo *primer_nodo) {

    if(esta_vacia(primer_nodo)){ // Verifica que la lista este vacia 
		printf("\nLa lista esta vacia\n");
		return;
	}

	// obtener el nodo de memoria asociado con el puntero
    struct Nodo *aux = (struct Nodo *) (primer_nodo - TAMANIO);

	// el puntero que estamos tratando de liberar no se asignó dinámicamente
     if(esta_vacia(aux)){ // Verifica que la lista este vacia 
		printf("\nLa lista esta vacia\n");
		return;
	}

    // marcar el bloque como no utilizado
    aux->tamanio_ocupado = 0;

    // fusionar bloques no utilizados
    fusionar_siguiente_nodo(aux);
   fusionar_anterior_nodo(aux);
}*/

void block_splitting(struct Nodo *primer_nodo) {
	int i, tamanio_particion;
	int worst_posicion = -1;

	if(esta_vacia(primer_nodo)){ // Verifica que la lista este vacia 
		printf("\nLa lista esta vacia\n");
		return;
	}
	
	for (i = 0; i < 100; i++){ // Se le asigna 100 veces una particion a la lista
		tamanio_particion = generador_random(3, 10);  // Genera los numeros aleatorios entre 3 y 10
		worst_posicion = buscar_block_split(primer_nodo, tamanio_particion); // Empieza la busqueda para inserta el proceso 
		if( worst_posicion != -1) { // Si se puede encontrar un bloque de memoria para el proceso insertado
			while (primer_nodo != NULL){ // Empieza a recorrer la lista 
				if(worst_posicion == primer_nodo->posicion) { // Si el la posicion del bloque de memoria es igual a la posicion del nodo
					primer_nodo->tamanio_desocupado -= tamanio_particion; // Se suma el valor insertado en el espacio ocupado
					primer_nodo->tamanio_ocupado += tamanio_particion; // Resta el valor que tiene el tamnio desocupador menos el valor insertado
					break;
				}
				primer_nodo = primer_nodo->siguiente_nodo; // Avanza al siguiente nodo
			}
		}
	}
}

/*
void split(struct Nodo *primer_nodo){
	    int i=0, tamanio_particion;	

    	// Hacer que el puntero p1 apunte al primer nodo
    	struct Nodo *p1= primer_nodo;
		for(i = 0; i < 100; i++) {
			tamanio_particion = generador_random(3, 10);
			while(primer_nodo != NULL){
				if(primer_nodo->tamanio_ocupado != 0) { // Contabiliza si un proceso tiene un valor en espacio ocupado
					primer_nodo->contador_proceso ++; // Se aumenta el contador 
					if(primer_nodo->contador_proceso  > CONTADOR){ // Si un proceso ya lleva mas de 5 unidades de tiempo se reinicia 
						primer_nodo->tamanio_ocupado = 0; // El tamanio ocupado se iniicaliza en 0 
						primer_nodo->tamanio_desocupado = primer_nodo->tamanio_particion; // El tamanio desocupado se reinicia al valor que tenia antes
						primer_nodo->contador_proceso = 0; // Contador se inicializa en 0
					}
				} else {
					if(tamanio_particion < primer_nodo->tamanio_desocupado/tamanio_particion){			
						p1->tamanio_desocupado -= tamanio_particion; // Se suma el valor insertado en el espacio ocupado
						p1->tamanio_ocupado += tamanio_particion;
					}
				}
        		primer_nodo = primer_nodo->siguiente_nodo;
	    	}
		}

		p1->siguiente_nodo = NULL;
}*/

int main(){
	int opcion;

	// Creamos la lista ligada
	struct Nodo *primer_nodo = NULL;

	
	while(1){
		
		printf("\n\nElija un algoritmo:");
		printf("\n1. Crear Lista\n2. First-fit\n3. Best-fit\n4. Worst-fit\n5. Block-splitting\n6. Salir");
		printf("\nIntroduce opcion: ");
		scanf("%d",&opcion);
		
		switch(opcion){	

			case 1:
				//srand(time(0));
				primer_nodo = crea_nodo_lista_random(primer_nodo);
				estado_memoria(primer_nodo);
				break;

			case 2:
				srand(time(0));
				first_fit(primer_nodo); 
				printf("\n\t\t    ---FIRST-FIT---");
				estado_memoria(primer_nodo);
				break;
				
			case 3:
				srand(time(0));
				best_fit(primer_nodo);
				printf("\n\t\t    ---BEST-FIT---");
				estado_memoria(primer_nodo);
				break;
				
			case 4:
				srand(time(0));
				worst_fit(primer_nodo);	
				printf("\n\t\t    ---WORST-FIT---");
				estado_memoria(primer_nodo);
				break;
				
			case 5:
				srand(time(0));
				block_splitting(primer_nodo);
				printf("\n\t\t   ---BLOCK-SPLITTING---");
				estado_memoria(primer_nodo);
				break;
				
			case 6:
				exit(0);
				
			default:
				printf("\nOpcion invalida\n");
				break;
		}
	
	}
	return 0;
}