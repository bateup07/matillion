
package com.matillion.project.model;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Distance {

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

        public Distance.Builder withText(String text) {
            mText = text;
            return this;
        }

        public Distance.Builder withValue(Long value) {
            mValue = value;
            return this;
        }

        public Distance build() {
            Distance Distance = new Distance();
            Distance.mText = mText;
            Distance.mValue = mValue;
            return Distance;
        }

    }

}
