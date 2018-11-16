package org.robin.transformations;

public class SectionTransformation {
    private String mText;
    private GroupTransformationMethod mMethod;

    public static SectionTransformation byText(String text) {
        return new SectionTransformation(text);
    }

    public static SectionTransformation byMethod(GroupTransformationMethod method) {
        return new SectionTransformation(method);
    }

    private SectionTransformation(String text) {
        mText = text;
    }

    private SectionTransformation(GroupTransformationMethod method) {
        mMethod = method;
    }

    public String getText() {
        return mText;
    }

    public GroupTransformationMethod getMethod() {
        return mMethod;
    }

    public boolean isText() {
        return mText != null;
    }
}
