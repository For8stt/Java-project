package UserPack;

import EstablishmentPack.AmericanRestaurant;
import EstablishmentPack.AsianRestaurant;
import EstablishmentPack.Cafes.*;
import EstablishmentPack.EuropeanRestaurant;
import EstablishmentPack.Restaurant;
import javafx.scene.control.Alert;

import java.io.*;
import java.util.ArrayList;


public class VotingSystem implements Serializable {
    private Restaurant[] restaurants;
    private Cafe[] cafes;
    private ArrayList<Voter> voters;
    private Host host;
    private int kolkoUser;
    private int kolkoRest;
    private int kolkoCafes;
    private int akyUser;
    private ArrayList<ArrayList<Boolean>> votes;
    private ArrayList<ArrayList<Integer>> votesHod;
    private ArrayList<ArrayList<Boolean>> votesCafes;
    private ArrayList<ArrayList<Integer>> votesHodCafes;

    public int getKolkoUser(){
        return this.kolkoUser;
    }
    public int getKolkoRest(){
        return this.kolkoRest;
    }
    public int getKolkoCafes(){
        return this.kolkoCafes;
    }
    public int getAkyUser(){
        return this.akyUser;
    }
    public Host getHost(){
        return this.host;
    }

    public Voter getVoter(int i){
        return this.voters.get(i);
    }
    public Voter voterJe(){
        return this.voters.get(this.akyUser);
    }
    public Restaurant getRestaurant(int i){
        return this.restaurants[i];
    }
    public Cafe getCafe(int i){
        return this.cafes[i];
    }



    public VotingSystem(){
        creatingObjects();
    }

    public void creatingObjects(){
        kolkoUser=3;
        kolkoRest=3;
        kolkoCafes=3;

        voters=new ArrayList<>();
        host=new Host("host","666");
        restaurants=new Restaurant[kolkoRest];
        cafes=new Cafe[kolkoCafes];

        votes = new ArrayList<>();
        votesHod = new ArrayList<>();

        votesCafes = new ArrayList<>();
        votesHodCafes = new ArrayList<>();

        for (int i = 0; i < kolkoUser; i++) {
            ArrayList<Boolean> userVotesCafe= new ArrayList<>();
            ArrayList<Integer> userVotesHodCafe = new ArrayList<>();

            ArrayList<Boolean> userVotes = new ArrayList<>();
            ArrayList<Integer> userVotesHod = new ArrayList<>();
            for (int j = 0; j < kolkoRest; j++) {
                userVotes.add(false);

                userVotesHod.add(0);
            }
            for (int j = 0; j < kolkoCafes; j++) {
                userVotesCafe.add(false);

                userVotesHodCafe.add(0);
            }
            votesCafes.add(userVotesCafe);
            votesHodCafes.add(userVotesHodCafe);

            votes.add(userVotes);
            votesHod.add(userVotesHod);
        }


        for (int i=0;i<kolkoUser;i++){
            if (i==0){
                voters.add(new SimpleVoter("aaa", "111"));
                restaurants[i]=new AmericanRestaurant("American Restaurant");
                cafes[i]=new CatCafes("Cat Cafes");
            }else if(i==1){
                voters.add(new SimpleVoter("bbb", "222"));
                restaurants[i]=new AsianRestaurant("Asian Restaurant");
                cafes[i]=new ConfectioneryCafes("Confectionery Cafes");
            } else {
                voters.add(new ExpertVoter("ccc", "333"));
                restaurants[i]=new EuropeanRestaurant("European Restaurant");
                cafes[i]=new LamaCafes("Lama Cafes");
            }
        }
    }
    public boolean registrationCrtUsr(String username,String password,boolean expert){
        for (int i = 0; i < kolkoUser; i++) {
            Voter voter = voters.get(i);
            if (voter.getUsername().equals(username)) {
                return false;
            }
        }
        kolkoUser++;

        if (expert){
            voters.add(new ExpertVoter(username, password));
        }else {
            voters.add(new SimpleVoter(username, password));
        }

        ArrayList<Boolean> newVotesCafe = new ArrayList<>(kolkoRest);
        ArrayList<Integer> newVotesHodCafe = new ArrayList<>(kolkoRest);

        ArrayList<Boolean> newVotes = new ArrayList<>(kolkoRest);
        ArrayList<Integer> newVotesHod = new ArrayList<>(kolkoRest);
        for (int i = 0; i < kolkoRest; i++) {
            newVotesCafe.add(false);
            newVotesHodCafe.add(0);

            newVotes.add(false);
            newVotesHod.add(0);
        }
        votesCafes.add(newVotesCafe);
        votesHodCafes.add(newVotesHodCafe);

        votes.add(newVotes);
        votesHod.add(newVotesHod);
        return true;
    }
    public boolean loginCheckHost(String username,String password){
        if (host.login(username, password)) {
            this.akyUser = -2;
            return true;
        }
        return false;
    }


