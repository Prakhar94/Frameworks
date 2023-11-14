package com.product.api.applicationApi;

import com.product.api.RestResource;
import com.product.api.Route;
import io.qameta.allure.Step;
import io.restassured.response.Response;

public class UsersApi {

    @Step
    public static Response getUserDetails(){
        return RestResource.get(Route.USERS);
    }
}
