package org.robin.models;

import java.util.List;

public class File {
    private String mPath;
    private List<String> mLines;

    public File(String path, List<String> lines) {
        mPath = path;
        mLines = lines;
    }

    public String getPath() {
        return mPath;
    }

    public void setPath(String path) {
        mPath = path;
    }

    public List<String> getLines() {
        return mLines;
    }

    public void setLines(List<String> lines) {
        mLines = lines;
    }
}
