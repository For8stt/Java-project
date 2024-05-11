package UserPack;

import EstablishmentPack.AmericanRestaurant;
import EstablishmentPack.AsianRestaurant;
import EstablishmentPack.Cafes.*;
import EstablishmentPack.EuropeanRestaurant;
import EstablishmentPack.Restaurant;
import UserPack.Strategy.middleVoiceStrategy;
import javafx.scene.control.Alert;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class VotingSystem implements Serializable {
    /**
     * Array of restaurants and cafes in the system
     */
    private Restaurant[] restaurants;
    private Cafe[] cafes;
    /**
     * List of voters registered in the system.
     */
    private ArrayList<Voter> voters;
    /**
     * The host of the system.
     */
    private Host host;
    /**
     * Number of users in the system.
     */
    private int kolkoUser;
    /**
     * Number of restaurants in the system.
     */
    private int kolkoRest;
    /**
     * Number of cafes in the system.
     */
    private int kolkoCafes;
    /**
     * Index of the current user.
     */
    private int akyUser;
    /**
     * List of votes for restaurants.
     */
    private ArrayList<ArrayList<Boolean>> votes;
    /**
     * List of vote counts for restaurants.
     */
    private ArrayList<ArrayList<Integer>> votesHod;
    /**
     * List of votes for cafes.
     */
    private ArrayList<ArrayList<Boolean>> votesCafes;
    /**
     * List of vote counts for cafes.
     */
    private ArrayList<ArrayList<Integer>> votesHodCafes;
    /**
     * Gets the list of votes for cafes.
     * This method calculates the middle voice for cafes.
     * See {@link UserPack.Strategy.calculateMidleVoiceCafe#calculateMidleVoice(VotingSystem, int)} for details.
     *
     * @return The list of votes for cafes.
     */
    public ArrayList<ArrayList<Boolean>> getVotesCafes() {
        return this.votesCafes;
    }
    /**
     * Gets the list of vote counts for cafes.
     * This method calculates the middle voice for cafes.
     * See {@link UserPack.Strategy.calculateMidleVoiceCafe} for details.
     *
     * @return The list of vote counts for cafes.
     */
    public ArrayList<ArrayList<Integer>> getVotesHodCafes() {
        return this.votesHodCafes;
    }
    /**
     * Gets the list of votes for restaurants.
     * This method calculates the middle voice for restaurants.
     * See {@link UserPack.Strategy.calculateMidleVoiceRest} for details.
     *
     * @return The list of votes for restaurants.
     */
    public ArrayList<ArrayList<Boolean>> getVotes() {
        return this.votes;
    }
    /**
     * Gets the list of vote counts for restaurants.
     * This method calculates the middle voice for restaurants.
     * See {@link UserPack.Strategy.calculateMidleVoiceRest} for details.
     *
     * @return The list of vote counts for restaurants.
     */
    public ArrayList<ArrayList<Integer>> getVotesHod() {
        return this.votesHod;
    }
    /**
     * Gets the number of restaurants in the system.
     * @return The number of restaurants.
     */
    public int getKolkoRest(){
        return this.kolkoRest;
    }
    /**
     * Gets the number of cafes in the system.
     * @return The number of cafes.
     */
    public int getKolkoCafes(){
        return this.kolkoCafes;
    }
    /**
     * Gets the index of the current user.
     * @return The index of the current user.
     */
    public int getAkyUser(){
        return this.akyUser;
    }
    /**
     * Gets the host of the system.
     * @return The host of the system.
     */
    public Host getHost(){
        return this.host;
    }
    /**
     * Gets the voter at the specified index.
     * @param i The index of the voter.
     * @return The voter at the specified index.
     */
    public Voter getVoter(int i){
        return this.voters.get(i);
    }
    /**
     * Gets the voter corresponding to the current user index.
     * @return The voter corresponding to the current user index.
     */
    public Voter voterJe(){
        return this.voters.get(this.akyUser);
    }
    /**
     * Gets the restaurant at the specified index.
     * @param i The index of the restaurant.
     * @return The restaurant at the specified index.
     */
    public Restaurant getRestaurant(int i){
        return this.restaurants[i];
    }
    /**
     * Gets the cafe at the specified index.
     * @param i The index of the cafe.
     * @return The cafe at the specified index.
     */
    public Cafe getCafe(int i){
        return this.cafes[i];
    }


    /**
     *Constructor for building a voting system
     * It internally calls {@link #creatingObjects()} to initialize the system.
     * */
    public VotingSystem(){
        creatingObjects();
    }

    /**
     * Initializes the objects of the voting system.
     * Sets up the necessary data structures and creates users, hosts, restaurants, and cafes.
     * {@code for (int i = 0; i < kolkoUser; i++)}  Creating users, restaurants, and cafes
     * Finally, I have a function to sort cafes and restaurants by their name {@link #sortRestaurantsAndCafesByName()}
     * and a function that uses <T>  {@link #sortBy(List, Comparator)}
     */
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
                restaurants[i]=new EuropeanRestaurant("European Restaurant");
                cafes[i]=new LamaCafes("Lama Cafes");
            } else {
                voters.add(new ExpertVoter("ccc", "333"));
                restaurants[i]=new AsianRestaurant("Asian Restaurant");
                cafes[i]=new ConfectioneryCafes("Confectionery Cafes");
            }
        }
        sortRestaurantsAndCafesByName();
        sortBy(voters, Comparator.comparing(Voter::getUsername));
    }
    /**
     * Sorts the restaurants and cafes by name.
     * use of lambda expressions
     */
    public void sortRestaurantsAndCafesByName() {
        Arrays.sort(restaurants, (r1, r2) -> r1.getNameRestaurant().compareToIgnoreCase(r2.getNameRestaurant()));

        Arrays.sort(cafes, (c1, c2) -> c1.getNameCafe().compareToIgnoreCase(c2.getNameCafe()));
    }
    /**
     * Sorts the list using the specified comparator.
     *  This method provides flexibility in sorting lists of different types of
     *  objects by different comparison criteria.
     *
     * @param list the list to be sorted
     * @param comparator a comparator that determines the order of items in the list
     *                  (use {@link java.util.Comparator} to create comparators)
     * @param <T> type of items in the list
     */
    public <T> void sortBy(List<T> list, Comparator<? super T> comparator) {
        list.sort(comparator);
    }
    /**
     * Registers a new user in the system.
     * @param username The username of the new user.
     * @param password The password of the new user.
     * @param expert Indicates if the new user is an expert or not.
     * @return True if registration is successful, false otherwise.
     */
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

        ArrayList<Boolean> newVotesCafe = new ArrayList<>(kolkoCafes);
        ArrayList<Integer> newVotesHodCafe = new ArrayList<>(kolkoCafes);

        ArrayList<Boolean> newVotes = new ArrayList<>(kolkoRest);
        ArrayList<Integer> newVotesHod = new ArrayList<>(kolkoRest);
        for (int i = 0; i < kolkoRest; i++) {
            newVotes.add(false);
            newVotesHod.add(0);
        }
        for (int i = 0; i < kolkoCafes; i++) {
            newVotesCafe.add(false);
            newVotesHodCafe.add(0);

        }
        votesCafes.add(newVotesCafe);
        votesHodCafes.add(newVotesHodCafe);

        votes.add(newVotes);
        votesHod.add(newVotesHod);
        return true;
    }
    /**
     * Checks the host's login credentials.
     * @param username The username entered by the host.
     * @param password The password entered by the host.
     * @return True if the login is successful, false otherwise.
     */
    public boolean loginCheckHost(String username,String password){
        if (host.login(username, password)) {
            this.akyUser = -2;
            return true;
        }
        return false;
    }

    /**
     * Checks the login credentials of a user.
     * @param username The username entered by the user.
     * @param password The password entered by the user.
     * @return True if the login is successful, false otherwise.
     */
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

    /**
     * Checks if a given name corresponds to a cafe in the system.
     * @param name The name to be checked.
     * @return True if the name corresponds to a cafe, false otherwise.
     */
    public boolean isCafe(String name){
        for (int i = 0; i < getKolkoCafes(); i++) {
            if (name.equals(cafes[i].getNameCafe())){
                return true;
            }
        }
        return false;
    }

    /**
     * Calculates the rating of a restaurant or cafe based on user votes.
     * explicit use of RTTI
     * @param hodnota The value of the vote.
     * @param akyVoterDalHolos The index of the user who voted.
     * @param akyrestoran The index of the restaurant or cafe being voted for.
     * @param isCafe Indicates if the entity being voted for is a cafe.
     * @return The calculated rating of the restaurant or cafe.
     */
    public float hodnoteRest(int hodnota,int akyVoterDalHolos,int akyrestoran, boolean isCafe){
        float result;
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
    /**
     * Records a user's vote for a restaurant or cafe.
     * @param userId The index of the user.
     * @param restaurantId The index of the restaurant or cafe.
     * @param isCafe Indicates if the entity being voted for is a cafe.
     */
    public void vote(int userId, int restaurantId,boolean isCafe) {
        if (isCafe){
            votesCafes.get(userId).set(restaurantId, true);
        }else {
            votes.get(userId).set(restaurantId, true);
        }

    }

    /**
     * Checks if a user has already voted for a restaurant or cafe.
     * @param userId The index of the user.
     * @param restaurantId The index of the restaurant or cafe.
     * @param isCafe Indicates if the entity being voted for is a cafe.
     * @return True if the user has already voted, false otherwise.
     */
    public boolean hasVoted(int userId, int restaurantId,boolean isCafe) {
        if (isCafe){
            return votesCafes.get(userId).get(restaurantId);
        }else {
            return votes.get(userId).get(restaurantId);
        }

    }


    /**
     * Generates statistics on the voting activity.
     * @return A string containing the voting statistics.
     */
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


    /**
     * Saves the current state of the system to a file.
     * @throws ClassNotFoundException If the class of the loaded object cannot be found.
     * @throws IOException  If an I/O error occurs while reading from the file.
     */
    public void save()throws ClassNotFoundException, IOException {
        ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream("holosovanie.out"));
        out.writeObject(this);
        out.close();
    }

    /**
     * Loads a previously saved state of the system from a file.
     * @throws ClassNotFoundException If the class of the loaded object cannot be found.
     * @throws IOException If an I/O error occurs while reading from the file.
     */
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


    /**
     * Resets all votes and ratings to their initial state.
     */
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
        for (int i = 0; i < kolkoUser; i++) {
            getVoter(i).getMiddleVoiceAgr().setMiddleVoiceRest(0);
            getVoter(i).getMiddleVoiceAgr().setMiddleVoiceCafe(0);
        }
    }
    /**
     * Sets the calculation strategy for the average voting.
     * @param strategy The strategy to be used for calculation.
     * @param u The number of users.
     */
    public void setcalculatVoice(middleVoiceStrategy strategy,int u){
        strategy.calculateMidleVoice(this,u);
    }

    /**
     * Calculates the average voting figures for restaurants.
     * @return The calculated average voting figure for restaurants.
     */
    public float calculateMidleVoicefiguresRestResultObserver(){
        float sumAllRest=0;
        int numberOfVotesRest = 0;
        for (int i = 0; i < kolkoUser; i++) {
            if (voters.get(i).getMiddleVoiceAgr().getMiddleVoiceRest()!=0){
                numberOfVotesRest++;
            }
            sumAllRest+=voters.get(i).getMiddleVoiceAgr().getMiddleVoiceRest();
        }
        float res;
        if (numberOfVotesRest==0){
            res=0;
        }else {
            res = sumAllRest/numberOfVotesRest;
            res=Math.round(res*10)/10.0f;
        }
        return res;

    }
    /**
     * Calculates the average voting figures for cafes.
     * @return The calculated average voting figure for cafes.
     */
    public float calculateMidleVoicefiguresCafeResultObserver(){
        float sumAllCafe=0;
        int numberOfVotesCafe = 0;
        for (int i = 0; i < kolkoUser; i++) {
            if (voters.get(i).getMiddleVoiceAgr().getMiddleVoiceCafe()!=0){
                numberOfVotesCafe++;
            }
            sumAllCafe+=voters.get(i).getMiddleVoiceAgr().getMiddleVoiceCafe();
        }
        float res;
        if (numberOfVotesCafe==0){
            res=0;
        }else {
            res = sumAllCafe/numberOfVotesCafe;
            res=Math.round(res*10)/10.0f;
        }
        return res;

    }
    /**
     * Checks if the password contains at least one Latin letters.
     * @param password The password to be checked.
     * @throws checkingForSymbols if the password not contains at least one Latin symbols.
     */
    public void CheckRightPaseord(String password) throws checkingForSymbols {
        String regex = ".*[a-zA-Z].*";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(password);
        if (!matcher.matches()) {
            throw new checkingForSymbols();
        }
    }

}
