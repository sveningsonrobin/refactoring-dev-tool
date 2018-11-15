package org.robin.input;

import org.robin.models.File;

import java.util.List;

public class FileHandler {
    private List<File> mFiles;

    public FileHandler(List<File> files) {
        mFiles = files;
    }

    public List<File> getFiles() {
        return mFiles;
    }
}
