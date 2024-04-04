package EstablishmentPack;

import EstablishmentPack.OpisEstablishment.Menu;

public class EuropeanRestaurant extends Restaurant{
    private String mainDish="Borscht";
    private Menu menu;
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
        report= report+getEuropeanName() +"\n"
                +"-----------\n"
                +"Location: Bratislava, Velyka Ploscha 12\n"
                +"-----------\n"
                +"Concept: \"European Restaurant is a restaurant\n" +
                "that offers its guests a wide range of dishes\n" +
                "from different European countries. Here you can\n" +
                "enjoy the atmosphere of a European gastronomic\n" +
                "masterpiece and taste dishes known \n" +
                "for their uniqueness and taste.\n"
                +"-----------\n"
                +"Opening hours: Open daily from 11:00 to 23:00.\n"
                +"-----------\n"
                +"Popular dish: "
                +this.mainDish;
        return report;
    }
}
