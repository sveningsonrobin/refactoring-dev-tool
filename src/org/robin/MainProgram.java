package org.robin;

import org.robin.configuration.Configuration;
import org.robin.configuration.implementations.JavaConfiguration;
import org.robin.input.FileHandler;
import org.robin.input.FilesystemModelReader;
import org.robin.output.ModelWriter;
import org.robin.output.implementations.FilesystemModelWriter;
import org.robin.transformations.Transformator;

public class MainProgram {
    public static void main(String[] args) {
        MainProgram mainProgram = new MainProgram();
        mainProgram.performRefactoring(new JavaConfiguration(), new FilesystemModelWriter(), args);
    }

    private void performRefactoring(Configuration configuration, ModelWriter writer, String[] filePaths) {
        try {
            FilesystemModelReader reader = new FilesystemModelReader();
            Transformator transformator = new Transformator();

            FileHandler fileHandler = reader.readFiles(configuration, filePaths);
            transformator.transform(fileHandler);
            writer.writeFiles(fileHandler);

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
