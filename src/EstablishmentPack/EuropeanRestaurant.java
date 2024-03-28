package EstablishmentPack;

import EstablishmentPack.OpisEstablishment.Menu;

public class EuropeanRestaurant extends Restaurant{
    String menuu="borsh and kebab";
    Menu menu;
    public EuropeanRestaurant(String name){
        menu=new Menu( "Paella","Spaghetti Carbonara","Croissant",
                "Wiener Schnitzel","Moussaka","Bratwurst",
                "Fish and Chips","Goulash","Borscht");
        setNameRestaurant(name);
        setBar("Wine","Beer","Burovicka");
        setRev();
    }
    public String getEuropeanName(){
        return this.getNameRestaurant();
    }
    public String getMenuRes(){
        return menu.showMenu();
    }
    @Override
    public String displayInfo() {
        String report="";
        report= report+getEuropeanName()+"\n"+"bude infa"+"\n"+this.menuu;
        return report;
    }
}
