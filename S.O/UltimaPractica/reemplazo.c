//Olvera Monroy Gonzalo

#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <unistd.h>

/*
bandera:  tendra valor 1 si la pagina que pide lugar ya esta en memoria
				en otro caso tendra valor 0 y se llevara a cabo un reemplazo
bandera2: tendra valor 1 si la pagina que pide lugar ya esta en memoria
                si no tendra valor de 0 y se podra hacer el reemplazo.
                Tambien es para verificar que no haya marcos y tampoco referencia
                a la pagina. 
lugar_a_ocupar: indica el indice en arreglo de marcos donde se va a reemplazar
				la pagina correspondiente
i: es el indice para recorrer el arreglo de peticiones
j: es el indice para recorrer el arreglo de marcos
marcos[]:  los marcos donde se agregaran las paginas entrantes
peticiones[]:  va a contener las paginas que piden memoria
cont: es el indice para recorrer las unidades de tiempo
*/
int num_peticiones, num_marcos, num_fallas = 0;
int bandera, lugar_a_ocupar = 0;
int i, j, k;
int bandera2;
int cont = 0;
int bandera_imprime_X; //Imprime las X de donde fallo

/*
El codigo para FIFO lo proporciono el profesor en clase 
*/
void fifo(int *peticiones, int *marcos) {
    printf("\n\t      ---FIFO---\n");
    for(i = 0; i < num_marcos; i++)
		marcos[i] = -1;  // -1 significa que ese marco esta desocupado
	 num_fallas = 0;

	for(i = 0; i < num_peticiones; i++){ // Se recorre todas las peticiones 
		bandera = 0; 
		bandera_imprime_X = 0; 
		for(j = 0; j < num_marcos; j++){
			if(marcos[j] == peticiones[i])
				bandera = 1; // Si esta la pagina en memoria y entonces NO hay reemplazo
                bandera_imprime_X = 0; 
		}
		
		// Si bandera == 0 la pagina entrante no esta en memoria y SI hay reemplazo
		if(bandera == 0){
			num_fallas++;
			marcos[lugar_a_ocupar] = peticiones[i];
            bandera_imprime_X = 1; 
			lugar_a_ocupar = (lugar_a_ocupar+1)%num_marcos;
		}	
        //Imprime en donde hay falla

        if(bandera_imprime_X == 1){
            printf("\t X   ");
        } else{
            printf("\t     ");
        }
        for(j = 0; j < num_marcos; j++){
           printf("\t%d ", marcos[j]); // Imprime la memoria en horizontal           
        }
        printf("\n");	
	} // For principal

    printf("\n\tNumero de fallas Fifo = %d con %d marcos\n",num_fallas, num_marcos);
    sleep(2);

}

/*
Este algoritmo elige al azar una pagina para ser reemplazada
*/
void aleatorio(int *peticiones, int *marcos, int *tiempo) {
    printf("\n\t      ---RANDOM ---\n");
    srand(time(0));

    for(i = 0; i < num_marcos ; i++){
        marcos[i] = -1; // -1 significa que ese marco esta desocupado
    }

    num_fallas = 0;
    
    for(i = 0; i < num_peticiones; i++){ // Se recorre todas las peticiones 
        bandera = 0;
        bandera2 = 0;
        bandera_imprime_X = 0; 
        for(j = 0; j < num_marcos; j++){
            if(marcos[j] == peticiones[i]){ // cuenta cada vez que aparece el número
                cont++; // Incrementa la unidad de tiempo en el marco
                tiempo[j] = cont; 
                bandera = 1; // Si esta la pagina en memoria y entonces NO hay reemplazo
                bandera2 = 1;
                bandera_imprime_X = 0;  
            }
        }
        if(bandera == 0){ // Si bandera == 0 la pagina entrante no esta en memoria y SI hay reemplazo
            for(j = 0; j < num_marcos; j++){
                if(marcos[j] == -1){  //Si todavia el arreglo de marcos tiene lugares vacios 
                    cont++; // Incrementa la unidad de tiempo en el marco
                    num_fallas++; // Incrementa el numero de fallas 
                    marcos[j] = peticiones[i];
                    tiempo[j] = cont; 
                    bandera2 = 1; //
                    bandera_imprime_X = 1; 
                    break;
                }
            }
        }
        int random_posicion;
        if(bandera2 == 0){ // De lo contrario hace el reemplazo
            random_posicion = rand()%num_marcos; // Elige cualquier marco 
            lugar_a_ocupar = tiempo[random_posicion];
            cont++; // Incrementa la unidad de tiempo en el marco
            num_fallas++; // Incrementa el numero de fallas 
            bandera_imprime_X = 1; 
            marcos[lugar_a_ocupar] = peticiones[i];
            tiempo[lugar_a_ocupar] = cont; 
        }
        //Imprime en donde hay falla

        if(bandera_imprime_X == 1){
            printf("\t X   ");
        } else{
            printf("\t     ");
        }
        for(j = 0; j < num_marcos; j++){
            printf("\t%d ", marcos[j]); // Imprime la memoria en horizontal
        }
        printf("\n");
    } // For principal
    printf("\n\tNumero de fallas Random = %d con %d marcos\n",num_fallas, num_marcos);
    sleep(2);
}

