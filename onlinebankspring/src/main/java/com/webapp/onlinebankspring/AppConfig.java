package com.webapp.onlinebankspring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
public class AppConfig {

//    @Bean(name = "messageSource")
//    public ResourceBundleMessageSource messageSource() {
//
//        ResourceBundleMessageSource source = new ResourceBundleMessageSource();
////        source.setBasenames("resources/messages");
//        //classpath:resourcebundles/messages
//        source.setBasenames("classpath:resources/messages");
//        source.setUseCodeAsDefaultMessage(true);
//
//        return source;
//    }
	
    @Bean(name = "messageSource")
    public ReloadableResourceBundleMessageSource messageSource() {

    	ReloadableResourceBundleMessageSource source = new ReloadableResourceBundleMessageSource();
        source.setBasenames("src/main/resources/messages");
        //classpath:resourcebundles/messages
//        source.setBasenames("classpath:resources/messages");
        source.setDefaultEncoding("UTF-8");
        source.setUseCodeAsDefaultMessage(true);

        return source;
    }
    
    @Bean
    public LocalValidatorFactoryBean getValidator() {
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource());
        return bean;
    }
}