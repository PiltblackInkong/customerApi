package com.chakhrit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableJpaAuditing
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);}

        @Bean
        public FilterRegistrationBean corsFilterRegistration(){
            FilterRegistrationBean registrationBean = 
            new FilterRegistrationBean(new CORSFilter());
            registrationBean.setName("CORS Filter");
            registrationBean.addUrlPatterns("/*");
            registrationBean.setOrder(1);
            return registrationBean;
        }

    

}
