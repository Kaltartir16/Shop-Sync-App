package com.esensesoftware.demo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Item {
    private Long id;
    private String name;
    private Double price;
    private Long categoryId;

}//ItemDTO
