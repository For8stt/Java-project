package UserPack;

import EstablishmentPack.AmericanRestaurant;
import EstablishmentPack.AsianRestaurant;
import EstablishmentPack.Cafes.*;
import EstablishmentPack.EuropeanRestaurant;
import EstablishmentPack.Restaurant;

import java.util.ArrayList;


public class VotingSystem {
    private Restaurant[] restaurants;
    private Cafe[] cafes;
//    private Voter[] voters;
    private ArrayList<Voter> voters;
    private Host host;
    private int kolkoUser;
    private int kolkoRest;
    private int kolkoCafes;
    private int akyUser;
//    private boolean[][] votes;
//    private int [][] votesHod;
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
//        return this.voters[i];
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
//        voters=new Voter[kolkoUser];
        voters=new ArrayList<>();
        host=new Host("host","666");
        restaurants=new Restaurant[kolkoRest];
        cafes=new Cafe[kolkoCafes];
//        votes = new boolean[kolkoUser][kolkoRest];
//        votesHod=new int[kolkoUser][kolkoRest];
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
//                voters[i]=new SimpleVoter("aaa","111");
                voters.add(new SimpleVoter("aaa", "111"));
                restaurants[i]=new AmericanRestaurant("American Restaurant");
                cafes[i]=new CatCafes("Cat Cafes");
            }else if(i==1){
//                voters[i]=new SimpleVoter("bbb","222");
                voters.add(new SimpleVoter("bbb", "222"));
                restaurants[i]=new AsianRestaurant("Asian Restaurant");
                cafes[i]=new ConfectioneryCafes("Confectionery Cafes");
            } else {
//                voters[i]=new ExpertVoter("ccc","333");
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
//        for (int i=0;i<kolkoUser;i++){
//            if(voters[i].login(username,password)){
//                this.akyUser=i;
//                return true;
//            }
//        }
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

        // Підраховуємо суму голосів і кількість проголосувавших користувачів
//        for (int i=0;i<kolko;i++){
//            if (voters[i].getHolosoval()){
//                kolkoHolosovali++;
//                sumHolosov+=voters[i].getHodnotaHol();
//            }
//        }

//        for (int i=0;i<kolkoUser;i++){
//            if (votes[i][akyrestoran]){
//                kolkoHolosovali++;
//                sumHolosov+=votesHod[i][akyrestoran];
//            }
//        }
///------------///
//        for (int i = 0; i < kolkoUser; i++) {
//            if (votes.get(i).get(akyrestoran)) {
//                kolkoHolosovali++;
//                sumHolosov += votesHod.get(i).get(akyrestoran);
//            }
//        }
        if (isCafe){
            ///pre cafes
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
            ///pre restoran
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


//        if (!(voters[akyVoterDalHolos].getHolosoval())){
//            voters[akyVoterDalHolos].setHodnotaHol(hodnota);
//            sumHolosov+=hodnota;
//            kolkoHolosovali++;
//            voters[akyVoterDalHolos].setHolosoval(true);
//        }

//        if (!hasVoted(akyVoterDalHolos,akyrestoran)){
//            votesHod[akyVoterDalHolos][akyrestoran]=hodnota;
//            sumHolosov+=hodnota;
//            kolkoHolosovali++;
//            votes[akyVoterDalHolos][akyrestoran] = true;
//            vote(akyVoterDalHolos,akyrestoran);
//        }
        ///__________///
//        if (!hasVoted(akyVoterDalHolos, akyrestoran)) {
//            if (voters.get(akyVoterDalHolos) instanceof SimpleVoter)
//            votesHod.get(akyVoterDalHolos).set(akyrestoran, hodnota);
//            sumHolosov += hodnota;
//            kolkoHolosovali++;
//            vote(akyVoterDalHolos,akyrestoran);
////            votes.get(akyVoterDalHolos).set(akyrestoran, true);
//        }
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
//            votes.get(akyVoterDalHolos).set(akyrestoran, true);
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
//    public void vote(int userId, int restaurantId) {
//        // Позначаємо, що користувач проголосував за цей ресторан
//        votes[userId][restaurantId] = true;
//    }
    public void vote(int userId, int restaurantId,boolean isCafe) {
        // Позначаємо, що користувач проголосував за цей ресторан
        if (isCafe){
            votesCafes.get(userId).set(restaurantId, true);
        }else {
            votes.get(userId).set(restaurantId, true);
        }

    }

    // Метод для перевірки, чи голосував користувач за певний ресторан
//    public boolean hasVoted(int userId, int restaurantId) {
//        return votes[userId][restaurantId];
//    }
    public boolean hasVoted(int userId, int restaurantId,boolean isCafe) {
        if (isCafe){
            return votesCafes.get(userId).get(restaurantId);
        }else {
            return votes.get(userId).get(restaurantId);
        }

    }
    public void setStatistics(){
        String result= "";
        int u=0;
        for (int i = 0; i < kolkoUser; i++) {
            u++;
        }
        result+="Users: "+u+"\n---------------\n";
        for (int i = 0; i < kolkoRest; i++) {
            result+=restaurants[i].getNameRestaurant();
        }
    }


}