/*
Este algoritmo consiste en que a cada pagina en los marcos se le asigna un bit (de oportunidad). 
El valor del bit va a definir si la siguiente al frente de la cola sale o no. 
*/
void segunda_oportunidad(int *peticiones, int *marcos, int *bit) {
    printf("\n\t    ---FIFO - SEGUNDA OPORTUNIDAD ---\n");
    
    for (i = 0; i < num_marcos; i++) {
        marcos[i] = -1; // -1 significa que ese marco esta desocupado
        bit[i] = 0; // 0 significa que ese pagina inicia en ese valor
    }

    num_fallas = 0;

    for (i = 0; i < num_peticiones; i++){ // Se recorre todas las peticiones 
        bandera = 0; // bandera para las páginas encontradas
        bandera_imprime_X = 0;
        for (j = 0; j < num_marcos; j++){
            if (marcos[j] == peticiones[i]){ // si se encuentra el elemento, use el bit a 1 y finalice el ciclo
                bandera = 1; // Si esta la pagina en memoria y entonces NO hay reemplazo
                bandera_imprime_X = 0; 
                bit[j] = 1;
                break;
            } 
        }
        if (bandera == 0){ // si el elemento no se encuentra
            while(bandera != 1){
                // si la memorira todavía tiene lugares vacíos
                if(bit[lugar_a_ocupar] == 0){// si bit = 0 podemos agregar una página
                    num_fallas++; //incrementa num_fallas
                    bandera = 1; // Si esta la pagina en memoria y entonces NO hay reemplazo
                    bandera_imprime_X = 1;
                    bit[lugar_a_ocupar] = 1;
                    marcos[lugar_a_ocupar] = peticiones[i];
                /*
                La memoria está lleno, establece la segunda oportunidad en 0
                para eliminar esa página de la memoria la próxima vez
                */
                } else {
                    bit[lugar_a_ocupar] = 0;// si no, establece el bit de uso en 0
                }
                lugar_a_ocupar = (lugar_a_ocupar+1)%num_marcos;
            }
        }
        //Imprime en donde hay falla

        if(bandera_imprime_X == 1){
            printf("\t X   ");
        } else{
            printf("\t     ");
        }
        for(j = 0; j < num_marcos; j++){
           printf("\t%d ", marcos[j]); // Imprime la memoria en horizontal
        }
        printf("\n");
    } // For principal

    printf("\n\tNumero de fallas FIFO - Segunda Oportunidad = %d con %d marcos\n",num_fallas, num_marcos);
    sleep(2);
}

/*
Este algoritmo debe de reemplazar la página que no va a ser usada por el periodo más largo de tiempo.
*/
void optimo(int *peticiones, int *marcos, int *tiempo) {
    printf("\n\t      ---OPTIMO---\n");
    int maximo,bandera3; //bandera3 es la encargada de reemplazar a la pagina que este mas alejado
    for (i = 0; i < num_marcos; i++) {
        marcos[i] = -1; // -1 significa que ese marco esta desocupado
    }

    num_fallas = 0;

    for(i = 0; i < num_peticiones; i++){
        bandera = 0;
        bandera2 = 0;
        bandera_imprime_X = 0;
        // Si la página existe en la memoria
        for(j = 0; j < num_marcos; j++){
            if(marcos[j] == peticiones[i]){
                //Si esta la pagina en memoria y entonces NO hay reemplazo
                bandera = 1;
                bandera2 = 1;
                bandera_imprime_X = 0;
                break;
               }
        }

        if(bandera == 0){ // si no está en la memoria 
            for(j = 0; j < num_marcos; j++){
                if(marcos[j] == -1){ // si la memoria todavía tiene lugares vacíos
                    num_fallas++;
                    marcos[j] = peticiones[i];
                    bandera2 = 1;
                    bandera_imprime_X = 1;
                    break; 
                }
            }
        }
        // si no hay un lugar vacío, entonces la página falla
        if(bandera2 == 0){ // verifica si una página es adecuada para reemplazarla
            bandera3 = 0;
            // verifica si los números en la memoria aparecerán más tarde o no
            for(j = 0; j < num_marcos; j++){
                tiempo[j] = -1;
                
                // Se comienza en i + 1, porque vamos hacia adelante, entonces
                // no es necesario comparar a partir de 0, o en i
                for(k = i + 1; k < num_peticiones; k++){
                    if(marcos[j] == peticiones[k]){
                        tiempo[j] = k;
                        break;
                    }
                }
            }

            for(j = 0; j < num_marcos; j++){
                /*
                si no aparece más adelante en la entrada 
                guarda su posición para reemplazarla con otra página
                */
                if(tiempo[j] == -1){
                    lugar_a_ocupar = j;
                    bandera3 = 1;
                    bandera_imprime_X = 1;
                    break;
                }
            }

            /* 
            Si todos ellos aparecerán más tarde
            elige uno para eliminarlo de la memoria
            */
            if(bandera3 ==0){
                maximo = tiempo[0];
                lugar_a_ocupar = 0;

                 // es el más lejano, al comparar lugar_a_ocupar con el máximo.
                for(j = 1; j < num_marcos; j++){
                    if(tiempo[j] > maximo){
                        maximo = tiempo[j];
                        lugar_a_ocupar = j;
                    }
                }
            }
            bandera_imprime_X = 1;
            num_fallas++;
            marcos[lugar_a_ocupar] = peticiones[i];
        }

        //Imprime en donde hay falla
        if(bandera_imprime_X == 1){
            printf("\t X   ");
        }
        else{
            printf("\t     ");
        }
        for(j = 0; j < num_marcos; j++){
            printf("\t%d ", marcos[j]); // Imprime la memoria en horizontal
        }
        printf("\n");
    } // For principal

    printf("\n\tNumero de fallas en Optimo = %d con %d marcos\n",num_fallas, num_marcos);
    sleep(2);
}