    public boolean loginCheck(String username,String password){
        for (int i = 0; i < voters.size(); i++) {
            Voter voter = voters.get(i);
            if (voter.login(username, password)) {
                this.akyUser = i;
                return true;
            }
        }
        return false;
    }

    public boolean isCafe(String name){
        for (int i = 0; i < getKolkoCafes(); i++) {
            if (name.equals(cafes[i].getNameCafe())){
                return true;
            }
        }
        return false;
    }

    public float hodnoteRest(int hodnota,int akyVoterDalHolos,int akyrestoran, boolean isCafe){
        float result=0;
        int kolkoHolosovali=0;
        int sumHolosov=0;

        if (isCafe){
            for (int i = 0; i < kolkoUser; i++) {
                if (votesCafes.get(i).get(akyrestoran)) {
                    if (voters.get(i) instanceof SimpleVoter) {
                        kolkoHolosovali++;
                        sumHolosov += votesHodCafes.get(i).get(akyrestoran);
                    }else {
                        kolkoHolosovali+=voters.get(i).getKoefHol();
                        sumHolosov += votesHodCafes.get(i).get(akyrestoran);
                    }
                }
            }
        }else {
            for (int i = 0; i < kolkoUser; i++) {
                if (votes.get(i).get(akyrestoran)) {
                    if (voters.get(i) instanceof SimpleVoter) {
                        kolkoHolosovali++;
                        sumHolosov += votesHod.get(i).get(akyrestoran);
                    }else {
                        kolkoHolosovali+=voters.get(i).getKoefHol();
                        sumHolosov += votesHod.get(i).get(akyrestoran);
                    }
                }
            }
        }


        int hodnotaEx;
        if (!hasVoted(akyVoterDalHolos, akyrestoran,isCafe)) {
            if (voters.get(akyVoterDalHolos) instanceof SimpleVoter) {
                if (isCafe)
                {
                    votesHodCafes.get(akyVoterDalHolos).set(akyrestoran, hodnota);
                }else
                {
                    votesHod.get(akyVoterDalHolos).set(akyrestoran, hodnota);
                }
                sumHolosov += hodnota;
                kolkoHolosovali++;
                vote(akyVoterDalHolos, akyrestoran,isCafe);

            }else {
                hodnotaEx=hodnota*voters.get(akyVoterDalHolos).getKoefHol();
                if (isCafe)
                {
                    votesHodCafes.get(akyVoterDalHolos).set(akyrestoran, hodnotaEx);
                }else
                {
                    votesHod.get(akyVoterDalHolos).set(akyrestoran, hodnotaEx);
                }
                sumHolosov += hodnotaEx;
                kolkoHolosovali+=voters.get(akyVoterDalHolos).getKoefHol();
                vote(akyVoterDalHolos, akyrestoran,isCafe);
            }
        }

        if (kolkoHolosovali!=0) {
            result = sumHolosov / (float)kolkoHolosovali;
        }else {
            result=hodnota;
        }

        return result;
    }
    public void vote(int userId, int restaurantId,boolean isCafe) {
        if (isCafe){
            votesCafes.get(userId).set(restaurantId, true);
        }else {
            votes.get(userId).set(restaurantId, true);
        }

    }

