
package com.product.pojo.socialNetwork;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Jacksonized
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class Company {

    @JsonProperty("name")
    private final String name;
    @JsonProperty("catchPhrase")
    private final String catchPhrase;
    @JsonProperty("bs")
    private final String bs;

    Company(String name, String catchPhrase, String bs) {
        this.name = name;
        this.catchPhrase = catchPhrase;
        this.bs = bs;
    }

    public static CompanyBuilder builder() {
        return new CompanyBuilder();
    }

    public static class CompanyBuilder {
        private String name;
        private String catchPhrase;
        private String bs;

        CompanyBuilder() {
        }

        public CompanyBuilder name(String name) {
            this.name = name;
            return this;
        }

        public CompanyBuilder catchPhrase(String catchPhrase) {
            this.catchPhrase = catchPhrase;
            return this;
        }

        public CompanyBuilder bs(String bs) {
            this.bs = bs;
            return this;
        }

        public Company build() {
            return new Company(name, catchPhrase, bs);
        }

        public String toString() {
            return "Company.CompanyBuilder(name=" + this.name + ", catchPhrase=" + this.catchPhrase + ", bs=" + this.bs + ")";
        }
    }
}
