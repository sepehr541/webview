package com.webview.webview.services;

import com.webview.webview.model.Visit;
import com.webview.webview.repositories.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VisitService {
    @Autowired
    private VisitRepository visitRepository;

    @Autowired
    private WebsiteService websiteService;

    public void saveVisit(String url) {
        visitRepository.save(new Visit(url));
        websiteService.incWebsiteVisit(url);
    }
}
