package org.robin.configuration.implementations;

import org.robin.configuration.Configuration;

public class JavaConfiguration implements Configuration {
    @Override
    public String getLanguageFileExtension() {
        return ".java";
    }
}
