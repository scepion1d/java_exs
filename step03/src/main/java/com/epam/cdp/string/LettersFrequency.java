package com.epam.cdp.string;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class LettersFrequency {
    private final Character[] refinedString;
    private final Map<Character, Long> frequency;

    public LettersFrequency(String sample) {
        refinedString = sample.replaceAll("[^a-zA-Z]", "")
                .chars()
                .mapToObj(c -> (char) c)
                .toArray(Character[]::new);
        frequency = calculate();
    }

    public void print() {
        for (Map.Entry<Character, Long> entry : frequency.entrySet()) {
            log.info("{} : {}", entry.getKey(), entry.getValue());
        }
    }

    private Map<Character, Long> calculate() {
        HashMap<Character, Long> result = new HashMap<>();
        Set<Character> keys = new HashSet<>(Arrays.asList(refinedString));

        for (Character key : keys) {
            long count = Arrays.stream(refinedString).filter(x -> x.equals(key)).count();
            result.put(key, count);
        }

        return sort(result);
    }

    private Map<Character, Long> sort(HashMap<Character, Long> unsortedMap) {
        Comparator<Map.Entry<Character, Long>> comparator = (o1, o2) -> {
            if (o1.getValue() > o2.getValue()) {
                return -1;
            } else if (o1.getValue() < o2.getValue()) {
                return 1;
            }

            return Character.compare(o1.getKey(), o2.getKey()) * -1;
        };

        List<Map.Entry<Character, Long>> list = new LinkedList<>(unsortedMap.entrySet());
        list.sort(comparator);

        // ????????????????
        for (Map.Entry<Character, Long> entry : list) {
            log.warn("{} : {}", entry.getKey(), entry.getValue());
        }

        Map<Character, Long> sortedMap = new HashMap<>();
        for (Map.Entry<Character, Long> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }
}
