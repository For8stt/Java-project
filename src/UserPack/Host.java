package UserPack;

/**
 * Represents a host user.
 * imitates the class {@link User}
 */
public class Host extends User{
    /**
     * Constructor for creating a host user.
     *
     * @param username The username of the host.
     * @param password The password of the host.
     */
    public Host(String username, String password) {
        super.setUsername(username);
        super.setPassword(password);
    }
    /**
     * {@inheritDoc}
     */
    public String getRol(){
        return "Host";
    }
}
