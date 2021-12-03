package edu.pnu.admin;
import edu.pnu.collection.GenericList;

import java.util.*;

public class Cafe {
    private String name;
    private GenericList<Beverage> students = new GenericList<Beverage>(100);
    
    public Cafe(String name)
    {
        this.name = name;
    }

    public void addBeverage(Beverage beverage)
    {
        System.out.println("");

        String key = beverage.getBeverageName().toLowerCase(Locale.ROOT) + beverage.getBeverageType().toLowerCase(Locale.ROOT);

        if (contains(beverage))
            return;

        put(beverage);
    }
    public Beverage findBeverage(String name, String type)
    {
        System.out.println("");

        return find(name, type);
    }
    public void removeAllBeverage()
    {
        System.out.println("");

        clear();
    }

    @Override
    public String toString()
    {
        System.out.println("");

        String msg = "Cafe Name : " + name + " Beverage Count: " + students.size() + "\n";

        List<Beverage> list = new ArrayList<>();

        Iterator<Beverage> values = students.Iterator();
        while (values.hasNext())
        {
            list.add(values.next());
        }

        Collections.sort(list);

        for (final Beverage beverage : list)
        {
            msg += "\t" + beverage.toString() + "\n";
        }

        return msg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cafe cafe = (Cafe) o;
        return Objects.equals(name, cafe.name) && Objects.equals(cafe.students, cafe.students);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, students);
    }


    private Boolean contains(Beverage beverage)
    {
        return find(beverage.getBeverageName(), beverage.getBeverageType()) != null;
    }

    private Beverage find(String name, String type)
    {
        GenericList<Beverage> list = students;
        Iterator<Beverage> it =  list.Iterator();
        while (it.hasNext())
        {
            Beverage next = it.next();

            Boolean nameEquality = next.getBeverageName().equals(name);
            Boolean typeEquality = next.getBeverageType().equals(type);

            if (nameEquality && typeEquality)
                return next;
        }

        return null;
    }

    private void put(Beverage beverage)
    {
        students.add(beverage);
    }

    private void clear()
    {
        students.clear();
    }
}