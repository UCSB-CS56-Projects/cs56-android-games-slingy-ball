package jsmli.slingyball;

public class Platform {

    private float x;
    private float y;
    private float length;
    private float height;

    private int color;

    public Platform(float x, float y, float length, float height, int color) {

        this.x = x;
        this.y = y;
        this.color = color;
        this.length = length;
        this.height = height;

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

    public float getLength() {
        return length;
    }

    public float getHeight() {
        return height;
    }

    public int getColor() {
        return color;
    }
    public void setColor(int color) {
        this.color = color;
    }

}
