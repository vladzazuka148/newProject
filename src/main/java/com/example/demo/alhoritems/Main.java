package com.example.demo.alhoritems;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) {
        System.out.println(getPath("org/java/./main/./src/../../log/pol/../"));
    }
    public static String getPath(String inputPath){
        String[]stringList = inputPath.split("/");
        Deque<String> stringDeque = new ArrayDeque<>();
        for (String s : stringList){
            if (s.equals("..")) {
                if (!(stringDeque.peekLast() == null)) {
                    stringDeque.removeLast();
                    continue;
                }
            }
            if(s.equals(".")){
                continue;
            }
            stringDeque.offerLast(s);
        }
        return stringDeque.toString();
    }
}
