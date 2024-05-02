package EstablishmentPack.OpisEstablishment.CompasiteDish;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
/**
 * A class representing an individual dish.
 * Serialization is used {@link Serializable}
 * Implements the interface {@link DishUnit}
 * is part of the "Сomposite" pattern
 */
public class Dish implements DishUnit , Serializable {
    private String dishName;
    /**
     * Constructor for creating a dish with a specified name.
     * @param dishName The name of the dish.
     */
    public Dish(String dishName){
        setDishName(dishName);
    }
    /**
     * Sets the name of the dish.
     * @param dishName The name of the dish to be set.
     */
    public void setDishName(String dishName){
        this.dishName=dishName;
    }

    /**
     * Retrieves a list containing only this individual dish.
     * @return A list containing this individual dish.
     */
    @Override
    public List<Dish> getWarriors() {
        List<Dish> indiv=new LinkedList<>();
        indiv.add(this);
        return indiv;
    }

    /**
     * Reports the name of the dish.
     * @param tab The tab character to be used for indentation.
     * @return The name of the dish.
     */
    @Override
    public String report(String tab) {
        return dishName;
    }
}
