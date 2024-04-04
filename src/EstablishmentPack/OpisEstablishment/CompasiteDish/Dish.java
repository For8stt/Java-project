package EstablishmentPack.OpisEstablishment.CompasiteDish;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class Dish implements DishUnit , Serializable {
    private String dishName;
    public Dish(String dishName){
        setDishName(dishName);
    }
    public void setDishName(String dishName){
        this.dishName=dishName;
    }

    @Override
    public List<Dish> getWarriors() {
        List<Dish> indiv=new LinkedList<>();
        indiv.add(this);
        return indiv;
    }

    @Override
    public String report(String tab) {
        return dishName;
    }
}
