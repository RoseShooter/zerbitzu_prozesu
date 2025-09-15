#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>

int main(){
    pid_t pid1, pid2;

    //Aitak lehenengo semea sortzen du
    pid1 = fork();

    if(pid1 < 0){
        perror("fork failed");
        return 1;
    } else if(pid1 == 0){
        //Lehen semean gaude
        printf("Lehen semea: (PID: %d, PPID: %d)\n", getpid(), getppid());
        return 0; //Semeak  ez du bilobarik sortzen
    }

    pid2 = fork();
    
    if (pid2 < 0)
    {
        perror("fork failed");
        return 1;
    }
    else if (pid2 == 0)
    //Bigarren semean gaude
    {
        printf("Bigarren semea: (PID: %d, PPID: %d)\n", getpid(), getppid());
        return 0;
    }

    printf("Aita (PID: %d), semeak: %d eta %d\n", getpid(), pid1, pid2);

    return 0;
    
    
}