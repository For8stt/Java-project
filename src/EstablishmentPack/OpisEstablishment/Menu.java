package EstablishmentPack.OpisEstablishment;

import EstablishmentPack.OpisEstablishment.CompasiteDish.Dish;
import EstablishmentPack.OpisEstablishment.CompasiteDish.DishSquadSetup;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class Menu implements Serializable {

    private String menu;
    private List<Dish> dishes;
    public Menu(){}
    public Menu(String pervoje1,String pervoje2,String pervoj3,
                String vtoroje1,String vtoroje2,String vtoroje3,
                String desert1,String desert2,String desert3){

        creatMenu(3,3,3, pervoje1, pervoje2, pervoj3,
                 vtoroje1, vtoroje2, vtoroje3,
                 desert1, desert2, desert3);
    }
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
    public String showMenu(){
        return this.menu;
    }


}

