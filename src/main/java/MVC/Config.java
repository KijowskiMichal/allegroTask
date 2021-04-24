package MVC;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * Configurator of SpringMVC
 */
@Configuration
public class Config implements WebMvcConfigurer
{

    /**
     * @param registry ResourceHandlerRegistry object
     *
     * Setting of serving static files.
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry)
    {
        // setting of serving css folder
        registry.addResourceHandler("css/**").addResourceLocations("/WEB-INF/classes/css/");
    }

    /**
     * @return ViewResolver object.
     *
     * Setting viewResolver up.
     */
    @Bean
    public ViewResolver viewResolver()
    {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/classes/");
        viewResolver.setSuffix("");
        return viewResolver;
    }
}
