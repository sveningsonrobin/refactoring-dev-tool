package org.robin.output;

import org.robin.input.FileHandler;

import java.io.IOException;

public interface ModelWriter {
    void writeFiles(FileHandler fileHandler) throws IOException;
}
