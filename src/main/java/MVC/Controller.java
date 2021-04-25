package MVC;

import OtherClasses.GithubData;
import OtherClasses.GithubUser;
import OtherClasses.LastRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

/**
 * Controller responsible for request mapping.
 */
@org.springframework.stereotype.Controller
@RequestMapping("/")
public class Controller
{
    /**
     * @param request HttpServletRequest object representing our session
     * @param model Model object for transfer data
     * @return JSP file with specific page
     *
     * The home page that will be used to enter the name of the user whose repositories we want to display.
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String mainPage(HttpServletRequest request, Model model)
    {
        // requests history
        ArrayList<LastRequest> lastRequests = (ArrayList<LastRequest>) request.getSession().getAttribute("lastRequests");
        if (lastRequests==null) lastRequests = new ArrayList<LastRequest>();
        model.addAttribute("lastRequests", lastRequests);
        return "views/mainPage.jsp";
    }

    /**
     * @param request HttpServletRequest object representing our session
     * @param model Model object for transfer data
     * @param nickname Name of the user whose repositories we want to display
     * @return JSP file with specific page
     *
     * A page that lists the repositories of a specific user, without a given page.
     */
    @RequestMapping(value = "/{nickname}/", method = RequestMethod.GET)
    public String user(HttpServletRequest request, Model model, @PathVariable("nickname") String nickname)
    {
        return user(request, model, nickname, "0");
    }

    /**
     * @param request HttpServletRequest object representing our session
     * @param model Model object for transfer data
     * @param nickname Name of the user whose repositories we want to display.
     * @param page Page we want to display.
     * @return JSP file with specific page
     *
     * A page that lists the repositories of a specific user, with the given page.
     */
    @RequestMapping(value = "/{nickname}/{page}/", method = RequestMethod.GET)
    public String user(HttpServletRequest request, Model model, @PathVariable("nickname") String nickname, @PathVariable("page") String page)
    {
        GithubUser githubUser = GithubData.getGithubUserFromAPI(nickname);
        if (githubUser!=null)
        {
            model.addAttribute("username", githubUser.getNickname());
            model.addAttribute("stars", githubUser.getStars());
            //pagination
            int pageNumber = Integer.valueOf(page);
            int pageSize = 8;
            int from = pageNumber * pageSize;
            int to = from + pageSize;
            try
            {
                model.addAttribute("repos", githubUser.getRepositoryItems().subList(from, to));
            } catch (Exception e) {
                model.addAttribute("repos", githubUser.getRepositoryItems().subList(from, githubUser.getRepositoryItems().size()));
            }
            model.addAttribute("pageNumber", pageNumber);
            model.addAttribute("pageMax", (int)Math.ceil((githubUser.getRepositoryItems().size()-1)/pageSize));
            // requests history
            ArrayList<LastRequest> lastRequests = (ArrayList<LastRequest>) request.getSession().getAttribute("lastRequests");
            if (lastRequests == null) lastRequests = new ArrayList<LastRequest>();
            LastRequest.addToLastRequest(lastRequests, nickname, githubUser.getStars());
            request.getSession().setAttribute("lastRequests", lastRequests);
            model.addAttribute("lastRequests", lastRequests);
            return "views/repositoryList.jsp";
        } else return "views/errorPage.jsp";
    }
}
