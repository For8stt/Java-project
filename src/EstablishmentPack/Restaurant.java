package EstablishmentPack;

import EstablishmentPack.OpisEstablishment.Bar;
import EstablishmentPack.OpisEstablishment.Menu;
import EstablishmentPack.OpisEstablishment.Review;
import gui.Controlers.ConOvrvOfEstab;

public class Restaurant implements Establishment{
    private String name;

//    private float hodnota=0;
    private Review review;
    private Bar bar;
    public Restaurant(){
    }
    public void setRev(){
        this.review=new Review();
    }
    public float getHodnotaRew(){
       return review.getRating();
    }
    public void setHodnotaRew(float rating){
        review.setRating(rating);
    }
//    public float getHodnota(){
//        float roundedValue = Math.round(this.hodnota * 10) / 10.0f;
//        return roundedValue;
//    }
//    public void setHodnota(float hodnota){
//        this.hodnota=hodnota;
//    }
    public String getNameRestaurant(){
        return this.name;
    }
    public void setNameRestaurant(String name){
        this.name=name;
    }
    @Override
    public String displayInfo() {
        String report="";
        report= report+this.name+"\n"+"bude infa";
        return report;
    }
    public String getMenuRes(){
        return "null";
    }
    public void setBar(String drink1,String drink2,String drink3){
        bar=new Bar( drink1, drink2, drink3);
    }
    public String getBar(){
        return bar.getBar();
    }
}
