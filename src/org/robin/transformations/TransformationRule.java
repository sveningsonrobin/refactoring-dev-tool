package org.robin.transformations;

public class TransformationRule {
    private String mFrom;
    private String mTo;

    public TransformationRule(String from, String to) {
        mFrom = from;
        mTo = to;
    }

    public String getFrom() {
        return mFrom;
    }

    public void setFrom(String from) {
        mFrom = from;
    }

    public String getTo() {
        return mTo;
    }

    public void setTo(String to) {
        mTo = to;
    }
}
