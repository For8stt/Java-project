package EstablishmentPack.OpisEstablishment.CompasiteDish;

import java.util.List;

public class DishSquadSetup{
    public String setup(List<Dish>dishes,int pervoje,int vtoroje,int desert,String pervoje1,String pervoje2,String pervoj3 ,
                        String vtoroje1,String vtoroje2,String vtoroje3,
                        String desert1,String desert2,String desert3) {


        DishSquad AllChast = new DishSquad("Mame dnes");
        DishSquad pervojeChast = new DishSquad("Pervoje dnes");
        DishSquad vtorojeChast = new DishSquad("Vtoroje dnes");
        DishSquad desertChast = new DishSquad("Desert dnes");

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
