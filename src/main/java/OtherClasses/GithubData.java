package OtherClasses;

import org.apache.logging.log4j.core.util.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.ArrayList;

/**
 * Auxiliary class for getting data from Github
 */
public class GithubData
{
    /**
     * @param nickname Nickname of user
     * @return GithubUser object represents list of repositories with owner data.
     *
     * Get list of repositories and user data associated with nickname param.
     */
    public static GithubUser getGithubUserFromAPI(String nickname)
    {
        JSONArray jsonArray;
        int resCode = 0;
        try {
            URL url = new URL("https://api.github.com/users/"+nickname+"/repos");
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            resCode = connection.getResponseCode();
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String inputLine;
            while ((inputLine = in.readLine()) != null)
            {
                response.append(inputLine);
            }
            in.close();
            jsonArray = new JSONArray(response.toString());

        } catch (IOException e) {
            return null;
        }
        int numberOfRepositories = jsonArray.toList().size();
        if (numberOfRepositories==0)
        {
            GithubUser githubUser = new GithubUser(nickname, 0);
            return githubUser;
        }
        String userName = jsonArray.getJSONObject(0).getJSONObject("owner").getString("login");
        int numberOfStars = 0;
        ArrayList<RepositoryItem> repositoryItems = new ArrayList<RepositoryItem>();
        for (int i=0; i<numberOfRepositories; i++)
        {
            RepositoryItem repositoryItem = new RepositoryItem(jsonArray.getJSONObject(i).getString("name"), jsonArray.getJSONObject(i).getInt("stargazers_count"), jsonArray.getJSONObject(i).getString("html_url"));
            numberOfStars += repositoryItem.getStars();
            repositoryItems.add(repositoryItem);
        }
        GithubUser githubUser = new GithubUser(userName, numberOfStars);
        githubUser.setRepositoryItems(repositoryItems);
        return githubUser;
    }
}
