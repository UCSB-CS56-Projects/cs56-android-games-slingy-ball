package jsmli.slingyball;

public class Platform {

    private float x;
    private float y;
    private float length;
    private float height = 25;


    private int color;

    public Platform(float x, float y, float length, int color) {

        this.x = x;
        this.y = y;
        this.color = color;
        this.length = length;


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