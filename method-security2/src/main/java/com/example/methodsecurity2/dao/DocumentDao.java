package com.example.methodsecurity2.dao;

import com.example.methodsecurity2.ds.Document;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class DocumentDao {
    private Map<String, Document> documents = Map.of(
            "abc123",new Document("natalie"),
            "owe123",new Document("natalie"),
            "asd555",new Document("emma")
    );

    public Document findDocument(String code){
        return documents.get(code);
    }
}
