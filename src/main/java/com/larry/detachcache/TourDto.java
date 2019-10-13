package com.larry.detachcache;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Builder
@Value
public class TourDto {

    private Long id;
    private String name;
    private List<Option> options;

}
