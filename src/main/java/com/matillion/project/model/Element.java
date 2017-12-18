
package com.matillion.project.model;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Element {

    @SerializedName("distance")
    private Distance mDistance;
    @SerializedName("duration")
    private Duration mDuration;
    @SerializedName("status")
    private String mStatus;

    public Distance getDistance() {
        return mDistance;
    }

    public Duration getDuration() {
        return mDuration;
    }

    public String getStatus() {
        return mStatus;
    }

    public static class Builder {

        private Distance mDistance;
        private Duration mDuration;
        private String mStatus;

        public Element.Builder withDistance(Distance distance) {
            mDistance = distance;
            return this;
        }

        public Element.Builder withDuration(Duration duration) {
            mDuration = duration;
            return this;
        }

        public Element.Builder withStatus(String status) {
            mStatus = status;
            return this;
        }

        public Element build() {
            Element Element = new Element();
            Element.mDistance = mDistance;
            Element.mDuration = mDuration;
            Element.mStatus = mStatus;
            return Element;
        }

    }

}
