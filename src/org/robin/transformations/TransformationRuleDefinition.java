package org.robin.transformations;

public class TransformationRuleDefinition {
    public static final TransformationRule[] TRANSFORMATIONS = new TransformationRule[] {
            new TransformationRule(
                    "(public|protected|private)([\\s])([a-zA-Z\\<\\>\\[\\]]+)([\\s])([A-Z])([a-zA-Z0-9_]+)\\(",
                    SectionTransformation.byMethod(GroupTransformationMethod.NO_CHANGE),
                    SectionTransformation.byMethod(GroupTransformationMethod.NO_CHANGE),
                    SectionTransformation.byMethod(GroupTransformationMethod.NO_CHANGE),
                    SectionTransformation.byMethod(GroupTransformationMethod.NO_CHANGE),
                    SectionTransformation.byMethod(GroupTransformationMethod.LOWERCASE),
                    SectionTransformation.byMethod(GroupTransformationMethod.NO_CHANGE),
                    SectionTransformation.byText("(")
            ),
            new TransformationRule(
                    "^(\\s+)([A-Z])([a-zA-Z0-9_]+)\\(",
                    SectionTransformation.byMethod(GroupTransformationMethod.NO_CHANGE),
                    SectionTransformation.byMethod(GroupTransformationMethod.LOWERCASE),
                    SectionTransformation.byMethod(GroupTransformationMethod.NO_CHANGE),
                    SectionTransformation.byText("(")
            ),
            new TransformationRule(
                    "^(\\s+[a-zA-Z0-9_]+\\.)([A-Z])([a-zA-Z0-9_]+)\\(",
                    SectionTransformation.byMethod(GroupTransformationMethod.NO_CHANGE),
                    SectionTransformation.byMethod(GroupTransformationMethod.LOWERCASE),
                    SectionTransformation.byMethod(GroupTransformationMethod.NO_CHANGE),
                    SectionTransformation.byText("(")
            ),
            new TransformationRule(
                    "^(\\s+)([a-zA-Z0-9_]+\\s+)([a-zA-Z0-9_]+)(\\s+)\\=(\\s+)([A-Z])([a-zA-Z0-9_]+)\\(",
                    SectionTransformation.byMethod(GroupTransformationMethod.NO_CHANGE),
                    SectionTransformation.byMethod(GroupTransformationMethod.NO_CHANGE),
                    SectionTransformation.byMethod(GroupTransformationMethod.NO_CHANGE),
                    SectionTransformation.byMethod(GroupTransformationMethod.NO_CHANGE),
                    SectionTransformation.byText("="),
                    SectionTransformation.byMethod(GroupTransformationMethod.NO_CHANGE),
                    SectionTransformation.byMethod(GroupTransformationMethod.LOWERCASE),
                    SectionTransformation.byMethod(GroupTransformationMethod.NO_CHANGE),
                    SectionTransformation.byText("(")
            ),
            new TransformationRule(
                    "^(\\s+)([a-zA-Z0-9_]+)(\\s+)\\=(\\s+)([A-Z])([a-zA-Z0-9_]+)\\(",
                    SectionTransformation.byMethod(GroupTransformationMethod.NO_CHANGE),
                    SectionTransformation.byMethod(GroupTransformationMethod.NO_CHANGE),
                    SectionTransformation.byMethod(GroupTransformationMethod.NO_CHANGE),
                    SectionTransformation.byText("="),
                    SectionTransformation.byMethod(GroupTransformationMethod.NO_CHANGE),
                    SectionTransformation.byMethod(GroupTransformationMethod.LOWERCASE),
                    SectionTransformation.byMethod(GroupTransformationMethod.NO_CHANGE),
                    SectionTransformation.byText("(")
            ),
            new TransformationRule(
                    "([a-zA-Z0-9]*)([_])([a-zA-Z])([A-Za-z0-9]*)\\(",
                    SectionTransformation.byMethod(GroupTransformationMethod.NO_CHANGE),
                    SectionTransformation.byMethod(GroupTransformationMethod.REMOVE_CHAR),
                    SectionTransformation.byMethod(GroupTransformationMethod.UPPERCASE),
                    SectionTransformation.byMethod(GroupTransformationMethod.NO_CHANGE),
                    SectionTransformation.byText("(")
            ),
    };
}
