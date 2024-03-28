package EstablishmentPack.Cafes;

import EstablishmentPack.Establishment;
import EstablishmentPack.OpisEstablishment.Bar;
import EstablishmentPack.OpisEstablishment.Menu;
import EstablishmentPack.OpisEstablishment.Review;

public class Cafe implements Establishment {
    private String name;
    private Review review;
    private Menu menu;
    @Override
    public String displayInfo() {
        String report="";
        report= report+this.name+"\n"+"bude infa pre Cafe";
        return report;
    }
    public Cafe(){
    }
    public void setMenu(String pervoje1,String pervoje2,String pervoj3,
                        String vtoroje1,String vtoroje2,String vtoroje3,
                        String desert1,String desert2,String desert3){
        this.menu=new Menu();
        menu.creatMenu(3,3,3,pervoje1, pervoje2, pervoj3,
                vtoroje1, vtoroje2, vtoroje3,
                desert1, desert2, desert3);
    }
    public String getMenuCafe(){
        return menu.showMenu();
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

    public String getNameCafe(){
        return this.name;
    }
    public void setNameCafe(String name){
        this.name=name;
    }


}
