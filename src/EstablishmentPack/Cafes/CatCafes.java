package EstablishmentPack.Cafes;

/**
 * A subclass that extends the Cafe class
 */
public class CatCafes extends Cafe{
    private String mainDishCatCafes="Tiramisu";

    /**
     * A class constructor that sets the menu and grade overview for a cafe with cats
     * @param name The name of the cafe which will be called this cafe
     */
    public CatCafes(String name){
        setMenu("Chocolate lava cake","Cheesecake","Tiramisu",
                "Apple pie","Red velvet cake","Fruit tart",
                "Brownie sundae","Lemon meringue pie","Ice cream sandwich");
        setNameCafe(name);
        setRev();
    }

    /**
     * Method for getting a name for a cafe with cats
     * @return Name of the cafe
     */
    public String getCatCName(){
        return this.getNameCafe();
    }


    /**
     * Overridden displayInfo() method that returns information about a cafe with cats
     * Overridden from the class it inherits {@link Cafe}
     *
     * @return A line with information about a cafe with cats
     */
    @Override
    public String displayInfo() {
        String report="";
        report= report
                +getCatCName()+"\n"
                +"-----------\n"
                +"Location: Bratislava, Mirna Street 5\n"
                +"-----------\n"
                +"Concept: \"Cat Cafes\" is a unique place\n " +
                "where you can enjoy great food and drinks, \n" +
                "surrounded by a cozy atmosphere and pleasant \n" +
                "furry friends - cats.\n" +
                "It is an ideal place for those who love cats \n" +
                "and want to spend time in their company.\n"
                +"-----------\n"
                +"Opening hours: Open daily from 10:00 to 20:00.\n"
                +"-----------\n"
                +"Popular dish: "
                +this.mainDishCatCafes;

        return report;
    }
}
