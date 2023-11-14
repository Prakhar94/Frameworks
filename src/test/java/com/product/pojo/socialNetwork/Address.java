
package com.product.pojo.socialNetwork;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Jacksonized
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class Address {

    @JsonProperty("street")
    private final String street;
    @JsonProperty("suite")
    private final String suite;
    @JsonProperty("city")
    private final String city;
    @JsonProperty("zipcode")
    private final String zipcode;
    @JsonProperty("geo")
    private final Geo geo;

    Address(String street, String suite, String city, String zipcode, Geo geo) {
        this.street = street;
        this.suite = suite;
        this.city = city;
        this.zipcode = zipcode;
        this.geo = geo;
    }

    public static AddressBuilder builder() {
        return new AddressBuilder();
    }

    public static class AddressBuilder {
        private String street;
        private String suite;
        private String city;
        private String zipcode;
        private Geo geo;

        AddressBuilder() {
        }

        public AddressBuilder street(String street) {
            this.street = street;
            return this;
        }

        public AddressBuilder suite(String suite) {
            this.suite = suite;
            return this;
        }

        public AddressBuilder city(String city) {
            this.city = city;
            return this;
        }

        public AddressBuilder zipcode(String zipcode) {
            this.zipcode = zipcode;
            return this;
        }

        public AddressBuilder geo(Geo geo) {
            this.geo = geo;
            return this;
        }

        public Address build() {
            return new Address(street, suite, city, zipcode, geo);
        }

        public String toString() {
            return "Address.AddressBuilder(street=" + this.street + ", suite=" + this.suite + ", city=" + this.city + ", zipcode=" + this.zipcode + ", geo=" + this.geo + ")";
        }
    }
}
