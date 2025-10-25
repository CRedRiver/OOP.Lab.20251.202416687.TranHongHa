package hust.soict.dsai.garbage;

import java.nio.file.*;
import java.io.IOException;

public class NoGarbage {
    public static void main(String[] args) throws IOException {
        String filename = "D:\\HUST_Code_class\\OOP\\Lab\\Lab03\\OtherProjects\\src\\hust\\soict\\dsai\\garbage\\text.exe";
        byte[] inputBytes = Files.readAllBytes(Paths.get(filename));

        long startTime = System.currentTimeMillis();
        StringBuffer outputString = new StringBuffer();
        for (byte b : inputBytes) {
            outputString.append((char) b);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("NoGarbage took: " + (endTime - startTime) + " ms");
    }
}//Only 1 ms

