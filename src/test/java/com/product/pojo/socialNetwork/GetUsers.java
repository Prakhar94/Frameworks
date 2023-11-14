
package com.product.pojo.socialNetwork;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Jacksonized
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class GetUsers {

    @JsonProperty("id")
    private final Integer id;
    @JsonProperty("name")
    private final String name;
    @JsonProperty("username")
    private final String username;
    @JsonProperty("email")
    private final String email;
    @JsonProperty("address")
    private final Address address;
    @JsonProperty("phone")
    private final String phone;
    @JsonProperty("website")
    private final String website;
    @JsonProperty("company")
    private final Company company;

    GetUsers(Integer id, String name, String username, String email, Address address, String phone, String website, Company company) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.website = website;
        this.company = company;
    }

    public static GetUsersBuilder builder() {
        return new GetUsersBuilder();
    }

    public static class GetUsersBuilder {
        private Integer id;
        private String name;
        private String username;
        private String email;
        private Address address;
        private String phone;
        private String website;
        private Company company;

        GetUsersBuilder() {
        }

        public GetUsersBuilder id(Integer id) {
            this.id = id;
            return this;
        }

        public GetUsersBuilder name(String name) {
            this.name = name;
            return this;
        }

        public GetUsersBuilder username(String username) {
            this.username = username;
            return this;
        }

        public GetUsersBuilder email(String email) {
            this.email = email;
            return this;
        }

        public GetUsersBuilder address(Address address) {
            this.address = address;
            return this;
        }

        public GetUsersBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public GetUsersBuilder website(String website) {
            this.website = website;
            return this;
        }

        public GetUsersBuilder company(Company company) {
            this.company = company;
            return this;
        }

        public GetUsers build() {
            return new GetUsers(id, name, username, email, address, phone, website, company);
        }

        public String toString() {
            return "GetUsers.GetUsersBuilder(id=" + this.id + ", name=" + this.name + ", username=" + this.username + ", email=" + this.email + ", address=" + this.address + ", phone=" + this.phone + ", website=" + this.website + ", company=" + this.company + ")";
        }
    }
}
