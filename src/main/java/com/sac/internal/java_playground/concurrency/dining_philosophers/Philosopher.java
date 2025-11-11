package com.sac.internal.java_playground.concurrency.dining_philosophers;

public class Philosopher implements Runnable{

    private Object leftFork;
    private Object rightFork;

    public Philosopher(Object leftFork, Object rightFork) {
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }


    @Override
    public void run() {
        // implementation
    }
}
