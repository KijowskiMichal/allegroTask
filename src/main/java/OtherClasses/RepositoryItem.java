package OtherClasses;

import java.util.ArrayList;
import java.util.Collections;

public class RepositoryItem
{
    /**
     * Name of a repository, we wanted to display.
     */
    public String nameOfRepository;

    /**
     * Number of stars associated with nickname.
     */
    public int stars;

    /**
     * @param nameOfRepository Name of a repository, we wanted to display.
     * @param stars Number of stars associated with nickname.
     */
    public RepositoryItem(String nameOfRepository, int stars)
    {
        this.nameOfRepository = nameOfRepository;
        this.stars = stars;
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
}
