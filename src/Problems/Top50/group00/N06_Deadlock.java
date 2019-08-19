package Problems.Top50.group00;

import Utility.IProblem;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * This is one of the interesting programs from Java Interviews, mostly asked to 2 to 3 years
 * of experienced programmers or higher. Interviewer simply asked you to write code where a
 * resource is accessed by multiple threads. You need to write code in such a way that no deadlock
 * should occur. The trick to solving this problem is acquiring resources in an order and release
 * them in reverse order e.g. first acquire resource R1 and only if you have got R1 go for R2.
 * This way you can avoid deadlock.
 *
 * This problem was obtained from the following url:
 * https://javarevisited.blogspot.com/2017/07/top-50-java-programs-from-coding-Interviews.html
 *
 * @author Marcelo
 */
public class N06_Deadlock implements IProblem {
    private static final int FILOSOFERS_COUNT = 3;

    @Override
    public String GetName() {
        return this.getClass().getName();
    }

    @Override
    public void Execute() {
        CountDownLatch cdl = new CountDownLatch(FILOSOFERS_COUNT);
        Table table = new Table(FILOSOFERS_COUNT);
        Thread[] philosofers = new Thread[FILOSOFERS_COUNT];
        for(int i = 0; i < FILOSOFERS_COUNT; i++) {
            philosofers[i] = new Philosofer(i, table, cdl);
            philosofers[i].start();
        }
        try {
            cdl.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Inner class that provides philosofer's behavior.
     */
    public class Philosofer extends Thread{
        private int index;
        private Table table;
        private int timesToRun = 2;
        private CountDownLatch cdl;

        public Philosofer(int index, Table table, CountDownLatch cdl) {
            this.index = index;
            this.table = table;
            this.setName("[Philosofer-" + index + "]");
            this.cdl = cdl;
        }

        public void run() {
            try {
                while(timesToRun > 0) {
                    if(!table.eat(this.index)) {
                        System.out.println(getName() + " could not eat");
                    } else {
                        timesToRun--;
                    }
                    table.think();
                }
                cdl.countDown();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Inner class that exposes the actions that a philosofer can do at the table.
     * They can either think or eat, and in order to eat, they must be able to
     * pick the sticks at both sides.
     */
    public class Table {
        private Lock[] sticks;
        private int stickNumber;

        public Table(int numberOfSticks) {
            stickNumber = numberOfSticks;
            sticks = new Lock[numberOfSticks];
            for (int i = 0; i < numberOfSticks; i++) {
                sticks[i] = new ReentrantLock();
            }
        }

        /**
         * Allws a philosofer to eat, properly taking care of
         * any concurrency issue.
         * @param index of the philosofer that calls this.
         * @return true if the philosofer was able to eat.
         */
        public boolean eat(int index) {
            int rightHand = index % stickNumber;
            sticks[rightHand].lock();
            try {
                int leftHand = (index + 1) % stickNumber;
                if (sticks[leftHand].tryLock((long) Math.random() * 1000, TimeUnit.MILLISECONDS)) {
                    System.out.println(Thread.currentThread().getName() + " is eating.");
                    Thread.sleep((long) Math.random() * 1000);
                    sticks[leftHand].unlock();
                    return true;
                }
                return false;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            } finally {
                sticks[rightHand].unlock();
            }
        }

        /**
         * Called for a philosopher to think.
         */
        public void think() {
            try {
                System.out.println(Thread.currentThread().getName() + " is thinking.");
                Thread.sleep((long) Math.random() * 1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}