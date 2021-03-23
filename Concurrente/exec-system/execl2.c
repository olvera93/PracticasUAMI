#include<stdlib.h>
#include<stdio.h>
#include<unistd.h>

int main(int argc, char* argv[])
{
   printf("soy execl2 %d  %s  %s %s\n",argc,argv[0],argv[1],argv[2]);
   sleep(10);	
   return 0;

}

