package com.zsy.product.service.impl;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Lucas
 * @create 2023-08-27 1:56
 */
public class CategoryServiceImplTest {

    @Test
    public void queryPage() {
        Set<Integer> collect = new ArrayList<Integer>().stream()
                .filter(integer -> integer != null)
                .map(integer -> integer)
                .collect(Collectors.toSet());
    }
}