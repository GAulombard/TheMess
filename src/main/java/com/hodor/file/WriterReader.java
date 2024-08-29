package com.hodor.file;

import java.io.*;

public class WriterReader {

    public static void main(String[] args) {

        //writing into a text file using try with resources block
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"))) {
            bw.write("this is the first line");
            bw.write("\nthis is the second line");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //writing into a text file using try with resources block
        // without removing what was already written

        String[] names = {"Luna", "Didi", "Jojo"};

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt", true))) {
            for (String name : names) {
                bw.write("\n" + name);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //reading from existing file using try with resources block
        try (BufferedReader br = new BufferedReader(new FileReader("output.txt"))) {

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
