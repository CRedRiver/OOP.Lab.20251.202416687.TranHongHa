package hust.soict.dsai.garbage;

import java.util.Random;

public class ConcatenationInLoops {
    public static void main(String[] args) {
        Random r = new Random(123);
        long start = System.currentTimeMillis();
        String s = "";
        for (int i = 0; i < 65536; i++) {
            s += r.nextInt(2);
            }
            //>1000ms
        System.out.println("Time using String +: " + (System.currentTimeMillis() - start) + " ms");

        r = new Random(123);
        start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 65536; i++) {
            sb.append(r.nextInt(2));
        }
        s = sb.toString();
                          //~10ms                                      
        System.out.println("Time using StringBuilder: " + (System.currentTimeMillis() - start) + " ms");
    }
}
                                                                                                                                        