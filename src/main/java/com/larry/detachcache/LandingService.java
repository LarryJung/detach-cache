package com.larry.detachcache;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Slf4j
@Service
@RequiredArgsConstructor
public class LandingService {

    private final TourService tourService;

    @Transactional(readOnly = true)
    public TourDto findByIdWithoutOption(Long id) {
        Tour tour = tourService.find(id);
        return TourDto.builder()
                .id(tour.getId())
                .name(tour.getName())
                .build();
    }

    @Transactional(readOnly = true)
    public TourDto findByIdWithOption(Long id) {
        Tour tour = tourService.find(id);
        return TourDto.builder()
                .id(tour.getId())
                .name(tour.getName())
                .options(tour.getOptions())
                .build();
    }


}
