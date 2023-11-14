package com.product.api.applicationApi;

import com.product.api.RestResource;
import com.product.api.Route;
import com.product.pojo.socialNetwork.Post;
import io.qameta.allure.Step;
import io.restassured.response.Response;

public class PostsApi {

    @Step
    public static Response makePost(Post post){
        return RestResource.post(Route.POSTS, post);
    }
}
