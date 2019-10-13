package com.larry.detachcache;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TourController {

    private final LandingService landingService;

    @GetMapping("/tours/{tourId}")
    public TourDto getTour(@PathVariable("tourId") Long tourId) {
        return landingService.findByIdWithoutOption(tourId);
    }

    @GetMapping("/tours/{tourId}/withOptions")
    public TourDto getTourWithOptions(@PathVariable("tourId") Long tourId) {
        return landingService.findByIdWithOption(tourId);
    }

}
