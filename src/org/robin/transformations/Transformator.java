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
            line = applyRegex(line, rule);
        }

        return line;
    }

    private String applyRegex(String line, TransformationRule rule) {
        Pattern pattern = Pattern.compile(rule.getFrom());
        Matcher matcher = pattern.matcher(line);

        boolean isFound = matcher.find();

        if (isFound) {
            String transformed = applySectionTransformation(matcher, rule.getSectionTransformations());
            String replaced = matcher.replaceFirst(transformed);

            return applyRegex(replaced, rule);
        } else {
            return line;
        }
    }

    private String applySectionTransformation(Matcher matcher, SectionTransformation[] sectionTransformations) {
        StringBuilder stringBuilder = new StringBuilder();

        int groupNumber = 1;

        for (SectionTransformation sectionTransformation : sectionTransformations) {
            boolean isText = sectionTransformation.isText();

            if (isText) {
                stringBuilder.append(sectionTransformation.getText());
            } else {
                String groupValue = matcher.group(groupNumber);
                GroupTransformationMethod method = sectionTransformation.getMethod();

                String transformedGroup = applyGroupTransformationMethod(groupValue, method);
                stringBuilder.append(transformedGroup);

                groupNumber += 1;
            }
        }

        return stringBuilder.toString();
    }

    private String applyGroupTransformationMethod(String groupValue, GroupTransformationMethod method) {
        switch (method) {
            case UPPERCASE:
                return groupValue.toUpperCase();
            case LOWERCASE:
                return groupValue.toLowerCase();
            case NO_CHANGE:
            default:
                return groupValue;
        }
    }
}
