package com.webview.webview.repositories;

import com.webview.webview.model.Visit;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitRepository extends MongoRepository<Visit, String> {
}
