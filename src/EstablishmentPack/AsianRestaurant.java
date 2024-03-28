package EstablishmentPack;


import EstablishmentPack.OpisEstablishment.Menu;

public class AsianRestaurant extends Restaurant{
    private String menuu="sushi and ramen";
    private Menu menu;
    public AsianRestaurant(String name){
        menu=new Menu( "tom iam","tom iam","sashlyk",
                "california","nagiri","borsh",
                "Noodles with chicken","Noodles with beef","borsh2.0");
        setNameRestaurant(name);
        setBar("Sake","Soju","Shochu");
        setRev();
    }
    public String getAsianName(){
        return this.getNameRestaurant();
    }
    public String getMenuRes(){
        return menu.showMenu();
    }
    @Override
    public String displayInfo() {
        String report="";
        report= report+getAsianName()+"\n"+"bude infa"+"\n"+this.menuu;
        return report;
    }
}
