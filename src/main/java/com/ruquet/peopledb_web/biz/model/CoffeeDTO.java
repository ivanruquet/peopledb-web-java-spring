package com.ruquet.peopledb_web.biz.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class CoffeeDTO {
    private Long id;
    private String title;

    @JsonIgnore
    private String description;
}