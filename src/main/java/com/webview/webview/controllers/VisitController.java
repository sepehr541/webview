package com.webview.webview.controllers;

import com.webview.webview.services.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class VisitController {
    @Autowired
    private VisitService visitService;

    @PostMapping
    private void submitVisit(@RequestBody String url) {
        visitService.saveVisit(url);
    }

}
