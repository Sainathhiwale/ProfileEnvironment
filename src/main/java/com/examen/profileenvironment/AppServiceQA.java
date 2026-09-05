package com.examen.profileenvironment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service("AppServiceQA")
@Profile("qa")
public class AppServiceQA implements AppService{

    @Value("${app.name}")
    private String appName;
    @Value("${app.version}")
    private String appVersion;

    @Value("${app.activated.server}")
    private String serviceName;

    @Autowired
    Environment environment;
    @Override
    public void getAppInfo() {
        System.out.println("This is the QA environment");
        System.out.println("App Name: " + appName);
        System.out.println("App Version: " + appVersion);
        System.out.println("App environment: " + Arrays.toString(environment.getActiveProfiles()));
        System.out.println("App profile: "+ serviceName);
    }
}
