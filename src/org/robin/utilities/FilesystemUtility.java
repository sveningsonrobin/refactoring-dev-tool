package org.robin.utilities;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FilesystemUtility {
    private static final String FILE_ENCODING = "UTF-8";

    public static List<String> readFile(String path) throws IOException {
        return Files.readAllLines(Paths.get(path));
    }

    public static void saveFile(String path, String content) throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter printWriter = new PrintWriter(path, FILE_ENCODING);

        printWriter.print(content);
        printWriter.close();
    }
}
