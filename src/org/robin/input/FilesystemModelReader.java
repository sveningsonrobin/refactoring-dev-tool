package org.robin.input;

import org.robin.configuration.Configuration;
import org.robin.models.File;
import org.robin.utilities.FilesystemUtility;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FilesystemModelReader {
    public FileHandler readFiles(Configuration configuration, String[] filePaths) throws Exception {
        List<File> result = new ArrayList<>();

        for (String path : filePaths) {
            verifyFileExtension(path, configuration);

            File file = readFile(path);
            result.add(file);
        }

        return new FileHandler(result);
    }

    private void verifyFileExtension(String path, Configuration configuration) throws Exception {
        String expectedFileExtension = configuration.getLanguageFileExtension();

        boolean isCorrectExtension = path.endsWith(expectedFileExtension);

        if (!isCorrectExtension) {
            throw new Exception(String.format(
                    "Invalid file extension of file %s. Expected extension %s.",
                    path,
                    expectedFileExtension
            ));
        }
    }

    private File readFile(String path) throws IOException {
        List<String> lines = FilesystemUtility.readFile(path);
        return new File(path, lines);
    }
}
