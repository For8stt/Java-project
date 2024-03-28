package EstablishmentPack.OpisEstablishment;

public class Review {
    private float rating=0;
//    public Review(){}
    public float getRating(){
        float roundedValue = Math.round(this.rating * 10) / 10.0f;
        return roundedValue;
    }
    public void setRating(float rating){
        this.rating=rating;
    }
}
