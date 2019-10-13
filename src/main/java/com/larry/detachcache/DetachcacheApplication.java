package com.larry.detachcache;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
@EnableCaching
@SpringBootApplication
@RequiredArgsConstructor
public class DetachcacheApplication {

    private final TourRepository tourRepository;
    private final OptionRepository optionRepository;

    @PostConstruct
    public void init() {
        Tour tour = tourRepository.save(new Tour("tour title"));
        Option option1 = optionRepository.save(new Option("description1", tour));
        Option option2 = optionRepository.save(new Option("description2", tour));
    }

    public static void main(String[] args) {
        SpringApplication.run(DetachcacheApplication.class, args);
    }

//    @Bean
//    public SimpleCacheManager cacheManager() {
//        SimpleCacheManager cacheManager = new SimpleCacheManager();
//        CaffeineCache cache = new CaffeineCache("tour",
//                Caffeine.newBuilder()
//                        .expireAfterWrite(10, TimeUnit.SECONDS)
//                        .maximumSize(100)
//                        .build());
//        cacheManager.setCaches(List.of(cache));
//        return cacheManager;
//    }

}
