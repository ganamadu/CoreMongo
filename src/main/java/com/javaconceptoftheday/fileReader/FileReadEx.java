package com.javaconceptoftheday.fileReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileReadEx {

    public static void main(String args[]) throws URISyntaxException, IOException {
        /*for(int i=1; i<=10000; i++) {
            System.out.println("FirstName: Ganapathi" +i+" LastName: Madu"+i+" Hyderabad.");
        }*/

        ///home/thanni/Documents/Intellij-workspace/CoreMongo/src/main/resources/LargeData.txt
        Path path = Paths.get("//home//thanni//Documents//Intellij-workspace//CoreMongo//src//main//resources//LargeData.txt");
       /* Files.readAllLines(path)
                .parallelStream().forEach(System.out::println);*/

        int batchSize = 2000;
        List<String> batch = new ArrayList<>(batchSize);

        try(BufferedReader br = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            String line;
            Integer lineNo = 0;
            while ((line = br.readLine()) != null) {
                lineNo++;
                batch.add(line);
                if(batch.size() >= batchSize) {
                    processBatch(batch, lineNo - batch.size() + 1);
                    batch.clear();
                }
            }
            if(!batch.isEmpty()) {
                processBatch(batch, lineNo - batch.size() + 1);
            }
        }





    }
    public static void processBatch(List<String> batch, long startLine) {
        System.out.println("Start Line: "+startLine+", size: "+batch.size());
        batch.stream().forEach(System.out::println);
    }

}
