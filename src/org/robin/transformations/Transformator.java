package org.robin.transformations;

import org.robin.input.FileHandler;
import org.robin.models.File;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Transformator {
    public void transform(FileHandler fileHandler) {
        List<File> files = fileHandler.getFiles();

        for (File file : files) {
            transformFile(file);
        }
    }

    private void transformFile(File file) {
        List<String> lines = file.getLines();

        for (int i = 0; i < lines.size(); i++) {
            String oldLine = lines.get(i);
            String newLine = transformLine(oldLine);

            lines.set(i, newLine);
        }
    }

    private String transformLine(String line) {
        for (TransformationRule rule : TransformationRuleDefinition.TRANSFORMATIONS) {
            String fromRegex = rule.getFrom();
            String toRegex = rule.getTo();

            Pattern pattern = Pattern.compile(fromRegex);
            Matcher matcher = pattern.matcher(line);

            line = matcher.replaceAll(toRegex);
        }

        return line;
    }
}
