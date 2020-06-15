package com.webview.webview.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Document
public class User {

    @Id
    private String id;

    @Indexed(unique = true)
    private @NonNull String email;

    private @NonNull String password;

    private @NonNull List<String> websites;

    public void addWebsite(String url) {
        this.websites.add(url);
    }

}
