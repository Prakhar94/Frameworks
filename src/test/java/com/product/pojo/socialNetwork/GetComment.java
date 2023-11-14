
package com.product.pojo.socialNetwork;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Getter
@Builder
@Jacksonized
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class GetComment {

    @JsonProperty("postId")
    private final Integer postId;
    @JsonProperty("id")
    private final Integer id;
    @JsonProperty("name")
    private final String name;
    @JsonProperty("email")
    private final String email;
    @JsonProperty("body")
    private final String body;

    GetComment(Integer postId, Integer id, String name, String email, String body) {
        this.postId = postId;
        this.id = id;
        this.name = name;
        this.email = email;
        this.body = body;
    }

    public static GetCommentBuilder builder() {
        return new GetCommentBuilder();
    }

    public static class GetCommentBuilder {
        private Integer postId;
        private Integer id;
        private String name;
        private String email;
        private String body;

        GetCommentBuilder() {
        }

        public GetCommentBuilder postId(Integer postId) {
            this.postId = postId;
            return this;
        }

        public GetCommentBuilder id(Integer id) {
            this.id = id;
            return this;
        }

        public GetCommentBuilder name(String name) {
            this.name = name;
            return this;
        }

        public GetCommentBuilder email(String email) {
            this.email = email;
            return this;
        }

        public GetCommentBuilder body(String body) {
            this.body = body;
            return this;
        }

        public GetComment build() {
            return new GetComment(postId, id, name, email, body);
        }

        public String toString() {
            return "GetComment.GetCommentBuilder(postId=" + this.postId + ", id=" + this.id + ", name=" + this.name + ", email=" + this.email + ", body=" + this.body + ")";
        }
    }
}
