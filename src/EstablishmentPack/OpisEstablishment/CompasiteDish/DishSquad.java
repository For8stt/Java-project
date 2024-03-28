package EstablishmentPack.OpisEstablishment.CompasiteDish;

import java.util.LinkedList;
import java.util.List;

public class DishSquad implements DishUnit{
    private String name;
    private List<DishUnit> units=new LinkedList<>();
    public DishSquad(String name){
        this.name=name;
    }
    public void addDishUnit(DishUnit unit){
        units.add(unit);
    }
    @Override
    public List<Dish> getWarriors() {
        List<Dish> indiv=new LinkedList<>();

        for (DishUnit e:units){
            indiv.addAll(e.getWarriors());
        }

        return indiv;
    }

    @Override
    public String report(String tab) {
        String report = name+"\n";

        for (DishUnit e: units){
            report+=tab+e.report(tab+"\t"+"--")+"\n";
        }

        return report;
    }
}
