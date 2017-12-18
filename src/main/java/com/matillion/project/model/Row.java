
package com.matillion.project.model;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Row {

    @SerializedName("elements")
    private List<Element> mElements;

    public List<Element> getElements() {
        return mElements;
    }

    public static class Builder {

        private List<Element> mElements;

        public Row.Builder withElements(List<Element> elements) {
            mElements = elements;
            return this;
        }

        public Row build() {
            Row Row = new Row();
            Row.mElements = mElements;
            return Row;
        }

    }

}
