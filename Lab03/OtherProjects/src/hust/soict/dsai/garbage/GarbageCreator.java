package hust.soict.dsai.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GarbageCreator {

    public static void main(String[] args) {
        String filename = "D:\\HUST_Code_class\\OOP\\Lab\\Lab03\\OtherProjects\\src\\hust\\soict\\dsai\\garbage\\text.exe"; 
        
        byte[] inputBytes = {0};
        long startTime, endTime;

        try {
            inputBytes = Files.readAllBytes(Paths.get(filename));
        } 
        catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error: Could not read file ");
            return;
        }
        startTime = System.currentTimeMillis(); 

        String outputString = "";
        
        for (byte b : inputBytes) {
            outputString += (char)b; 
        }

        endTime = System.currentTimeMillis(); 
        
        System.out.println("GarbageCreator Time Taken: " + (endTime - startTime) + " ms");
    }
}
