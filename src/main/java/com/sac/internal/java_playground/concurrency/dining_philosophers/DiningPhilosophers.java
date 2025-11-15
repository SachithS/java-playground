package com.sac.internal.java_playground.concurrency.dining_philosophers;

public class DiningPhilosophers {

    public static void main(String[] args) {

        ProblematicPhilosopher[] problematicPhilosophers = new ProblematicPhilosopher[5];
        Object[] forks = new Object[problematicPhilosophers.length];

        for (int i=0; i < forks.length; i++){
            forks[i] = new Object();
        }

        for (int i = 0; i < problematicPhilosophers.length; i++){
            Object leftFork = forks[i];
            Object rightFork = forks[(i + 1) % forks.length];

            problematicPhilosophers[i] = new ProblematicPhilosopher(leftFork, rightFork);

            Thread t = new Thread(problematicPhilosophers[i], "Philosopher " + (i + 1));
            t.start();
        }
    }
}
