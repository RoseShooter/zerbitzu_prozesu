#include <stdio.h>
#include <sys/types.h>
#include <unistd.h>

int main() {
   pid_t pid;

   pid = fork();
   if (pid == -1) { //Error has occurred
      printf("Failed to create child process\n");
   }
   else if (pid == 0) { //child enters here
      printf("Hello from child process! My PID is %d\n", getpid());
   }
   else { //Parent enters here
      printf("Hello from parent process! My PID is %d\n", getpid());
      printf("Hello from parent process! My child PID is %d\n", pid);
   }

   return 0;
}