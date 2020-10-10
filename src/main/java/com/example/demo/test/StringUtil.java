package com.example.demo.test;

import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class StringUtil {

    public String findFirstNotRepetingChar(final String input){
        if(isEmpty(input)){
            return "";
        }

        Map<Character, int[]> map = preProcessData(input);

        return map.entrySet().stream()
                .filter(e -> e.getValue()[0] == e.getValue()[1])
                .map( e -> Map.entry(e.getKey(), e.getValue()[0]))
                .min(Map.Entry.comparingByValue())
                .map(e -> e.getKey().toString())
                .orElse("");
    }

    private Map<Character, int[]> preProcessData(final String input){
        Map<Character, int[]> map = new HashMap<>();
        for(int i = 0; i < input.length(); i++){
            final Character current = input.charAt(i);
            if(isNotSpace(current)) {
                if (!map.containsKey(current)) {
                    map.put(current, new int[]{i, i});
                } else {
                    int firstIndex = map.get(current)[0];
                    map.put(current, new int[]{firstIndex, i});
                }
            }
        }
        return map;
    }

    private boolean isEmpty(final String input){
        return StringUtils.isEmpty(input) || "".equals(input.trim());
    }

    private boolean isNotSpace(Character c){
        return !c.equals(' ');
    }
}
