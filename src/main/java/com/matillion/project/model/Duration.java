
package com.matillion.project.model;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Duration {

    @SerializedName("text")
    private String mText;
    @SerializedName("value")
    private Long mValue;

    public String getText() {
        return mText;
    }

    public Long getValue() {
        return mValue;
    }

    public static class Builder {

        private String mText;
        private Long mValue;

        public Duration.Builder withText(String text) {
            mText = text;
            return this;
        }

        public Duration.Builder withValue(Long value) {
            mValue = value;
            return this;
        }

        public Duration build() {
            Duration Duration = new Duration();
            Duration.mText = mText;
            Duration.mValue = mValue;
            return Duration;
        }

    }

}
