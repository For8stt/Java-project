package EstablishmentPack.Cafes;

import EstablishmentPack.OpisEstablishment.Menu;

public class ConfectioneryCafes extends Cafe{
    private String menuu="ConfectioneryCafes and ramen";
    public ConfectioneryCafes(String name){
        setMenu("Sweet Dream Waffles","Candyland Pancakes","Sugar Rush French Toast",
                "Chocolate Chip Cookie Dough Cheesecake","Cotton Candy Frappuccino","Rainbow Cupcake Delight",
                "Candy-Coated Popcorn","Lollipop Lemon Tart","Fruit Loop Doughnuts");
        setNameCafe(name);
        setRev();
    }
    public String getCatCName(){
        return this.getNameCafe();
    }

    @Override
    public String displayInfo() {
        String report="";
        report= report+getCatCName()+"\n"+"bude infa pre Cafe (Maxim, nečítaj toto.)"+"\n"+this.menuu;
        return report;
    }
}
