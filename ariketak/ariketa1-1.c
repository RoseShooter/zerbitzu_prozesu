#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>

int main() {
    pid_t pid = fork();  // Aitak semea sortzen du

    if (pid < 0) {
        perror("fork failed");
        return 1;
    } else if (pid == 0) {
        // Semean gaude
        printf("Semea nahiz (PID: %d, PPID: %d)\n", getpid(), getppid());

        pid_t pid2 = fork();  // Semeak biloba sortzen du

        if (pid2 < 0) {
            perror("fork failed");
            return 1;
        } else if (pid2 == 0) {
            // Biloban gaude
            printf("Biloba nahiz (PID: %d, PPID: %d)\n", getpid(), getppid());
        }

    } else {
        // Aitan gaude
        printf("Aita nahiz (PID: %d), nire sema %d da\n", getpid(), pid);
    }

    return 0;
}
