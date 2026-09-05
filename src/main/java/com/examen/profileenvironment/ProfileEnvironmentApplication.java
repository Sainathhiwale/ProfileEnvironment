package com.examen.profileenvironment;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.text.MessageFormat;

@SpringBootApplication
public class ProfileEnvironmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProfileEnvironmentApplication.class, args);
    }
    @Value("${app.name}")
    private String appName;

    @PostConstruct
    public void getInfo(){
        System.out.println(MessageFormat.format("App Name: {0}", appName));
    }

    @Autowired
    @Qualifier("AppServiceQA")
    AppService appService;

   /* @Bean
    public void printInfo(){
        appService.getAppInfo(); // @Bean method 'printInfo' must not be declared as void; change the method's return type or its annotation.
    }*/
    @Bean
    public CommandLineRunner printInfo() {
        return args -> {
            appService.getAppInfo();
        };
    }

}
