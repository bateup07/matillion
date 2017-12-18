
package com.matillion.project.model;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Map {

    @SerializedName("destination_addresses")
    private List<String> mDestinationAddresses;
    @SerializedName("origin_addresses")
    private List<String> mOriginAddresses;
    @SerializedName("rows")
    private List<Row> mRows;
    @SerializedName("status")
    private String mStatus;

    public List<String> getDestinationAddresses() {
        return mDestinationAddresses;
    }

    public List<String> getOriginAddresses() {
        return mOriginAddresses;
    }

    public List<Row> getRows() {
        return mRows;
    }

    public String getStatus() {
        return mStatus;
    }

    public static class Builder {

        private List<String> mDestinationAddresses;
        private List<String> mOriginAddresses;
        private List<Row> mRows;
        private String mStatus;

        public Map.Builder withDestinationAddresses(List<String> destinationAddresses) {
            mDestinationAddresses = destinationAddresses;
            return this;
        }

        public Map.Builder withOriginAddresses(List<String> originAddresses) {
            mOriginAddresses = originAddresses;
            return this;
        }

        public Map.Builder withRows(List<Row> rows) {
            mRows = rows;
            return this;
        }

        public Map.Builder withStatus(String status) {
            mStatus = status;
            return this;
        }

        public Map build() {
            Map Map = new Map();
            Map.mDestinationAddresses = mDestinationAddresses;
            Map.mOriginAddresses = mOriginAddresses;
            Map.mRows = mRows;
            Map.mStatus = mStatus;
            return Map;
        }

    }

}
