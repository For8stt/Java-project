package EstablishmentPack.Cafes;

import EstablishmentPack.AmericanRestaurant;
import EstablishmentPack.AsianRestaurant;
import EstablishmentPack.Establishment;
import EstablishmentPack.EuropeanRestaurant;
import EstablishmentPack.OpisEstablishment.Menu;
import EstablishmentPack.OpisEstablishment.Review;

import java.io.Serializable;
/**
 * A class representing a cafe establishment.
 * This class will be inherited by other classes {@link CatCafes} {@link ConfectioneryCafes} {@link LamaCafes}
 * Serialization is used {@link Serializable}
 */
public class Cafe implements Establishment, Serializable {
    private String name;
    private Review review;
    private Menu menu;
    /**
     * method which returns information about the cafe for further presentation to the user
     * @return A string containing the name of the cafe and comprehensive information about it
     */
    @Override
    public String displayInfo() {
        String report="";
        report= report+this.name+"\n"+"comprehensive information about the cafe";
        return report;
    }

    /**
     * basic constructor for cafes that will inherit the class
     */
    public Cafe(){
    }

    /**
     * Create and customize menus for each cafe.
     * In this class {@link Menu} uses the method for customization
     * Creates an object that is an aggregation for this class
     *
     * @param pervoje1
     * @param pervoje2
     * @param pervoj3
     * @param vtoroje1
     * @param vtoroje2
     * @param vtoroje3
     * @param desert1
     * @param desert2
     * @param desert3
     */
    public void setMenu(String pervoje1,String pervoje2,String pervoj3,
                        String vtoroje1,String vtoroje2,String vtoroje3,
                        String desert1,String desert2,String desert3){
        this.menu=new Menu();
        menu.creatMenu(3,3,3,pervoje1, pervoje2, pervoj3,
                vtoroje1, vtoroje2, vtoroje3,
                desert1, desert2, desert3);
    }

    /**
     * returns the menu composition
     * @return returns the menu items
     */
    public String getMenuCafe(){
        return menu.showMenu();
    }

    /**
     *Initializes the cafe object {@link Review}.
     *This object is an aggregation for this object
     */
    public void setRev(){
        this.review=new Review();
    }

    /**
     * Returns a cafe rating
     * @return Evaluation of the cafe
     */
    public float getHodnotaRew(){
        return review.getRating();
    }

    /**
     * Establishes a cafe rating
     * @param rating The score that will be established.
     */
    public void setHodnotaRew(float rating){
        review.setRating(rating);
    }

    /**
     * Returns the name of the cafe.
     * @return Name of the cafe
     */
    public String getNameCafe(){
        return this.name;
    }

    /**
     * Sets the name of the cafe
     * @param name Name that will be set for the cafe
     */
    public void setNameCafe(String name){
        this.name=name;
    }


}
