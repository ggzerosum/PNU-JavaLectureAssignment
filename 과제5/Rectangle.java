package edu.pnu.shape;

public class Rectangle extends Shape{
    private int width, height;

    public Rectangle(int minx, int miny, int maxx, int maxy)
    {
        this.width = maxx - minx;
        this.height = maxy - miny;
    }

    @Override
    public float getArea() {
        return width * height;
    }

    @Override
    public String toString() {
        return String.format("[Rectangle %d %d %.2f]", width, height, getArea());
    }
}