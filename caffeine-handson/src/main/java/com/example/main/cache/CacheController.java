package com.example.main.cache;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;

@RestController
public class CacheController {

    private LoadingCache<String, String> nameCache;

    @Autowired
    CheckDao dao;

    @PostConstruct
    public void initCache() {
        nameCache = Caffeine.newBuilder()
                .expireAfterAccess(Duration.ofSeconds(60))
                .build(dao::checkCache);
    }

    @GetMapping("checkcache/{name}")
    public String checkNameInCache(@PathVariable("name") String name) {
        return nameCache.get(name);
    }
}
