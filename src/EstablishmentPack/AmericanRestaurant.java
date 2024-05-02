package EstablishmentPack;

import EstablishmentPack.OpisEstablishment.Menu;

/**
 * A subclass that extends the {@link Restaurant} class and represents American restaurants.
 * American restaurants offer classic American dishes and flavors.
 */
public class AmericanRestaurant extends Restaurant{
    private String mainDish="Pizza California";
    private Menu menu;

    /**
     * Constructor for the AmericanRestaurant class, which sets up the menu and review for the American restaurant.
     * {@link Menu} is an aggregation of this class and is stored in this class
     * {@link EstablishmentPack.OpisEstablishment.Bar} is an aggregation of this class and is stored in the parent class
     * {@link EstablishmentPack.OpisEstablishment.Review} is a composition of this class
     * @param name The name of the restaurant.
     */
    public AmericanRestaurant(String name){
        menu=new Menu( "Hamburger","French fries","Hot dog",
                "Pizza california","BBQ ribs","Fried chicken",
                "Caesar salad","Macaroni and cheese","Steak");
        setNameRestaurant(name);
        setBar("Bourbon","Craft beer","Whiskey");
        setRev();
    }
    /**
     * Method to get the name of the American restaurant.
     * @return The name of the restaurant.
     */
    public String getAmericanName(){
        return this.getNameRestaurant();
    }

    /**
     * Overridden method {@inheritDoc} that returns the menu of the American restaurant.
     * @return A string with the restaurant's menu.
     */
    @Override
    public String getMenuRes(){
        return menu.showMenu();
    }
    /**
     * Overridden method {@inheritDoc} that returns information about the American restaurant.
     * @return A string with information about the restaurant.
     */
    @Override
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
