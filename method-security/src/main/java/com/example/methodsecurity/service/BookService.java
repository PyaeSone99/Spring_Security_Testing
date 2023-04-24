package com.example.methodsecurity.service;

import com.example.methodsecurity.ds.Employee;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BookService {
    private Map<String, Employee> records = Map.of(
            "aung",new Employee(
                    "aung aung", List.of("book1","book2","book3"),List.of("Programmer","Reader")
            ),
            "Spiderman",new Employee(
                    "Andrew",List.of("spiderVerse","sixScense"),List.of("Spider","photographer","Reader")
            )
    );

    @PostAuthorize("returnObject.roles.contains('Reader')")
    public Employee getBookDetails(String name){
        return records.get(name);
    }
}

















