package com.example.main.cache;

import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class CheckDao {
    private static final Map<String, String> DATA = Map.of(
            "Andrew", "01:02:30", "Boris", "01:05:40", "Lena", "01:10:26",
            "George", "02:05:30"
    );

    String checkCache(String name) {
        System.out.println("DAO -> name -> " + name);
        return DATA.get(name);
    }
}