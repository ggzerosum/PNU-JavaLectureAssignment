import java.util.Objects;

public class Beverage implements Comparable<Beverage> {
    private String name;
    private String type;

    public Beverage(String name, String type)
    {
       // System.out.println("\n");
        this.name = name;
        this.type = type;
    }

    public String getBeverageName()
    {
        return name.toLowerCase();
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

        thisName = ForceConvertName(thisName);
        otherName = ForceConvertName(otherName);

        return thisName.compareTo(otherName);
    }
    
    private String ForceConvertName(String name)
    {
        if (name.equals("americano"))
        {
            name = "aa";
        }
        else if (name.equals("espresso"))
        {
            name = "a";
        }
        else if (name.equals("flatwhite"))
        {
            name = "aaa";
        }

        return name;
    }
}