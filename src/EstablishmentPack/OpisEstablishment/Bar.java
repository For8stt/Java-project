package EstablishmentPack.OpisEstablishment;

import java.io.Serializable;

public class Bar implements Serializable  {
    private String bar;
    private String drink1;
    private String drink2;
    private String drink3;
    public Bar(String drink1,String drink2,String drink3){
        this.drink1 = drink1;
        this.drink2 = drink2;
        this.drink3 = drink3;
        creatBar();
    }
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
    public String getBar(){
        return bar;
    }
}
