package org.firstinspires.ftc.teamcode.Bot;



public enum A6PropPosition {
    LEFT,
    CENTER,
    RIGHT;

    public A6PropPosition swap(A6PropPosition position) {
        if (position.equals(LEFT)) {
            return RIGHT;
        } else if (position.equals(RIGHT)) {
            return LEFT;
        }
        return CENTER;
    }
}
