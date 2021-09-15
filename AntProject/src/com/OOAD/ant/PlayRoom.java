package com.OOAD.ant;

import static java.lang.StrictMath.pow;

public class PlayRoom {

    private static int minTime = Integer.MAX_VALUE;
    private static int maxTime = 0;

    private static long incTime = 2;

    public static void main(String[] args) throws InterruptedException {

        int antCount = 5;

        for (int i = 0; i < pow(2, antCount); i++) {

            CreepingGame cg = new CreepingGame(i, antCount);
            cg.init();

            while (!cg.GameOver()) {
                Thread.sleep(incTime);
                cg.run();
            }

            if (cg.getTime() < minTime)
                minTime = cg.getTime();
            if (cg.getTime() > maxTime)
                maxTime = cg.getTime();

            System.out.println("第" + i + "次的time: " + cg.getTime());

        }

        System.out.println("max time is: " + maxTime);
        System.out.println("min time is: " + minTime);

    }

}
