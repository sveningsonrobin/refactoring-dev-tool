package org.robin.transformations;

public class TransformationRule {
    private String mFrom;
    private SectionTransformation[] mSectionTransformations;

    public TransformationRule(String from, SectionTransformation... sectionTransformations) {
        mFrom = from;
        mSectionTransformations = sectionTransformations;
    }

    public String getFrom() {
        return mFrom;
    }

    public SectionTransformation[] getSectionTransformations() {
        return mSectionTransformations;
    }
}
