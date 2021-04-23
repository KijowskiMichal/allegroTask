package MVC;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Controller responsible for request mapping.
 */
@org.springframework.stereotype.Controller
@RequestMapping("/")
public class Controller
{
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String mainPage(HttpServletRequest request)
    {
        return "views/mainPage.jsp";
    }

    @RequestMapping(value = "/{nickname}/", method = RequestMethod.GET)
    public String user(HttpServletRequest request, @PathVariable("nickname") String nickname)
    {
        return user(request, nickname, "0");
    }

    @RequestMapping(value = "/{nickname}/{page}/", method = RequestMethod.GET)
    public String user(HttpServletRequest request, @PathVariable("nickname") String nickname, @PathVariable("page") String page)
    {
        return "views/repositoryList.jsp";
    }
}
