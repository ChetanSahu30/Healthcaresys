package com.healthcare.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtils {

    // Writes content to a file
    public static void writeToFile(String filePath, String content) throws IOException {
        try (FileWriter writer = new FileWriter(new File(filePath), true)) {
            writer.write(content);
        }
    }

    // Deletes a file
    public static boolean deleteFile(String filePath) {
        File file = new File(filePath);
        return file.delete();
    }
}
