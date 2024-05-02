package EstablishmentPack.OpisEstablishment;

import java.io.Serializable;

/**
 * A class representing the bar of an establishment, containing information about available drinks.
 * is an aggregation for the class {@link EstablishmentPack.Restaurant}
 * Serialization is used {@link Serializable}
 */
public class Bar implements Serializable  {
    private String bar;
    private String drink1;
    private String drink2;
    private String drink3;
    /**
     * Constructor for the Bar class, which sets up the available drinks.
     * @param drink1 The first drink available at the bar.
     * @param drink2 The second drink available at the bar.
     * @param drink3 The third drink available at the bar.
     */
    public Bar(String drink1,String drink2,String drink3){
        this.drink1 = drink1;
        this.drink2 = drink2;
        this.drink3 = drink3;
        creatBar();
    }
    /**
     * Method to create the bar menu with available drinks.
     */
    public void creatBar(){
        String barr="---Bar---\n\n";
        barr+="Alcoholic beverages:\n";
        for (int i = 0; i < 3; i++) {
            if (i==0){
                barr+="\t-"+drink1+"\n";
            }else if (i==1){
                barr+="\t-"+drink2+"\n";
            }else {
                barr+="\t-"+drink3+"\n";
            }
        }
        barr+="Juices:\n";
        for (int i = 0; i < 3; i++) {
            if (i==0){
                barr+="\t- Orange juice\n";
            }else if (i==1){
                barr+="\t- Apple juice\n";
            }else {
                barr+="\t- Grape juice\n";
            }
        }
        bar=barr;
    }
    /**
     * Method to get the bar menu with available drinks.
     * @return A string representing the bar menu.
     */
    public String getBar(){
        return bar;
    }
}
