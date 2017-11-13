package jsmli.slingyball;

public class PlayerBall {

    private float x, y, vx, vy;
    private float elasticity;
    private int radius;
    private int color;

    public PlayerBall(float x, float y, int radius, float elasticity, int color) {

        this.x = x;
        this.y = y;
        this.radius = radius;
        this.elasticity = elasticity;
        this.color = color;
        ControlBall.playerListener = this;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getVx() {
        return vx;
    }

    public void setVx(float vx) {
        this.vx = vx;
    }

    public float getVy() {
        return vy;
    }

    public void setVy(float vy) {
        this.vy = vy;
    }

    public float getElasticity() {
        return elasticity;
    }

    public void setElasticity(float elasticity) {
        this.elasticity = elasticity;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

}
