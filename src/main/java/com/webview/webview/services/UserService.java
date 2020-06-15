package com.webview.webview.services;

import com.webview.webview.model.User;
import com.webview.webview.model.UserWithWebsites;
import com.webview.webview.repositories.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.LookupOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public User saveUser(User user) {
        User saved = repository.insert(user);
        return saved;
    }

    public List<User> getAllUser() {
        return repository.findAll();
    }

    public User getUserByEmail(String email) {
        return repository.findUserByEmail(email);
    }

    public User getUserById(String id) {
        return repository.findUserById(id);
    }

    public void deleteUser(String id) {
       repository.deleteById(id);
    }

    public void addWebsite(String email, String url) {
        User user = this.getUserByEmail(email);
        user.addWebsite(url);
        repository.save(user);
    }

    public List<UserWithWebsites> getUserWithWebsites(String userId) {
        //System.out.println(userId);
        LookupOperation lookupOperation = LookupOperation.newLookup()
                .from("website")
                .localField("websites")
                .foreignField("url")
                .as("websites");
        Aggregation aggregation = Aggregation.newAggregation(Aggregation.match(Criteria.where("_id").is(new ObjectId(userId))), lookupOperation);
        List<UserWithWebsites> results = mongoTemplate.aggregate(aggregation, "user", UserWithWebsites.class).getMappedResults();
        return results;
    }
}