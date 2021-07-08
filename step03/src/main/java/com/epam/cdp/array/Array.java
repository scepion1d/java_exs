package com.epam.cdp.array;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class Array {
    private final Vector<Double> elements;
    private final int size;

    public void print() {
        log.info("Max: {}", maxElement());
        log.info("Min: {}", minElement());
        log.info("Average: {}", avgElement());
        log.info("Max 5: {}", maxElements(5));
    }

    public Array(int size) {
        elements = new Vector<>();
        this.size = size;
        init();
    }

    public Double maxElement() {
        return elements.get(0);
    }

    public Double minElement() {
        return elements.get(size - 1);
    }

    public Double avgElement() {
        return elements.stream().mapToDouble(x -> x).average().orElse(0.0);
    }

    public List<Double> maxElements(int number) {
        return elements.subList(0, number);
    }

    private void init() {
        for (int i = 0; i < size; i++) {
            elements.add(Math.random());
        }
        Collections.sort(elements, Collections.reverseOrder());
    }
}
