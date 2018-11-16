package org.robin.output.implementations;

import org.robin.input.FileHandler;
import org.robin.models.File;
import org.robin.output.ModelWriter;
import org.robin.utilities.ConsoleUtility;
import org.robin.utilities.FileUtility;
import org.robin.utilities.FilesystemUtility;

import java.io.IOException;
import java.util.List;

public class FilesystemModelWriter implements ModelWriter {
    private static final String OUTPUT_FORMAT = "---------------- PREVIEW FILE ----------------\nPath: %s\n\n%s\n\n--------------------------------------\n";

    @Override
    public void writeFiles(FileHandler fileHandler) throws IOException {
        List<File> allFiles = fileHandler.getFiles();

        for (File file : allFiles) {
            writeSingleFile(file);
        }
    }

    private void writeSingleFile(File file) throws IOException {
        String fileContent = FileUtility.getNewLineSeparatedLines(file);
        String output = String.format(OUTPUT_FORMAT, file.getPath(), fileContent);

        System.out.println(output);
        boolean isYesAnswer = ConsoleUtility.readQuestionResponse(String.format(
                "Do you want to save the file? Type \"yes\" to save. Will overwrite content of \"%s\".",
                file.getPath()
        ));

        if (isYesAnswer) {
            System.out.println("Saving file...");
            FilesystemUtility.saveFile(file.getPath(), fileContent);
            System.out.println("File saved.");
        } else {
            System.out.println("Not saving file.");
        }
    }
}
