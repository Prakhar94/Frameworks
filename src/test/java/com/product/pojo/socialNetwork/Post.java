
package com.product.pojo.socialNetwork;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Builder;
import lombok.Getter;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Getter
@Builder
@Jacksonized
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class Post {

    @JsonProperty("userId")
    private final Integer userId;
    @JsonProperty("id")
    private final Integer id;
    @JsonProperty("title")
    private final String title;
    @JsonProperty("body")
    private final String body;

    public Post(Integer userId, Integer id, String title, String body) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }


    public static PostBuilder builder() {
        return new PostBuilder();
    }

    public static class PostBuilder {
        private Integer userId;
        private Integer id;
        private String title;
        private String body;

        PostBuilder() {
        }

        public PostBuilder userId(Integer userId) {
            this.userId = userId;
            return this;
        }

        public PostBuilder id(Integer id) {
            this.id = id;
            return this;
        }

        public PostBuilder title(String title) {
            this.title = title;
            return this;
        }

        public PostBuilder body(String body) {
            this.body = body;
            return this;
        }

        public Post build() {
            return new Post(userId, id, title, body);
        }

        public String toString() {
            return "Post.PostBuilder(userId=" + this.userId + ", id=" + this.id + ", title=" + this.title + ", body=" + this.body + ")";
        }
    }
}