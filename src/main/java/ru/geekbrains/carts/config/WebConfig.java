package ru.geekbrains.carts.config;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter{
    @Value("${server.port:8443}")
    private int serverPort;

    @Autowired
    private MessageSource messageSource;

    @Override
    public Validator getValidator(){
        LocalValidatorFactoryBean factory = new LocalValidatorFactoryBean();
        factory.setValidationMessageSource(messageSource);
        return factory;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler(
                        "/fonts/",
                        "/img/**",
                        "/css/**",
                        "/js/**")
                .addResourceLocations(
                        "classpath:/static/fonts/",
                        "classpath:/static/img/",
                        "classpath:/static/css/",
                        "classpath:/static/js/");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        super.addViewControllers(registry);
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/register").setViewName("register");
        registry.addRedirectViewController("/", "/home");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        super.addInterceptors(registry);
    }

    @Bean
    public SpringSecurityDialect securityDialect(){
        return new SpringSecurityDialect();
    }

    @Bean
    public EmbeddedServletContainerFactory servletContainer(){
        TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory()
        {
            @Override
            protected void postProcessContext(Context context)
            {
                SecurityConstraint securityConstraint = new SecurityConstraint();
                securityConstraint.setUserConstraint("CONFIDENTIAL");
                SecurityCollection collection = new SecurityCollection();
                collection.addPattern("/*");
                securityConstraint.addCollection(collection);
                context.addConstraint(securityConstraint);
            }
        };
        tomcat.addAdditionalTomcatConnectors(initiateHttpConnector());
        return tomcat;
    }

    private Connector initiateHttpConnector(){
        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
        connector.setScheme("http");
        connector.setPort(8080);
        connector.setSecure(false);
        connector.setRedirectPort(serverPort);

        return connector;
    }
}

