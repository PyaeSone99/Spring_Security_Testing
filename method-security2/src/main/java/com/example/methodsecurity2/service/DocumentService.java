package com.example.methodsecurity2.service;

import com.example.methodsecurity2.dao.DocumentDao;
import com.example.methodsecurity2.ds.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class DocumentService {
    @Autowired
    private DocumentDao documentDao;

    @PreAuthorize("hasPermission(#code,'document','ROLE_ADMIN')")
    public Document getDocumentV2(String code){
        return documentDao.findDocument(code);
    }

    @PostAuthorize("hasPermission(returnObject,'ROLE_ADMIN')")
    public Document getDocument(String code){
        return documentDao.findDocument(code);
    }
}
