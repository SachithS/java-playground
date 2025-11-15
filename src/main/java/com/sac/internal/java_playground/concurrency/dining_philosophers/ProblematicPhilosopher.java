package com.sac.internal.java_playground.concurrency.dining_philosophers;

public class ProblematicPhilosopher implements Runnable {

    private Object leftFork;
    private Object rightFork;

    public ProblematicPhilosopher(Object leftFork, Object rightFork) {
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }


    @Override
    public void run() {
        try {
            while (true) {
                doAction(System.nanoTime() + ": Thinking!");
                synchronized (leftFork){
                    //left fork
                    doAction(System.nanoTime() + ": Picked up left fork!");
                    synchronized (rightFork) {
                        //right fork
                        doAction(System.nanoTime() + ": Picked up right fork!");
                        // eating
                        doAction(System.nanoTime() + ": Eating..!");
                        //right fork
                        doAction(System.nanoTime() + ": Put down right fork!");
                    }
                    //left fork
                    doAction(System.nanoTime() + ": Put down left fork!");
                }
            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void doAction(String action) throws InterruptedException {
        System.out.println(
                Thread.currentThread().getName() + " " + action);
        Thread.sleep((int) (Math.random() * 100));
    }
}
