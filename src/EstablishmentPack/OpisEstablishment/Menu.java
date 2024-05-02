package EstablishmentPack.OpisEstablishment;

import EstablishmentPack.OpisEstablishment.CompasiteDish.Dish;
import EstablishmentPack.OpisEstablishment.CompasiteDish.DishSquadSetup;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
/**
 * A class representing the menu of an establishment.
 *  is an aggregation for the classes {@link EstablishmentPack.Restaurant} and {@link EstablishmentPack.Cafes.Cafe}
 *  Serialization is used {@link Serializable}
 */
public class Menu implements Serializable {

    private String menu;
    private List<Dish> dishes;
    /**
     * Default constructor for the Menu class.
     */
    public Menu(){}
    /**
     * Constructor for the Menu class that initializes the menu with specific dishes.
     *
     * @param pervoje1 The first appetizer.
     * @param pervoje2 The second appetizer.
     * @param pervoj3 The third appetizer.
     * @param vtoroje1 The first main course.
     * @param vtoroje2 The second main course.
     * @param vtoroje3 The third main course.
     * @param desert1 The first dessert.
     * @param desert2 The second dessert.
     * @param desert3 The third dessert.
     */
    public Menu(String pervoje1,String pervoje2,String pervoj3,
                String vtoroje1,String vtoroje2,String vtoroje3,
                String desert1,String desert2,String desert3){

        creatMenu(3,3,3, pervoje1, pervoje2, pervoj3,
                 vtoroje1, vtoroje2, vtoroje3,
                 desert1, desert2, desert3);
    }
    /**
     * Creates the menu with specified dishes.
     * the menu is initialized in the class {@link DishSquadSetup} which the pattern represents COMPOSITE
     *
     * @param pervoje The number of appetizers.
     * @param vtoroje The number of main courses.
     * @param desert The number of desserts.
     * @param pervoje1 The first appetizer.
     * @param pervoje2 The second appetizer.
     * @param pervoj3 The third appetizer.
     * @param vtoroje1 The first main course.
     * @param vtoroje2 The second main course.
     * @param vtoroje3 The third main course.
     * @param desert1 The first dessert.
     * @param desert2 The second dessert.
     * @param desert3 The third dessert.
     */
    public void creatMenu(int pervoje,int vtoroje,int desert,String pervoje1,String pervoje2,String pervoj3,
                          String vtoroje1,String vtoroje2,String vtoroje3,
                          String desert1,String desert2,String desert3){
        dishes=new LinkedList<>();
        DishSquadSetup a=new DishSquadSetup();

        String menu=a.setup(dishes,pervoje,vtoroje,desert,  pervoje1, pervoje2, pervoj3,
                 vtoroje1, vtoroje2, vtoroje3,
                 desert1, desert2, desert3);
        this.menu=menu;
    }
    /**
     * Method to display the menu.
     * @return The menu items as a string.
     */
    public String showMenu(){
        return this.menu;
    }


}

