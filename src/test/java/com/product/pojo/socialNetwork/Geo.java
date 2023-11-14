
package com.product.pojo.socialNetwork;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Jacksonized
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class Geo {

    @JsonProperty("lat")
    private final String lat;
    @JsonProperty("lng")
    private final String lng;

    Geo(String lat, String lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public static GeoBuilder builder() {
        return new GeoBuilder();
    }

    public static class GeoBuilder {
        private String lat;
        private String lng;

        GeoBuilder() {
        }

        public GeoBuilder lat(String lat) {
            this.lat = lat;
            return this;
        }

        public GeoBuilder lng(String lng) {
            this.lng = lng;
            return this;
        }

        public Geo build() {
            return new Geo(lat, lng);
        }

        public String toString() {
            return "Geo.GeoBuilder(lat=" + this.lat + ", lng=" + this.lng + ")";
        }
    }
}
