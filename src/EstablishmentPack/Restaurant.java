package EstablishmentPack;

import EstablishmentPack.OpisEstablishment.Bar;
import EstablishmentPack.OpisEstablishment.Review;

import java.io.Serializable;
/**
 * Class representing the restaurant.
 * This class will be inherited by other classes {@link AmericanRestaurant} {@link EuropeanRestaurant} {@link AsianRestaurant}
 * also implements the interface {@link Establishment} and serialization {@link Serializable}
 */
public class Restaurant implements Establishment, Serializable {
    private String name;
    private Review review;
    private Bar bar;
    /**
     * Default constructor for the Restaurant class.
     */
    public Restaurant(){
    }
    /**
     * Method to set up the review for the restaurant.
     * The review will show the rating of this restaurant
     * {@link Review} There is a composition for this object
     */
    public void setRev(){
        this.review=new Review();
    }
    /**
     * Method to get the rating of the restaurant.
     * @return The rating of the restaurant.
     */
    public float getHodnotaRew(){
       return review.getRating();
    }
    /**
     * Method to set the rating of the restaurant.
     * @param rating The rating to be set.
     */
    public void setHodnotaRew(float rating){
        review.setRating(rating);
    }
    /**
     * Method to get the name of the restaurant.
     * @return The name of the restaurant.
     */
    public String getNameRestaurant(){
        return this.name;
    }
    /**
     * Method to set the name of the restaurant.
     * @param name The name of the restaurant.
     */
    public void setNameRestaurant(String name){
        this.name=name;
    }
    /**
     * Method to display information about the restaurant.
     * @return A string containing the name of the restaurant and placeholder information.
     */
    @Override
    public String displayInfo() {
        String report="";
        report= report+this.name+"\n"+"bude infa";
        return report;
    }
    /**
     * Method to get the menu of the restaurant.
     * @return A string representing the menu of the restaurant.
     */
    public String getMenuRes(){
        return "null";
    }
    /**
     * Method to set up the bar with drinks for the restaurant.
     * Creates an object {@link Bar} that is an aggregation for this class
     *
     * @param drink1 The first drink offered at the bar.
     * @param drink2 The second drink offered at the bar.
     * @param drink3 The third drink offered at the bar.
     */
    public void setBar(String drink1,String drink2,String drink3){
        bar=new Bar( drink1, drink2, drink3);
    }

    /**
     * Method to get information about the bar of the restaurant.
     * @return A string representing the drinks available at the bar.
     */
    public String getBar(){
        return bar.getBar();
    }
}
