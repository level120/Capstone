#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <string.h>

#define TIME_LIMIT 3

void *timer_noti_thread(void *dat) {
    struct timespec s, g;
    clock_gettime(CLOCK_MONOTONIC, &s);
    g = s;
    
    //system("./notification.py 1 2");
    
    while ((g.tv_sec - s.tv_sec) < TIME_LIMIT) {
        sleep(1);
        clock_gettime(CLOCK_MONOTONIC, &g);
    }
}

int main(int argc, char* argv[]) {    
    pthread_t p;
    
    pthread_create(&p, 0, timer_noti_thread, 0);
    fprintf(stderr, "%p : d\n", p);
    pthread_join(p, 0);
    
    if ( p == NULL ) {
        fprintf(stderr, "here\n");
    }
    
    fprintf(stderr, "fin\n");
    return 0;
}

/*
    if p != 0 -> timer run
*/