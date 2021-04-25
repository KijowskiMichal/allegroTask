package MVC;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.BootstrapWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.TestContextBootstrapper;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(MVC.Controller.class)
@ContextConfiguration(classes = {MVC.Initializer.class})
public class ControllerTest {

    public ControllerTest() {
    }

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void mainPage() throws Exception
    {
        mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("views/mainPage.jsp"));
    }

    @Test
    public void user() throws Exception
    {
        mockMvc.perform(MockMvcRequestBuilders.get("/KijowskiMichal/"))
                .andExpect(status().isOk())
                .andExpect(view().name("views/repositoryList.jsp"));
        mockMvc.perform(MockMvcRequestBuilders.get("/KijowskiMichal/1/"))
                .andExpect(status().isOk())
                .andExpect(view().name("views/repositoryList.jsp"));
        mockMvc.perform(MockMvcRequestBuilders.get("/KijowskiMfsggdfsgdsichal/"))
                .andExpect(status().isOk())
                .andExpect(view().name("views/errorPage.jsp"));
    }
}