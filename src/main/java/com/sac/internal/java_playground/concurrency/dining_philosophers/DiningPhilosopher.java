package com.sac.internal.java_playground.concurrency.dining_philosophers;

public class DiningPhilosopher {

    public static void main(String[] args) {

        final Philosopher[] philosophers = new Philosopher[5];
        Object[] forks = new Object[philosophers.length];

        for (int i=0; i < forks.length; i++){
            forks[i] = new Object();
        }

        for (int i = 0; i < philosophers.length; i++) {
            Object leftFork = forks[i];
            Object rightFork = forks[(i + 1) % forks.length];

            if (i == (philosophers.length -1)){
                // Last philosopher will get the right fork first instead the left
                philosophers[i] = new Philosopher(rightFork, leftFork);
            } else {
                philosophers[i] = new Philosopher(leftFork, rightFork);
            }

            Thread thread = new Thread(philosophers[i], "Philosopher " + (i+1));
            thread.start();
        }
    }
}
