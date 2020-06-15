package com.webview.webview.repositories;

import com.webview.webview.model.Website;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WebsiteRepository extends MongoRepository<Website, String> {
    Website findByUrl(String url);
    void deleteByUrl(String url);
}
