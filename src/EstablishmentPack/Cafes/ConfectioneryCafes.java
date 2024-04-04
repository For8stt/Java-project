package EstablishmentPack.Cafes;


public class ConfectioneryCafes extends Cafe{
    private String mainDish="Sweet Dream Waffles";
    public ConfectioneryCafes(String name){
        setMenu("Sweet Dream Waffles","Candyland Pancakes","Sugar Rush French Toast",
                "Chocolate Chip Cookie Dough Cheesecake","Cotton Candy Frappuccino","Rainbow Cupcake Delight",
                "Candy-Coated Popcorn","Lollipop Lemon Tart","Fruit Loop Doughnuts");
        setNameCafe(name);
        setRev();
    }
    public String getConfecCName(){
        return this.getNameCafe();
    }

    @Override
    public String displayInfo() {
        String report="";
        report= report+getConfecCName()+"\n"
                +"-----------\n"
                +"Location: Bratislava, 5 Pekarska Street\n"
                +"-----------\n"
                +"Concept: Confectionery Cafes is a coffee shop\n" +
                "that specializes in confectionery and \n" +
                "sweet dishes. Thanks to unique recipes and\n" +
                "exquisite ingredients, you can enjoy the most\n" +
                "delicious desserts and pastries here.\n"
                +"-----------\n"
                +"Opening hours: Open on weekdays\n from 8:00 to 20:00\n"
                +"-----------\n"
                +"Popular dish: "
                +this.mainDish;
        return report;
    }
}
