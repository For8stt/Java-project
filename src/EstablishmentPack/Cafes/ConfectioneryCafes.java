package EstablishmentPack.Cafes;

/**
 * A subclass that extends the Cafe class and represents confectionery cafes.
 */
public class ConfectioneryCafes extends Cafe{
    private String mainDish="Sweet Dream Waffles";
    /**
     * Class constructor that sets the menu and overview for the confectionery cafe.
     * @param name The name of the cafe.
     */
    public ConfectioneryCafes(String name){
        setMenu("Sweet Dream Waffles","Candyland Pancakes","Sugar Rush French Toast",
                "Chocolate Chip Cookie Dough Cheesecake","Cotton Candy Frappuccino","Rainbow Cupcake Delight",
                "Candy-Coated Popcorn","Lollipop Lemon Tart","Fruit Loop Doughnuts");
        setNameCafe(name);
        setRev();
    }
    /**
     * Method to get the name of the confectionery cafe.
     * @return Cafe name.
     */
    public String getConfecCName(){
        return this.getNameCafe();
    }

    /**
     * The displayInfo() method is overridden, which returns information about the confectionery cafe.
     * Overridden from the class it inherits {@link Cafe}
     *
     * @return A string with information about the confectionery cafe.
     */
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
