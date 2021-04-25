package OtherClasses;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Class for object representing single row in repositories list.
 */
public class RepositoryItem
{
    /**
     * Name of a repository, we wanted to display.
     */
    private String nameOfRepository;

    /**
     * Link to the repository.
     */
    private String link;

    /**
     * Number of stars associated with nickname.
     */
    private int stars;

    /**
     * @param nameOfRepository Name of a repository, we wanted to display.
     * @param stars Number of stars associated with nickname.
     */
    public RepositoryItem(String nameOfRepository, int stars, String link)
    {
        this.nameOfRepository = nameOfRepository;
        this.stars = stars;
        this.link = link;
    }

    /**
     * @return Name of a repository.
     *
     * Getter of repository name
     */
    public String getNameOfRepository() {
        return nameOfRepository;
    }

    /**
     * @param nameOfRepository  Name of a repository.
     *
     * Setter of a repository name
     */
    public void setNameOfRepository(String nameOfRepository) {
        this.nameOfRepository = nameOfRepository;
    }

    /**
     * @return Number of stars
     *
     * Getter of stars number
     */
    public int getStars() {
        return stars;
    }

    /**
     * @param stars Number of stars
     *
     * Setter of stars number
     */
    public void setStars(int stars) {
        this.stars = stars;
    }

    /**
     * @return Link to the repository
     *
     * Getter of link to the repository
     */
    public String getLink() {
        return link;
    }

    /**
     * @param link Link to the repository
     *
     * Setter of link to the repository
     */
    public void setLink(String link) {
        this.link = link;
    }
}
