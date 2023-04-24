package com.example.methodsecurity.service;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class NameService {

    private Map<String,List<String>> secretName = Map.of(
            "pyae",List.of("Far from the Maddening Crowd","Under the Greenwood Tree","Tess of the d'erber"),
            "skywalker",List.of("The Great Exception","A Tale of Two Cites","Oliver Twist")
    );

    @PreAuthorize("hasAnyAuthority('write','read')")
    public String getName(){
        return "Oh! Pyae Sone Aung";
    }

    @PreAuthorize("#name == authentication.principal.username")
    public List<String> getSecretName(String name){
        return secretName.get(name);
    }
}