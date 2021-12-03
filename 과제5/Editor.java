package edu.pnu.edit;

import edu.pnu.shape.Shape;

import java.util.ArrayList;
import java.util.List;

public class Editor {
    private List<Shape> shapes = new ArrayList<Shape>();

    public void add(Shape shape)
    {
        this.shapes.add(shape);
    }
    public void clear()
    {
        this.shapes.clear();
    }
    public void list()
    {
        int count = shapes.size();
        int index = 0;

        String output = "[";
        for(final Shape shape : shapes)
        {
            output += shape.toString();
            if (index < count-1)
                output += ", ";

            index++;
        }
        output += "]";

        System.out.println(output);
    }
}