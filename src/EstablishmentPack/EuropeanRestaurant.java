package EstablishmentPack;

import EstablishmentPack.OpisEstablishment.Menu;

/**
 * A subclass that extends the {@link Restaurant} class and represents European restaurants.
 * European restaurants offer a wide range of dishes from different European countries.
 */
public class EuropeanRestaurant extends Restaurant{
    private String mainDish="Borscht";
    private Menu menu;
    /**
     * Constructor for the EuropeanRestaurant class, which sets up the menu and review for the European restaurant.
     * {@link Menu} is an aggregation of this class and is stored in this class
     * {@link EstablishmentPack.OpisEstablishment.Bar} is an aggregation of this class and is stored in the parent class
     * {@link EstablishmentPack.OpisEstablishment.Review} is a composition of this class
     *
     * @param name The name of the restaurant.
     */
    public EuropeanRestaurant(String name){
        menu=new Menu( "Paella","Spaghetti Carbonara","Croissant",
                "Wiener Schnitzel","Moussaka","Bratwurst",
                "Fish and Chips","Goulash","Borscht");
        setNameRestaurant(name);
        setBar("Wine","Beer","Burovicka");
        setRev();
    }
    /**
     * Method to get the name of the European restaurant.
     * @return The name of the restaurant.
     */
    public String getEuropeanName(){
        return this.getNameRestaurant();
    }
    /**
     * Overridden method {@inheritDoc} that returns the menu of the European restaurant.
     * @return A string with the restaurant's menu.
     */
    @Override
    public String getMenuRes(){
        return menu.showMenu();
    }
    /**
     * Overridden method {@inheritDoc} that returns information about the European restaurant.
     * @return A string with information about the restaurant.
     */
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
