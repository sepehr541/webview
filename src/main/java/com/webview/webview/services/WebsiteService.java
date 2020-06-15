package com.webview.webview.services;

import com.webview.webview.model.Website;
import com.webview.webview.repositories.WebsiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class WebsiteService {
    @Autowired
    private WebsiteRepository websiteRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    Website getWebsite(String url) {
        return websiteRepository.findByUrl(url);
    }

    Website makeWebsite(String url) {
        return websiteRepository.save(new Website(url));
    }

    void deleteWebsite(String url) {
        websiteRepository.deleteByUrl(url);
    }

    void incWebsiteVisit(String url) {
        Query query = new Query(Criteria.where("url").is(url));
        Update update = new Update().inc("totalVisits", 1);
        mongoTemplate.update(Website.class).matching(query).apply(update).findAndModifyValue();
    }

}
