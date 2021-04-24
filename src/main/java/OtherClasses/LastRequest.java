package OtherClasses;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Object to represents last requested nicknames associated with stars.
 */
public class LastRequest
{
    /**
     * Nickname of user, we wanted to display.
     */
    public String nickname;

    /**
     * Number of stars associated with nickname.
     */
    public int stars;

    /**
     * @param nickname Nickname of user, we wanted to display.
     * @param stars Number of stars associated with nickname.
     */
    public LastRequest(String nickname, int stars)
    {
        this.nickname = nickname;
        this.stars = stars;
    }

    /**
     * @param lastRequestArrayList List of last requests. Theres an object from session.
     * @param nickname Nickname for adding.
     * @param stars Number of star associated with nickname.
     * @return List of last request with new object added.
     */
    public static ArrayList<LastRequest> addToLastRequest(ArrayList<LastRequest> lastRequestArrayList, String nickname, int stars)
    {
        Collections.reverse(lastRequestArrayList);
        int maxLastRequestSize = 5;
        // check if element exist in list
        LastRequest lastRequestToRemove = null;
        for (LastRequest lastRequest : lastRequestArrayList)
        {
            if (nickname.equals(lastRequest.getNickname()))
            {
                lastRequestToRemove = lastRequest;
            }
        }
        if (lastRequestToRemove!=null) lastRequestArrayList.remove(lastRequestToRemove);
        // check max size of list
        if (lastRequestArrayList.size()==maxLastRequestSize) lastRequestArrayList.remove(0);
        // add item to list
        lastRequestArrayList.add(new LastRequest(nickname, stars));
        Collections.reverse(lastRequestArrayList);
        return lastRequestArrayList;
    }

    /**
     * @return Nickname of user.
     *
     * Getter of nickname
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * @param nickname  Nickname of user.
     *
     * Setter of nickname
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
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
