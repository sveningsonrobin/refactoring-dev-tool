package org.robin.transformations;

public class TransformationRuleDefinition {
    public static final TransformationRule[] TRANSFORMATIONS = new TransformationRule[] {
            new TransformationRule(
                    "([\\s\\.])([A-Z])([a-zA-Z0-9_]*)\\(",
                    SectionTransformation.byMethod(GroupTransformationMethod.NO_CHANGE),
                    SectionTransformation.byMethod(GroupTransformationMethod.LOWERCASE),
                    SectionTransformation.byMethod(GroupTransformationMethod.NO_CHANGE),
                    SectionTransformation.byText("(")
            )
    };
}
