package OtherClasses;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GithubDataTest {

    @Test
    void getGithubUserFromAPI()
    {
        GithubUser githubUser = GithubData.getGithubUserFromAPI("KijowskiMichal");
        assertEquals(githubUser.getNickname(), "KijowskiMichal");
        //assertArrayEquals(new int[]{githubUser.getStars()}, new int[]{2}); // this value can be changed over time
        boolean test1 = false;
        for (RepositoryItem repositoryItem : githubUser.getRepositoryItems())
        {
            if (repositoryItem.getNameOfRepository().equals("allegroTask"))
            {
                test1 = true;
                break;
            }
        }
        assertArrayEquals(new boolean[]{true}, new boolean[]{test1});
    }
}