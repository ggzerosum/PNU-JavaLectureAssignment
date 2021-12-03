package edu.pnu.collection;

import java.util.Iterator;

public class GenericList <T>
{
    private static final int DEFAULT_SIZE = 10;
    private Object[] data;
    private int size = 0;
    private int capacity = 0;

    public GenericList(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.data = new Object[capacity];
    }

    public Boolean contain(T t)
    {
        for (final Object d : data)
        {
            if (d.equals(t))
            {
                return true;
            }
        }

        return false;
    }

    public int size()
    {
        return size;
    }

    public void add(T t)
    {
        data[size] = t;
        size++;
    }
    public T get(int index)
    {
        return (T)data[index];
    }

    public void clear()
    {
        for (int i = 0; i < size; i++)
        {
            data[i] = null;
        }

        size = 0;
    }

    public Iterator<T> Iterator()
    {
        Iterator<T> iter = new Iterator<T>() {
            int start = 0;

            @Override
            public boolean hasNext() {
                return start < size;
            }

            @Override
            public T next() {
                int current = start;
                start++;
                return (T)data[current];
            }
        };

        return iter;
    }
}