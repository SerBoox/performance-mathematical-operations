
import java.io.PrintStream;
import java.sql.Timestamp;
import java.time.Instant;

import javax.print.StreamPrintServiceFactory;

public class Main {

    public static void main(String[] args) {
        /*
        $ java --version
            openjdk 9.0.4
            OpenJDK Runtime Environment (build 9.0.4+11)
            OpenJDK 64-Bit Server VM (build 9.0.4+11, mixed mode)
        $ javac --version
            javac 9.0.4
        $ javac Main.java && java Main && rm Tests.class && rm Main.class
            Addition ops: 33120389 67240778
            Addition 1000000 cycles (milliseconds): 6.000000
            Subtraction ops: 32174818 -63349636
            Subtraction 1000000 cycles (milliseconds): 7.000000
            Multiplication ops: 33146409 0
            Multiplication 1000000 cycles (milliseconds): 7.000000
            Division ops: 32591513 0
            Division 1000000 cycles (milliseconds): 10.000000
        */

        Tests tests = new Tests();
        tests.startTests();
    }
}

class Tests {

    public void startTests() {
        long cycle = this.additionSecond();
        this.additionCycles(cycle);
        cycle = this.subtractionSecond();
        this.subtractionCycles(cycle);
        cycle = this.multiplicationSecond();
        this.multiplicationCycles(cycle);
        cycle = this.divisionSecond();
        this.divisionCycles(cycle);
    }

    private long additionSecond() {
        Timestamp startTime = new Timestamp(System.currentTimeMillis());
        Timestamp finishTime = new Timestamp(startTime.getTime() + 1000);
        long value = (long) Math.pow(10, 6);
        long count = 0;
        while (System.currentTimeMillis() <= finishTime.getTime()) {
            value += 2;
            count++;
        }
        System.out.printf("Addition ops: %d %d\n", count, value);
        return count;
    }

    private void additionCycles(long maxCycles) {
        Timestamp startTime = new Timestamp(System.currentTimeMillis());
        long cycles = 0;
        if (maxCycles >= (int) Math.pow(10, 6)) {
            maxCycles = (int) Math.pow(10, 6);
        }
        long value = (long) Math.pow(10, 6);
        while (cycles <= maxCycles) {
            value += 2;
            cycles++;
        }
        Timestamp finishTime = new Timestamp(System.currentTimeMillis());
        String.format("%d", value);
        double diffTime = (double) (getUnixNano(finishTime) - getUnixNano(startTime)) / Math.pow(10, 6);
        
        System.out.printf("Addition %d cycles (milliseconds): %f\n", maxCycles, diffTime);
    }

    private long subtractionSecond() {
        Timestamp startTime = new Timestamp(System.currentTimeMillis());
        Timestamp finishTime = new Timestamp(startTime.getTime() + 1000);
        long value = (long) Math.pow(10, 6);
        long count = 0;
        while (System.currentTimeMillis() <= finishTime.getTime()) {
            value -= 2;
            count++;
        }
        System.out.printf("Subtraction ops: %d %d\n", count, value);
        return count;
    }

    private void subtractionCycles(long maxCycles) {
        Timestamp startTime = new Timestamp(System.currentTimeMillis());
        long cycles = 0;
        if (maxCycles >= (int) Math.pow(10, 6)) {
            maxCycles = (int) Math.pow(10, 6);
        }
        long value = (long) Math.pow(10, 6);
        while (cycles <= maxCycles) {
            value -= 2;
            cycles++;
        }
        Timestamp finishTime = new Timestamp(System.currentTimeMillis());
        String.format("%d", value);
        double diffTime = (double) (getUnixNano(finishTime) - getUnixNano(startTime)) / Math.pow(10, 6);
        
        System.out.printf("Subtraction %d cycles (milliseconds): %f\n", maxCycles, diffTime);
    }

    private long multiplicationSecond() {
        Timestamp startTime = new Timestamp(System.currentTimeMillis());
        Timestamp finishTime = new Timestamp(startTime.getTime() + 1000);
        long value = (long) Math.pow(10, 6);
        long count = 0;
        while (System.currentTimeMillis() <= finishTime.getTime()) {
            value *= 2;
            count++;
        }
        System.out.printf("Multiplication ops: %d %d\n", count, value);
        return count;
    }

    private void multiplicationCycles(long maxCycles) {
        Timestamp startTime = new Timestamp(System.currentTimeMillis());
        long cycles = 0;
        if (maxCycles >= (int) Math.pow(10, 6)) {
            maxCycles = (int) Math.pow(10, 6);
        }
        long value = (long) Math.pow(10, 6);
        while (cycles <= maxCycles) {
            value *= 2;
            cycles++;
        }
        Timestamp finishTime = new Timestamp(System.currentTimeMillis());
        String.format("%d", value);
        double diffTime = (double) (getUnixNano(finishTime) - getUnixNano(startTime)) / Math.pow(10, 6);
        
        System.out.printf("Multiplication %d cycles (milliseconds): %f\n", maxCycles, diffTime);
    }

    private long divisionSecond() {
        Timestamp startTime = new Timestamp(System.currentTimeMillis());
        Timestamp finishTime = new Timestamp(startTime.getTime() + 1000);
        long value = (long) Math.pow(10, 6);
        long count = 0;
        while (System.currentTimeMillis() <= finishTime.getTime()) {
            value /= 2;
            count++;
        }
        System.out.printf("Division ops: %d %d\n", count, value);
        return count;
    }

    private void divisionCycles(long maxCycles) {
        Timestamp startTime = new Timestamp(System.currentTimeMillis());
        long cycles = 0;
        if (maxCycles >= (int) Math.pow(10, 6)) {
            maxCycles = (int) Math.pow(10, 6);
        }
        long value = (long) Math.pow(10, 6);
        while (cycles <= maxCycles) {
            value /= 2;
            cycles++;
        }
        Timestamp finishTime = new Timestamp(System.currentTimeMillis());
        String.format("%d", value);
        double diffTime = (double) (getUnixNano(finishTime) - getUnixNano(startTime)) / Math.pow(10, 6);
        
        System.out.printf("Division %d cycles (milliseconds): %f\n", maxCycles, diffTime);
    }

    private long getUnixNano(Timestamp timestamp) {
        Instant instant = timestamp.toInstant();
        long seconds = instant.getEpochSecond();
        seconds *= Math.pow(10, 9);
        return seconds + (long) instant.getNano();
    }
}