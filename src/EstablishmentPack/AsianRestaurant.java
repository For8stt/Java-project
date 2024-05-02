package EstablishmentPack;


import EstablishmentPack.OpisEstablishment.Menu;
/**
 * A subclass that extends the {@link Restaurant} class and represents Asian restaurants.
 * Asian restaurants offer a variety of dishes from different Asian countries.
 */
public class AsianRestaurant extends Restaurant{
    private String mainDish="Sushi California";
    private Menu menu;
    /**
     * Constructor for the AsianRestaurant class, which sets up the menu and review for the Asian restaurant.
     * {@link Menu} is an aggregation of this class and is stored in this class
     * {@link EstablishmentPack.OpisEstablishment.Bar} is an aggregation of this class and is stored in the parent class
     * {@link EstablishmentPack.OpisEstablishment.Review} is a composition of this class
     *
     * @param name The name of the restaurant.
     */
    public AsianRestaurant(String name){
        menu=new Menu( "Tom iam","Tangyuan","Noodles with chicken",
                "California","Nagiri","Noodles with beef",
                "Mango Sticky Rice","Bamboo Shoot Strips","Lychee with Ice Cream");
        setNameRestaurant(name);
        setBar("Sake","Soju","Shochu");
        setRev();
    }
    /**
     * Method to get the name of the Asian restaurant.
     * @return The name of the restaurant.
     */
    public String getAsianName(){
        return this.getNameRestaurant();
    }
    /**
     * Overridden method {@inheritDoc} that returns the menu of the Asian restaurant.
     * @return A string with the restaurant's menu.
     */
    @Override
    public String getMenuRes(){
        return menu.showMenu();
    }
    /**
     * Overridden method {@inheritDoc} that returns information about the Asian restaurant.
     * @return A string with information about the restaurant.
     */
    @Override
    public String displayInfo() {
        String report="";
        report= report+getAsianName()+"\n"
                +"-----------\n"
                +"Location: Bratislava, Orientalna Street 8\n"
                +"-----------\n"
                +"Concept: Asian Restaurant is a unique restaurant\n" +
                "that offers its guests a journey into the world\n" +
                "of oriental cuisine. Here you can enjoy the \n" +
                "atmosphere and flavors of various dishes from \n" +
                "Asian countries, from classic to author's.\n"
                +"-----------\n"
                +"Opening hours: open on weekends\n" +
                "from 12:00 to 22:00.\n"
                +"-----------\n"
                +"Popular dish: "
                +this.mainDish;
        return report;
    }
}
