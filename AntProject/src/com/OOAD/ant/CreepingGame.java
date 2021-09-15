package com.OOAD.ant;

import java.util.ArrayList;
import java.util.List;

public class CreepingGame {

    private int index;

    private int antCount;
    private int[] antPosition = {30, 80, 110, 160, 250};

    private int time;

    private Stick stick;
    private List<Ant> ants = new ArrayList<>();

    public CreepingGame(int index, int antCount) {
        this.index = index;
        this.antCount = antCount;
    }

    public void init() {
        for (int i = 0; i < antCount; i++) {
            ants.add(new Ant(5, (index >> i) & 1, antPosition[i]));
        }
        stick = new Stick(0, 300);
        time = 0;
    }

    public void run() {
        collision();
        for (int i = 0; i < antCount; i++) {
            ants.get(i).creeping();
            setOnStick(ants.get(i));
        }
        time += 1;
    }

    public void collision() {
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = 0; i < antCount - 1; i++) {
                Ant p1 = ants.get(i);
                Ant p2 = ants.get(i + 1);
                if (p1.getDirection() == 1 && p2.getDirection() == -1 && (p2.getPosition() - p1.getPosition()) < (p1.getVelocity() + p2.getVelocity())) {
                    p1.changeDir();
                    p2.changeDir();
                    flag = true;
                }
            }
        }
    }

    public void setOnStick(Ant ant) {
        if (ant.getPosition() > stick.getEnd() || ant.getPosition() < stick.getBegin())
            ant.setOnStick(false);
    }

    public boolean GameOver() {
        for (int i = 0; i < antCount; i++) {
            if (ants.get(i).getOnStick())
                return false;
        }
        return true;
    }

    public int getTime() {
        return time;
    }
}
