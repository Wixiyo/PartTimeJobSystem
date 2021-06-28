package com.example.unitest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author panxiangyu
 * @date 2021年06月28日21:40
 */
@Setter
@Getter
@AllArgsConstructor
@ToString
public class UnitTestMethod {
    public String name;
    public String type;
    public String detail;
    public String value;
}
