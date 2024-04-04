package EstablishmentPack;

import EstablishmentPack.OpisEstablishment.Menu;

public class AmericanRestaurant extends Restaurant{
    private String mainDish="Pizza California";
    private Menu menu;
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
        report= report+getAmericanName()+"\n"
                +"-----------\n"
                +"Location: Bratislava, 12 Irlandska Street\n"
                +"-----------\n"
                +"Concept: American Restaurant is a place where \n" +
                "you can enjoy the atmosphere and flavors of \n" +
                "American cuisine right in the heart of Bratislava.\n" +
                "The restaurant offers classic American dishes,\n" +
                "from burgers and steaks to juicy \n" +
                "sandwiches and meat dishes\n"
                +"-----------\n"
                +"Opening hours: Open from Tuesday to Friday\n" +
                "from 11:00 to 23:00.\n"
                +"-----------\n"
                +"Popular dish: "
                +this.mainDish;
        return report;
    }
}
