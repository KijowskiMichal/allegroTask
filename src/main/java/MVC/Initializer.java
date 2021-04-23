package MVC;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Initializer of SpringMVC and log4j2
 */
@Configuration
@EnableWebMvc
@ComponentScan("MVC")
public class Initializer extends AbstractAnnotationConfigDispatcherServletInitializer
{
    private static final Logger LOG = LogManager.getLogger();

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{Initializer.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    public static Logger getLogger() {
        return LOG;
    }

}