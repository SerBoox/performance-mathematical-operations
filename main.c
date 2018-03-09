#include <stdio.h>
#include <math.h>
#include <time.h>
#include <sys/time.h>

int additionSecond();

void additionCycles(int maxCycles);

int subtractionSecond();

void subtractionCycles(int maxCycles);

int multiplicationSecond();

void multiplicationCycles(int maxCycles);

int divisionSecond();

void divisionCycles(int maxCycles);

/**
 * Returns the current time in microseconds.
 */
long getMicroTime();

int main() {

    /*
        $ gcc --version
            gcc (GCC) 7.3.1 20180130 (Red Hat 7.3.1-2)
            Copyright (C) 2017 Free Software Foundation, Inc.
            This is free software; see the source for copying conditions.  There is NO
            warranty; not even for MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
        $ gcc main.c -o main && ./main
            Addition ops: 452576811 906153622
            Addition 1000000 cycles (milliseconds): 2.453000
            Subtraction ops: 521797940 -1042595880
            Subtraction 1000000 cycles (milliseconds): 2.613000
            Multiplication ops: 477303302 inf
            Multiplication 1000000 cycles (milliseconds): 3.719000
            Division ops: 314385786 0.000000
            Division 1000000 cycles (milliseconds): 7.333000 
    */

    int cycles = additionSecond();
    additionCycles(cycles);
    cycles = subtractionSecond();
    subtractionCycles(cycles);
    cycles = multiplicationSecond();
    multiplicationCycles(cycles);
    cycles = divisionSecond();
    divisionCycles(cycles);
    return 0;
}

int additionSecond() {
    const time_t startTime = time(NULL);
    struct tm *u = localtime(&startTime);
    u->tm_sec += 1;
    const time_t finishTime = mktime(u);
    int value = (int) pow(10, 6);
    int count = 0;
    while (time(NULL) <= finishTime) {
        value += 2;
        count++;
    }
    printf("Addition ops: %d %d\n", count, value);
    return count;
}

void additionCycles(int maxCycles) {
    const long startTime = getMicroTime();
    int cycles = 0;
    if (maxCycles >= (int) pow(10, 6)) {
        maxCycles = (int) pow(10, 6);
    }
    int value = (int) pow(10, 6);
    while (cycles <= maxCycles) {
        value += 2;
        cycles++;
    }

    double timeDiff = (double) (getMicroTime() - startTime) / (int) pow(10, 3);
    printf("Addition %d cycles (milliseconds): %lf\n", maxCycles, timeDiff);
}

int subtractionSecond() {
    const time_t startTime = time(NULL);
    struct tm *u = localtime(&startTime);
    u->tm_sec += 1;
    const time_t finishTime = mktime(u);
    int value = (int) pow(10, 6);
    int count = 0;
    while (time(NULL) <= finishTime) {
        value -= 2;
        count++;
    }
    printf("Subtraction ops: %d %d\n", count, value);
    return count;
}

void subtractionCycles(int maxCycles) {
    const long startTime = getMicroTime();
    int cycles = 0;
    if (maxCycles >= (int) pow(10, 6)) {
        maxCycles = (int) pow(10, 6);
    }
    int value = (int) pow(10, 6);
    while (cycles <= maxCycles) {
        value -= 2;
        cycles++;
    }

    double timeDiff = (double) (getMicroTime() - startTime) / (int) pow(10, 3);
    printf("Subtraction %d cycles (milliseconds): %lf\n", maxCycles, timeDiff);
}

int multiplicationSecond() {
    const time_t startTime = time(NULL);
    struct tm *u = localtime(&startTime);
    u->tm_sec += 1;
    const time_t finishTime = mktime(u);
    double value = pow(10, 6);
    int count = 0;
    while (time(NULL) <= finishTime) {
        value *= 2;
        count++;
    }
    printf("Multiplication ops: %d %lf\n", count, value);
    return count;
}

void multiplicationCycles(int maxCycles) {
    const long startTime = getMicroTime();
    int cycles = 0;
    if (maxCycles >= (int) pow(10, 6)) {
        maxCycles = (int) pow(10, 6);
    }
    double value = pow(10, 6);
    while (cycles <= maxCycles) {
        value *= 2;
        cycles++;
    }

    double timeDiff = (double) (getMicroTime() - startTime) / (int) pow(10, 3);
    printf("Multiplication %d cycles (milliseconds): %lf\n", maxCycles, timeDiff);
}

int divisionSecond() {
    const time_t startTime = time(NULL);
    struct tm *u = localtime(&startTime);
    u->tm_sec += 1;
    const time_t finishTime = mktime(u);
    double value = pow(10, 6);
    int count = 0;
    while (time(NULL) <= finishTime) {
        value /= 2;
        count++;
    }
    printf("Division ops: %d %lf\n", count, value);
    return count;
}

void divisionCycles(int maxCycles) {
    const long startTime = getMicroTime();
    int cycles = 0;
    if (maxCycles >= (int) pow(10, 6)) {
        maxCycles = (int) pow(10, 6);
    }
    double value = pow(10, 6);
    while (cycles <= maxCycles) {
        value /= 2;
        cycles++;
    }

    double timeDiff = (double) (getMicroTime() - startTime) / (int) pow(10, 3);
    printf("Division %d cycles (milliseconds): %lf\n", maxCycles, timeDiff);
}

long getMicroTime() {
    struct timeval currentTime;
    gettimeofday(&currentTime, NULL);
    return currentTime.tv_sec * (int) 1e6 + currentTime.tv_usec;
}