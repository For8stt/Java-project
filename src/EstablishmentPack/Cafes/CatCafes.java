package EstablishmentPack.Cafes;


public class CatCafes extends Cafe{
    private String mainDishCatCafes="Tiramisu";
    public CatCafes(String name){
        setMenu("Chocolate lava cake","Cheesecake","Tiramisu",
                "Apple pie","Red velvet cake","Fruit tart",
                "Brownie sundae","Lemon meringue pie","Ice cream sandwich");
        setNameCafe(name);
        setRev();
    }
    public String getCatCName(){
        return this.getNameCafe();
    }


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
