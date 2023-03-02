package com.epam.mjc.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class FileReader {

    public Profile getDataFromFile(File file) {
        StringBuilder builder = new StringBuilder();
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            int ch;
            while ((ch = fileInputStream.read()) != -1) {
                builder.append(Character.toChars(ch));
            }
        } catch (FileNotFoundException ex) {
            System.err.print(ex);
        } catch (IOException ex) {
            System.err.print(ex);
        }
        String[] contents = builder.toString().split("\n");
        return new Profile(contents[0].substring(6).strip(),
                Integer.parseInt(contents[1].substring(5).strip()),
                contents[2] = contents[2].substring(7).strip(),
                Long.parseLong(contents[3] = contents[3].substring(7).strip()));
    }

    public static void main(String[] args) {
        FileReader fileReader = new FileReader();
        Profile profile = fileReader.getDataFromFile(new File("src/main/resources/Profile.txt"));
        System.out.println(profile.toString());
    }
}
