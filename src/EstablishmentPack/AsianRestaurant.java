package EstablishmentPack;


import EstablishmentPack.OpisEstablishment.Menu;

public class AsianRestaurant extends Restaurant{
    private String mainDish="Sushi California";
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
        report= report+getAsianName()+"\n"
                +"-----------\n"
                +"Location: Bratislava, Orientalna Street 8\n"
                +"-----------\n"
                +"Concept: Asian Restaurant is a unique restaurant\n" +
                "that offers its guests a journey into the world\n" +
                "of oriental cuisine. Here you can enjoy the \n" +
                "atmosphere and flavors of various dishes from \n" +
                "Asian countries, from classic to author's.\n"
                +"-----------\n"
                +"Opening hours: open on weekends\n" +
                "from 12:00 to 22:00.\n"
                +"-----------\n"
                +"Popular dish: "
                +this.mainDish;
        return report;
    }
}
