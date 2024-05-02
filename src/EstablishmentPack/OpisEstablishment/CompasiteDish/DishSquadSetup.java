package EstablishmentPack.OpisEstablishment.CompasiteDish;

import java.util.List;
/**
 * A class responsible for setting up the composite dishes.
 * is part of the "Сomposite" pattern
 */
public class DishSquadSetup{
    /**
     * Sets up the composite dishes based on the provided parameters.
     *
     * {@code  for (int i = 0; i < pervoje; i++)} Setting up main dishes
     * {@code  for (int i = pervoje; i < pervoje + vtoroje; i++)} Setting up specialty dishes
     * {@code  for (int i = pervoje + vtoroje; i < pervoje + vtoroje + desert; i++)} // Setting up desserts and snacks
     * {@code  AllChast.addDishUnit(...) } Adding all parts to the main menu
     * {@code  dishes.addAll(...) } Adding all dishes to the provided list
     *
     * @param dishes The list to which the individual dishes will be added.
     * @param pervoje The number of main dishes.
     * @param vtoroje The number of specialty dishes.
     * @param desert The number of desserts and snacks.
     * @param pervoje1 The name of the first main dish.
     * @param pervoje2 The name of the second main dish.
     * @param pervoj3 The name of the third main dish.
     * @param vtoroje1 The name of the first specialty dish.
     * @param vtoroje2 The name of the second specialty dish.
     * @param vtoroje3 The name of the third specialty dish.
     * @param desert1 The name of the first dessert or snack.
     * @param desert2 The name of the second dessert or snack.
     * @param desert3 The name of the third dessert or snack.
     * @return A string representing the structure of the composite dishes.
     */
    public String setup(List<Dish>dishes,int pervoje,int vtoroje,int desert,String pervoje1,String pervoje2,String pervoj3 ,
                        String vtoroje1,String vtoroje2,String vtoroje3,
                        String desert1,String desert2,String desert3) {


        DishSquad AllChast = new DishSquad("Main menu:");
        DishSquad pervojeChast = new DishSquad("Main Dishes");
        DishSquad vtorojeChast = new DishSquad("Specialty Dishes");
        DishSquad desertChast = new DishSquad("Desserts and Snacks");

        for (int i = 0; i < pervoje; i++) {
            if (i == 0) {
                pervojeChast.addDishUnit(new Dish(pervoje1));
            } else if (i == 1) {
                pervojeChast.addDishUnit(new Dish(pervoje2));
            } else {
                pervojeChast.addDishUnit(new Dish(pervoj3));
            }
        }

        for (int i = pervoje; i < pervoje + vtoroje; i++) {
            if (i == pervoje) {
                vtorojeChast.addDishUnit(new Dish(vtoroje1));
            } else if (i == pervoje+1) {
                vtorojeChast.addDishUnit(new Dish(vtoroje2));
            } else {
                vtorojeChast.addDishUnit(new Dish(vtoroje3));
            }
        }
        for (int i = (pervoje + vtoroje); i < (pervoje+vtoroje+desert); i++) {
            if (i == (pervoje + vtoroje)) {
                desertChast.addDishUnit(new Dish(desert1));
            } else if (i == (pervoje + vtoroje+1)) {
                desertChast.addDishUnit(new Dish(desert2));
            } else {
                desertChast.addDishUnit(new Dish(desert3));
            }
        }
        AllChast.addDishUnit(pervojeChast);
        AllChast.addDishUnit(vtorojeChast);
        AllChast.addDishUnit(desertChast);



        dishes.addAll(AllChast.getWarriors());
        return AllChast.report("\t");
    }
}
