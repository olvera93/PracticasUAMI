#include<stdlib.h>
#include<stdio.h>
#include<unistd.h>

int main()
{
   printf("antes del execl\n");
   execl("./execl2","pru","hola","mundo",NULL);
   printf("despues del execl\n");  //NUNCA SE EJECUTA
	
   return 0;

}

