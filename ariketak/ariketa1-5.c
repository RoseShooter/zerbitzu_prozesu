#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

int main() {
    int num_children;
    
    printf("Zenbat seme sortu nahi dituzu? ");
    scanf("%d", &num_children);
    
    if (num_children <= 0) {
        printf("Mesedez, sartu 0 baino handiagoa den zenbaki bat.\n");
        return 1;
    }
    
    printf("Aita (PID: %d)\n", getpid());
    
    for (int i = 0; i < num_children; i++) {
        pid_t pid = fork();
        
        if (pid < 0) {
            perror("fork failed");
            return 1;
        } else if (pid == 0) {
            // Semean gaude
            printf("Semea %d (PID: %d, PPID: %d)\n", i+1, getpid(), getppid());
            return 0; // Semeak bukatzen du
        }
    }
    
    // Aita seme guztien itxaroten
    for (int i = 0; i < num_children; i++) {
        wait(NULL);
    }
    
    printf("Aita (PID: %d): Seme guztiak bukatu dute\n", getpid());
    
    return 0;
}