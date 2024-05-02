package EstablishmentPack.Cafes;

/**
 * A subclass that extends the Cafe class and represents llama cafes.
 */
public class LamaCafes extends Cafe{
    private String mainDish="Andean Llama Salad";
    /**
     * Class constructor that sets the menu and overview for a cafe with llamas.
     * @param name The name of the cafe.
     */
    public LamaCafes(String name){
        setMenu("Llama Latte","Andean Llama Salad","Llama Quesadillas",
                "Llama Shepherd's Pie","Peruvian Llama Stew","Llama Burger",
                "Llama Ice Cream Sundae","Llama Wrap","Llama Lovers' Pizza");
        setNameCafe(name);
        setRev();
    }
    /**
     * Method to get the name of a cafe with llamas.
     * @return The name of the cafe.
     */
    public String getLamaCName(){
        return this.getNameCafe();
    }

    /**
     * The displayInfo() method is overridden, which returns information about a cafe with llamas.
     * Overridden from the class it inherits {@link Cafe}
     *
     * @return A string with information about the cafe with llamas.
     */
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
