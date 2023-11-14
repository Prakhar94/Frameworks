package com.product.api.applicationApi;

import com.product.api.RestResource;
import com.product.api.Route;
import com.product.pojo.socialNetwork.Post;
import io.qameta.allure.Step;
import io.restassured.response.Response;

public class CommentsApi {

    @Step
    public static Response getComments( String queryParam, Integer value){
        return RestResource.getWithSingleParam(Route.COMMENTS, queryParam, value);
    }
}
