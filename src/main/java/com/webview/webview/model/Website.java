package com.webview.webview.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document(collection = "website")
public class Website {
    @Id
    private String id;

    @Indexed(unique = true)
    public String url;

    private Integer totalVisits;

    public Website(String url) {
        this.url = url;
        this.totalVisits = 0;
    }

    public Website(String url, Integer totalVisits) {
        this.url = url;
        this.totalVisits = totalVisits;
    }
}