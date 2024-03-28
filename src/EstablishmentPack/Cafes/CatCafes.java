package EstablishmentPack.Cafes;

import EstablishmentPack.OpisEstablishment.Menu;

public class CatCafes extends Cafe{
    private String menuu="CateCafe and ramen";
    private Menu menu;
    public CatCafes(String name){
//        menu=new Menu( "Chocolate lava cake","Cheesecake","Tiramisu",
//                "Apple pie","Red velvet cake","Fruit tart",
//                "Brownie sundae","Lemon meringue pie","Ice cream sandwich");
        setMenu("Chocolate lava cake","Cheesecake","Tiramisu",
                "Apple pie","Red velvet cake","Fruit tart",
                "Brownie sundae","Lemon meringue pie","Ice cream sandwich");
        setNameCafe(name);
        setRev();
    }
    public String getCatCName(){
        return this.getNameCafe();
    }
//    public String getMenuCafe(){
//        return .menu.showMenu();
//    }

    @Override
    public String displayInfo() {
        String report="";
        report= report+getCatCName()+"\n"+"bude infa pre Cafe (Maxim, nečítaj toto.)"+"\n"+this.menuu;
        return report;
    }
}
