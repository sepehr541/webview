package com.webview.webview.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Document
public class Visit implements Persistable<String> {
    @Id
    private String id;

    @CreatedDate
    private Date visitDate;

    @Indexed
    private @NonNull String website;

    @Override
    public boolean isNew() {
        return true;
    }
}
