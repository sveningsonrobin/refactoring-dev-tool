package org.robin.transformations;

public class TransformationRuleDefinition {
    public static final TransformationRule[] TRANSFORMATIONS = new TransformationRule[] {
            new TransformationRule(
                    "class ([a-z])([a-zA-Z]*)",
                    SectionTransformation.byText("class "),
                    SectionTransformation.byMethod(GroupTransformationMethod.UPPERCASE),
                    SectionTransformation.byMethod(GroupTransformationMethod.NO_CHANGE)
            ),
            new TransformationRule(
                    "(int|String|double|boolean|char|long|float) ([A-Z])([a-zA-Z]*)",
                    SectionTransformation.byMethod(GroupTransformationMethod.NO_CHANGE),
                    SectionTransformation.byText(" "),
                    SectionTransformation.byMethod(GroupTransformationMethod.LOWERCASE),
                    SectionTransformation.byMethod(GroupTransformationMethod.NO_CHANGE)
            )
    };
}
