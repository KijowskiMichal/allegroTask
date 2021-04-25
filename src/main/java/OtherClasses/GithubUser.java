package OtherClasses;

import java.util.ArrayList;

/**
 * Class for object representing single user with his repositories.
 */
public class GithubUser
{
    /**
     * Nickname of user
     */
    private String nickname;

    /**
     * Number of stars associated with username
     */
    private int stars;

    /**
     * List of users repositories.
     */
    private ArrayList<RepositoryItem> repositoryItems;

    /**
     * @param nickname  Nickname of user
     * @param stars Number of stars associated with username
     */
    public GithubUser(String nickname, int stars) {
        this.nickname = nickname;
        this.stars = stars;
        this.repositoryItems = new ArrayList<RepositoryItem>();
    }

    /**
     * @return Nickname of user
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * @param nickname Nickname of user
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * @return Number of stars
     */
    public int getStars() {
        return stars;
    }

    /**
     * @param stars  Number of stars
     */
    public void setStars(int stars) {
        this.stars = stars;
    }

    /**
     * @return List of users repositories.
     */
    public ArrayList<RepositoryItem> getRepositoryItems() {
        return repositoryItems;
    }

    /**
     * @param repositoryItems  List of users repositories.
     */
    public void setRepositoryItems(ArrayList<RepositoryItem> repositoryItems) {
        this.repositoryItems = repositoryItems;
    }
}
