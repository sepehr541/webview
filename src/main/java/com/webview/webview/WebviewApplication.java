package com.webview.webview;

import com.webview.webview.model.User;
import com.webview.webview.model.Visit;
import com.webview.webview.model.Website;
import com.webview.webview.repositories.UserRepository;
import com.webview.webview.repositories.VisitRepository;
import com.webview.webview.repositories.WebsiteRepository;
import com.webview.webview.services.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableMongoAuditing
public class WebviewApplication implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private WebsiteRepository websiteRepository;
    @Autowired
    private VisitRepository visitRepository;

    @Autowired
    private VisitService visitService;

    public static void main(String[] args) {
        SpringApplication.run(WebviewApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // clean all previous data
        userRepository.deleteAll();
        websiteRepository.deleteAll();
        visitRepository.deleteAll();

        User userTest = userRepository.save(new User("email", "test", new ArrayList<>()));
        System.out.println(userTest);
        websiteRepository.save(new Website("test.com", 0));
        userTest.addWebsite("test.com");
        userRepository.save(userTest);
        visitService.saveVisit("test.com");
        visitService.saveVisit("test.com");


        List<User> users = userRepository.findAll();
        for(User user: users){
            System.out.println(user);
        }

        List<Website> websites = websiteRepository.findAll();
        for(Website website: websites){
            System.out.println(website);
        }

        List<Visit> visits = visitRepository.findAll();
        for(Visit visit: visits){
            System.out.println(visit);
        }
    }
}