/*
En este algoritmo se elige, para reemplazar a la página que más
tiempo lleve sin ser usada.
*/
void lru(int *peticiones, int *marcos, int *tiempo) {
    printf("\n\t        ---LRU---\n");
    int min;
   
     for(i = 0; i < num_marcos ; i++){
        marcos[i] = -1; // -1 significa que ese marco esta desocupado
    }

     num_fallas = 0;

    for(i = 0; i < num_peticiones; i++){
        bandera = 0;
        bandera2 = 0; 
        bandera_imprime_X = 0;
        for(j = 0; j < num_marcos; j++){
            if(marcos[j] == peticiones[i]){ // cuenta cada vez que aparece el número
                cont++; // Incrementa la unidad de tiempo en el marco
                tiempo[j] = cont; 
                bandera = 1; // Si esta la pagina en memoria y entonces NO hay reemplazo
                bandera2 = 1; // Si esta en la pagina 
                bandera_imprime_X = 0;
            }
        }
        if(bandera == 0){ // Si bandera == 0 la pagina entrante no esta en memoria y SI hay reemplazo
            for(j = 0; j < num_marcos; j++){
                if(marcos[j] == -1){  //Si todavia el arreglo de marcos tiene lugares vacios 
                    cont++; // Incrementa la unidad de tiempo en el marco
                    num_fallas++; // Incrementa el numero de fallas 
                    marcos[j] = peticiones[i];
                    tiempo[j] = cont; 
                    bandera2 = 1; //
                    bandera_imprime_X = 1;
                    break;
                }
            }
        }
       
        if(bandera2 == 0){ // De lo contrario hace el reemplazo
            min = tiempo[0];
            lugar_a_ocupar = 0;
            for(j = 1; j < num_marcos; j++){
                if(tiempo[j] < min){ 
                    min = tiempo[j];
                    lugar_a_ocupar = j;
                }   
            }

            //lugar_a_ocupar = encuentra_LRU(tiempo, num_marcos);// Empieza a buscar que peticion ha sido menos usada 
            cont++; // Incrementa la unidad de tiempo en el marco
            num_fallas++; // Incrementa el numero de fallas 
            bandera_imprime_X = 1;
            marcos[lugar_a_ocupar] = peticiones[i];
            tiempo[lugar_a_ocupar] = cont; 
        }
        //Imprime en donde hay falla
        if(bandera_imprime_X == 1){
            printf("\t X   ");
        } else{
            printf("\t     ");
        }
        for(j = 0; j < num_marcos; j++){
            printf("\t%d ", marcos[j]); // Imprime la memoria en horizontal
        }
        printf("\n");
    } // For principal
        printf("\n\tNumero de fallas en LRU = %d con %d marcos\n",num_fallas, num_marcos);
        sleep(2);
}

int main(){
	srand(time(0));
	printf("\nIntroduce el numero de peticiones: ");
	scanf("%d",&num_peticiones);
	int peticiones[num_peticiones];

    printf("\nIntroduce las peticiones:\n");
	for(i = 0; i < num_peticiones; i++){
        scanf("%d", &peticiones[i]);
    }

    
    printf("\nLas paginas son: \n");
    for ( i = 0;  i< num_peticiones; i++){
        printf(" %d", peticiones[i]);
    }
    
	
	printf("\n\nIntroduce el numero de marcos: ");
	scanf("%d",&num_marcos);
	int marcos[num_marcos], tiempo[num_marcos];
    int bit[num_marcos];
    int opcion;

    fifo(peticiones, marcos);
    segunda_oportunidad(peticiones, marcos, bit);
    optimo(peticiones, marcos,tiempo);
    lru(peticiones, marcos, tiempo);
    aleatorio(peticiones, marcos, tiempo);

    return 0;
}
