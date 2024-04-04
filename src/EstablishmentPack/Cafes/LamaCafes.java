package EstablishmentPack.Cafes;


public class LamaCafes extends Cafe{
    private String mainDish="Andean Llama Salad";

    public LamaCafes(String name){
        setMenu("Llama Latte","Andean Llama Salad","Llama Quesadillas",
                "Llama Shepherd's Pie","Peruvian Llama Stew","Llama Burger",
                "Llama Ice Cream Sundae","Llama Wrap","Llama Lovers' Pizza");
        setNameCafe(name);
        setRev();
    }
    public String getLamaCName(){
        return this.getNameCafe();
    }

    @Override
    public String displayInfo() {
        String report="";
        report= report+getLamaCName()+"\n"
                +"-----------\n"
                +"Location: Bratislava, Stepova Street 12\n"
                +"-----------\n"
                +"Concept: \"Lama Cafe is a unique place that\n" +
                "combines the cozy atmosphere of a coffee \n" +
                "shop with the fun of interacting with \n" +
                "llamas. Here you can enjoy delicious coffee\n" +
                "drinks and snacks, surrounded by\n" +
                "friendly and cute llamas.\n"
                +"-----------\n"
                +"Opening hours: Open daily from 9:00 to 21:00.\n"
                +"-----------\n"
                +"Popular dish: "
                +this.mainDish;
        return report;
    }
}
