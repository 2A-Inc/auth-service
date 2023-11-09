package com.twoa.tcebi.entity;

import java.util.ArrayList;
import java.util.List;

public class Test {
    List<Integer> a = new ArrayList<>();;
    List<Number> numbers = a;
    private void clazz(){
        numbers.add(a);
    }
}
