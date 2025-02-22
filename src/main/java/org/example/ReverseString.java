package org.example;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

public class ReverseString {
    private final InputStream inputStream;
    private final BufferedWriter bufferedWriter;

    ReverseString() {
        this.inputStream=null;
        this.bufferedWriter =null;
    }
    public ReverseString(String inputFilePath, String outputFilePath) throws IOException {
        try {
            this.inputStream =
                    this.getClass().getClassLoader().getResourceAsStream(inputFilePath);
            this.bufferedWriter = new BufferedWriter(new FileWriter(outputFilePath));
        }catch (Exception ex) {
            System.out.println("Error while accessing input or output file");
            throw ex;
        }
    }

    public ReverseString(InputStream inputStream,  BufferedWriter bufferedWriter) {
        this.inputStream = inputStream;
        this.bufferedWriter = bufferedWriter;
    }
    public void reverse () {
        if(inputStream==null || bufferedWriter==null) {
            System.out.println("Input | Output file is not available/accessible");
            return;
        }
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
             this.bufferedWriter) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String reversedLine = new StringBuilder(line).reverse().toString();
                    bufferedWriter.write(reversedLine);
                    bufferedWriter.newLine();
                }
                System.out.println("Reversed lines saved to file" );
            } catch (IOException e) {
                System.out.println("Exception while Performing IO "+e.getMessage());
            }
    };
}
