import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Objects;
import java.util.*;

public class Cafe {
    private String name;
    private HashMap<String, Beverage> menus = new HashMap<>();

    public Cafe(String name)
    {
        this.name = name;
    }

    public void addBeverage(Beverage beverage)
    {
        System.out.println("");
        String key = beverage.getBeverageName().toLowerCase(Locale.ROOT) + beverage.getBeverageType().toLowerCase(Locale.ROOT);

        if (this.menus.containsKey(key))
            return;

        this.menus.put(key, beverage);
    }
    public Beverage findBeverage(String name, String type)
    {
        System.out.println("");
        String key = name.toLowerCase(Locale.ROOT) + type.toLowerCase(Locale.ROOT);
        return this.menus.get(key);
    }
    public void removeAllBeverage()
    {
       System.out.println("");

        this.menus.clear();
    }

    @Override
    public String toString()
    {
        System.out.println("");

        String msg = "Cafe Name : " + name + " Beverage Count: " + menus.size() + "\n";

        List<Beverage> list = new ArrayList<>();

        Iterator<Beverage> values = menus.values().iterator();
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
        return Objects.equals(name, cafe.name) && Objects.equals(menus, cafe.menus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, menus);
    }
}