#include <sys/types.h>
#include <unistd.h>
#include <sys/wait.h>
#include <stdio.h>
#include <sys/ipc.h>
#include <sys/shm.h>


int main()
{
  int tid1;
  int status;
  int* shm;
  long ide_mem_com;

  //int *x;
  //x = (int *)malloc(sizeof(int));   memoria dinámica

  ide_mem_com=shmget(5623, 2, IPC_CREAT|0666);   //--chmod r w x    110
  shm=shmat(ide_mem_com,NULL,0);

  *shm=0;     //inicializa la variable compartida a 0

  tid1=fork();

  if(tid1!=0)     //soy el padre
  {

  wait(&status);   
   
  //sleep(6);
  //usleep(10000);	  
  printf("soy el padre la variable compartida actualizada es %d\n",*shm);
  }

  else{
  //  sleep(5);   
    printf("soy el hijo y voy a incrementar la variable\n");
    *shm=*shm+1;

    }

}
