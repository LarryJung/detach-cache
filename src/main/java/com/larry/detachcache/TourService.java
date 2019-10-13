package com.larry.detachcache;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Slf4j
@Service
@RequiredArgsConstructor
public class TourService {

    private final TourRepository tourRepository;

    @Cacheable(cacheNames = "tour", key="#id")
    public Tour find(Long id) {
        log.info(">>>> no cache hit");
        return tourRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }


}
