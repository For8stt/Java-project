package EstablishmentPack.OpisEstablishment.CompasiteDish;

import java.util.List;
/**
 * An interface representing a unit of a composite dish.
 * is part of the "Сomposite" pattern
 */
public interface DishUnit {
    /**
     * Retrieves a list containing all individual dishes within the dish unit.
     * @return A list containing all individual dishes within the dish unit.
     */
    List<Dish> getWarriors();
    /**
     * Generates a report detailing the structure of the dish unit.
     * @param tab The tab character to be used for indentation.
     * @return A string representing the structure of the dish unit.
     */
    String report(String tab);
}
