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

    // options를 fetch 하지 않는다.
    @Transactional(readOnly = true)
    public TourDto findByIdWithoutOption(Long id) {
        Tour tour = tourService.find(id);
        return TourDto.builder()
                .id(tour.getId())
                .name(tour.getName())
                .build();
    }

    // options를 fetch 한다. 예외 발생!
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
