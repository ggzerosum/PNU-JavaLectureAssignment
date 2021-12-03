package edu.pnu.admin;

import java.util.Objects;

public class Beverage implements Comparable<Beverage> {
    private String type;
    private String name;

    public Beverage(String name, String type)
    {
        System.out.println("\n");
        this.name = name;
        this.type = type;
    }

    public String getBeverageName()
    {
        return name;
    }

    public String getBeverageType()
    {
        return type;
    }

    @Override
    public String toString()
    {
        return "[" + name + ", " + type + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Beverage beverage = (Beverage) o;
        return Objects.equals(type, beverage.type) && Objects.equals(name, beverage.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, name);
    }

    @Override
    public int compareTo(Beverage o) {
        String thisName = this.getBeverageName().toLowerCase();
        String otherName = o.getBeverageName().toLowerCase();
        return thisName.compareTo(otherName);
    }
}