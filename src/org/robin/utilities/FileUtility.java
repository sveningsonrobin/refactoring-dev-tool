package org.robin.utilities;

import org.robin.models.File;

import java.util.List;

public class FileUtility {
    private static final String LINE_SEPARATOR = "\n";

    public static String getNewLineSeparatedLines(File file) {
        StringBuilder result = new StringBuilder();
        List<String> lines = file.getLines();

        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            result.append(line);

            boolean shouldHaveSeparator = i < lines.size() - 1;

            if (shouldHaveSeparator) {
                result.append(LINE_SEPARATOR);
            }
        }

        return result.toString();
    }
}
