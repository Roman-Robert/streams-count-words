package com.epam.rd.autotasks;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Words {

    public String countWords(List<String> lines) {

        List<String> words = lines.stream()
                .map(line -> line.toLowerCase()
                        .replaceAll("[^a-zA-Zа-яА-Яóöáúíèêéëïü0123456789]+", " ")
                        .split(" "))
                .flatMap(Arrays :: stream)
                .filter(word -> word.length() >= 4)
                .collect(Collectors.groupingBy(str -> str, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(w -> w.getValue() >=10 )
                .sorted(Map.Entry.comparingByKey())
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(result -> String.format("%s - %d", result.getKey(), result.getValue()))
                .collect(Collectors.toList());




        return words.toString()
                .replace(", ", "\n")
                .replaceAll("[\\],\\[]", "");
    }
}
