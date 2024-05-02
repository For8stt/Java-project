package EstablishmentPack.OpisEstablishment.CompasiteDish;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * A class representing a group of dishes forming a composite dish.
 * Implements the interface {@link DishUnit}
 * is part of the "Сomposite" pattern
 */
public class DishSquad implements DishUnit{
    private String name;
    private List<DishUnit> units=new LinkedList<>();
    /**
     * Constructor for creating a dish squad with a specified name.
     * @param name The name of the dish squad.
     */
    public DishSquad(String name){
        this.name=name;
    }
    /**
     * Adds a dish unit to the dish squad.
     * @param unit The dish unit to be added.
     */
    public void addDishUnit(DishUnit unit){
        units.add(unit);
    }
    /**
     * Retrieves a list containing all individual dishes within the dish squad.
     * @return A list containing all individual dishes within the dish squad.
     */
    @Override
    public List<Dish> getWarriors() {
        List<Dish> indiv=new LinkedList<>();

        for (DishUnit e:units){
            indiv.addAll(e.getWarriors());
        }

        return indiv;
    }
    /**
     * Reports the structure of the dish squad, including its name and the names of its constituent dishes.
     * @param tab The tab character to be used for indentation.
     * @return A string representing the structure of the dish squad.
     */
    @Override
    public String report(String tab) {
        String report = name+"\n";

        for (DishUnit e: units){
            report+=tab+e.report(tab+"\t"+"--")+"\n";
        }

        return report;
    }
}
