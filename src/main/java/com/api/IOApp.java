package com.api;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Task:
 *  Getting arguments from user
 *      + getParam
 *  Creating lists of random numbers
 *      + randomNumbers
 *          - parseNumber
 *  Reading and writing files
 *      + writeNewRandomList
 *      + readRandomList
 */
public class IOApp {
    
    public static String getParam(String[] args, String flag) {
        // string whith user argument
        // return string
        String value = null;
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals(flag) && i + 1 < args.length) {
                value = args[i + 1];
                break;
            }
        }
        return value;
    }

    private static Number parseNumber (String item) {
        Number number=null;
        try {
            number = item.contains(".") 
            ? Double.parseDouble(item) 
            : Integer.parseInt(item);
        } catch (Exception e) {}
        return number;
    } 

    public static ArrayList<Number> writeNewRandomList (String masterDirPath, String filename, ArrayList<Number> numbers) {
        
        // create output file in masterDirPath directory
        File directory = new File(masterDirPath);
        File outputFile = new File(directory, filename);

        // write file
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            numbers.stream()
            .map(Number::toString)
            .forEach(str -> { 
                try {
                    bw.append(str).append("\n");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        } catch (Exception e) {}
        return numbers;
    } 

    public static ArrayList<Number> readRandomList (String path) {
        // read random numbers
        ArrayList<Number> content = new ArrayList<>();
        
        // read lines file
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {

                // read 1,2,3 format list
                if (line.contains(",")) {

                    Arrays.stream(line.split("\\s*,\\s*"))
                    .map(IOApp::parseNumber)
                    .collect(Collectors.toList())
                    .forEach(content::add);;
                
                } else {
                    content.add(parseNumber(line));
                }
            }
        } catch (Exception e) {}

        // filter null values
        content.removeIf(item -> item==null);
        return content;
    } 

    public static ArrayList<Number> randomNumbers (int size) {
        Random rand = new Random();
        return rand.ints(
            size, 
            0,
            300
        )
        .boxed()
        .collect(Collectors.toCollection(ArrayList::new));
    }
}
