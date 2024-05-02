package EstablishmentPack.OpisEstablishment;

import java.io.Serializable;
/**
 * A class representing a rating of the restaurant or cafe.
 * is a composition for the classes {@link EstablishmentPack.Restaurant} and {@link EstablishmentPack.Cafes.Cafe}
 * Serialization is used {@link Serializable}
 */
public class Review implements Serializable {
    private float rating=0;

    /**
     * Retrieves the rating of the review.
     * @return The rating rounded to one decimal place.
     */
    public float getRating(){
        float roundedValue = Math.round(this.rating * 10) / 10.0f;
        return roundedValue;
    }
    /**
     * Sets the rating of the review.
     * @param rating The rating to be set.
     */
    public void setRating(float rating){
        this.rating=rating;
    }
}
