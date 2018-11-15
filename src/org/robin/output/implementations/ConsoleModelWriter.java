package org.robin.output.implementations;

import org.robin.input.FileHandler;
import org.robin.models.File;
import org.robin.output.ModelWriter;
import org.robin.utilities.FileUtility;

import java.util.List;

public class ConsoleModelWriter implements ModelWriter {
    private static final String OUTPUT_FORMAT = "---------------- FILE ----------------\nPath: %s\n\n%s\n\n--------------------------------------\n";

    @Override
    public void writeFiles(FileHandler fileHandler) {
        List<File> allFiles = fileHandler.getFiles();

        for (File file : allFiles) {
            writeSingleFile(file);
        }
    }

    private void writeSingleFile(File file) {
        String fileContent = FileUtility.getNewLineSeparatedLines(file);
        String output = String.format(OUTPUT_FORMAT, file.getPath(), fileContent);

        System.out.println(output);
    }
}
