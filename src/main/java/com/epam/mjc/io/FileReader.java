package com.epam.mjc.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Logger;


public class FileReader {
    private static final Logger log = Logger.getLogger(FileReader.class.getName());
    public Profile getDataFromFile(File file) {
        StringBuilder builder = new StringBuilder();
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            int ch;
            while ((ch = fileInputStream.read()) != -1) {
                builder.append(Character.toChars(ch));
            }
        } catch (FileNotFoundException ex) {
            log.info(ex.getMessage()+ " File not found");
        } catch (IOException ex) {
            log.info(ex.getMessage()+ " IO exception");
        }
        String[] contents = builder.toString().split("\n");
        return new Profile(contents[0].substring(6).strip(),
                Integer.parseInt(contents[1].substring(5).strip()),
                contents[2].substring(7).strip(),
                Long.parseLong(contents[3].substring(7).strip()));
    }

}