    public boolean hasVoted(int userId, int restaurantId,boolean isCafe) {
        if (isCafe){
            return votesCafes.get(userId).get(restaurantId);
        }else {
            return votes.get(userId).get(restaurantId);
        }

    }
    public String setStatistics(){
        String result= "";
        int u=0;
        for (int i = 0; i < kolkoUser; i++) {
            u++;
        }
        result+="Users: "+u+"\n---------------\n";
        int kolkoDalHol=0;
        for (int i = 0; i < kolkoRest; i++) {
            for (int j = 0; j < kolkoUser; j++) {
                if (hasVoted(j,i,false)){
                    kolkoDalHol++;
                }
            }
            result+=restaurants[i].getNameRestaurant()+":\t"+kolkoDalHol+"\\"+u+"\n";
            kolkoDalHol=0;
        }
        result+="---------------\n";
        kolkoDalHol=0;
        for (int i = 0; i < kolkoCafes; i++) {
            for (int j = 0; j < kolkoUser; j++) {
                if (hasVoted(j,i,true)){
                    kolkoDalHol++;
                }
            }
            result+=cafes[i].getNameCafe()+":\t"+kolkoDalHol+"\\"+u+"\n";
            kolkoDalHol=0;
        }
        return result;
    }


    public void save()throws ClassNotFoundException, IOException {
        ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream("holosovanie.out"));
        out.writeObject(this);
        out.close();
    }

    public void load() throws ClassNotFoundException, IOException {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("holosovanie.out"));
            VotingSystem loadedHolosovanie = (VotingSystem) in.readObject();
            in.close();

            restaurants = loadedHolosovanie.restaurants;
            cafes = loadedHolosovanie.cafes;
            voters = loadedHolosovanie.voters;
            host = loadedHolosovanie.host;
            kolkoUser = loadedHolosovanie.kolkoUser;
            kolkoRest = loadedHolosovanie.kolkoRest;
            kolkoCafes = loadedHolosovanie.kolkoCafes;
            akyUser = loadedHolosovanie.akyUser;
            votes = loadedHolosovanie.votes;
            votesHod = loadedHolosovanie.votesHod;
            votesCafes = loadedHolosovanie.votesCafes;
            votesHodCafes = loadedHolosovanie.votesHodCafes;
        } catch (IOException | ClassNotFoundException e) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            System.out.println(e.getMessage());
            a.setTitle("Error in the file ");
            a.setContentText("Problems with reading from a file.");
            a.showAndWait();
            e.printStackTrace();
        }
    }


    public void obnulyt(){
        for (int i = 0; i < votes.size(); i++) {
            ArrayList<Boolean> row = votes.get(i);

            for (int j = 0; j < row.size(); j++) {
                row.set(j, false);
            }
        }

        for (int i = 0; i < votesHod.size(); i++) {
            ArrayList<Integer> row = votesHod.get(i);

            for (int j = 0; j < row.size(); j++) {
                row.set(j, 0);
            }
        }


        for (int i = 0; i < votesCafes.size(); i++) {
            ArrayList<Boolean> row = votesCafes.get(i);

            for (int j = 0; j < row.size(); j++) {
                row.set(j, false);
            }
        }

        for (int i = 0; i < votesHodCafes.size(); i++) {
            ArrayList<Integer> row = votesHodCafes.get(i);
            for (int j = 0; j < row.size(); j++) {
                row.set(j, 0);
            }
        }

        for (int i = 0; i < kolkoRest; i++) {
            restaurants[i].setHodnotaRew(0);
        }
        for (int i = 0; i < kolkoCafes; i++) {
            cafes[i].setHodnotaRew(0);
        }
    }
}
