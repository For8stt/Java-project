package EstablishmentPack.Cafes;

import EstablishmentPack.OpisEstablishment.Menu;

public class LamaCafes extends Cafe{
    private String menuu="LamaCafes and ramen";

    public LamaCafes(String name){
        setMenu("Llama Latte","Andean Llama Salad","Llama Quesadillas",
                "Llama Shepherd's Pie","Peruvian Llama Stew","Llama Burger",
                "Llama Ice Cream Sundae","Llama Wrap","Llama Lovers' Pizza");
        setNameCafe(name);
        setRev();
    }
    public String getCatCName(){
        return this.getNameCafe();
    }

    @Override
    public String displayInfo() {
        String report="";
        report= report+getCatCName()+"\n"+"bude infa pre Cafe (Maxim, nečítaj toto.)"+"\n"+this.menuu;
        return report;
    }
}
