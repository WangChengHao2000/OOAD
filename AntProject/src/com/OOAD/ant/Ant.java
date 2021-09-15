package com.OOAD.ant;

public class Ant {

    private int velocity;

    private int direction;

    private int position;

    private boolean onStick;

    public Ant(int velocity, int direction, int position) {
        this.velocity = velocity;
        this.direction = direction == 1 ? 1 : -1;
        this.position = position;
        this.onStick = true;
    }

    public void creeping() {
        position = position + direction * velocity;
    }

    public void changeDir() {
        direction = -direction;
    }

    public int getVelocity() {
        return velocity;
    }

    public int getDirection() {
        return direction;
    }

    public int getPosition() {
        return position;
    }

    public boolean getOnStick() {
        return onStick;
    }

    public void setOnStick(boolean onStick) {
        this.onStick = onStick;
    }
}
