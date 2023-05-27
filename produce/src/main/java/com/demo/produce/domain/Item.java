package com.demo.produce.domain;

import java.io.Serializable;

import org.springframework.context.annotation.ComponentScan;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@ComponentScan
public class Item implements Serializable {
    private String itemId;
    private String itemName;
}