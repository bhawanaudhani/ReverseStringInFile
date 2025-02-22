package org.example;

public class Main {
    public static void main(String[] args) {
        String inputFilePath="input.txt";
        String outputFilePath="output.txt";
        try {
            ReverseString reverseString = new ReverseString(inputFilePath,outputFilePath);
            reverseString.reverse();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
