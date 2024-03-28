package EstablishmentPack;

import EstablishmentPack.OpisEstablishment.Menu;

public class AmericanRestaurant extends Restaurant{
    String menuu="Burgers and CocaCola";
    Menu menu;
    public AmericanRestaurant(String name){
        menu=new Menu( "Hamburger","French fries","Hot dog",
                "Pizza california","BBQ ribs","Fried chicken",
                "Caesar salad","Macaroni and cheese","Steak");
        setNameRestaurant(name);
        setBar("Bourbon","Craft beer","Whiskey");
        setRev();
    }
    public String getAmericanName(){
        return this.getNameRestaurant();
    }
    public String getMenuRes(){
        return menu.showMenu();
    }
    public String displayInfo() {
        String report="";
        report= report+getAmericanName()+"\n"+"bude infa"+"\n"+this.menuu;
        return report;
    }
}
