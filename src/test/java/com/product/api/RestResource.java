package com.product.api;

import io.restassured.response.Response;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class RestResource {

    public static Response post(String path, Object request){
        return given(SpecBuilder.getRequestSpec()).
                body(request).
        when().post(path).
        then().spec(SpecBuilder.getResponseSpec()).
                extract().
                response();
    }

    public static Response post(String path, String token, Object request){
        return given(SpecBuilder.getRequestSpec()).
                body(request).
                auth().oauth2(token).
                when().post(path).
                then().spec(SpecBuilder.getResponseSpec()).
                extract().
                response();
    }

    public static Response get(String path, String token){
        return given(SpecBuilder.getRequestSpec()).
                auth().oauth2(token).
        when().get(path).
        then().spec(SpecBuilder.getResponseSpec()).
                extract().
                response();
    }

    public static Response get(String path){
        return given(SpecBuilder.getRequestSpec()).
                when().get(path).
                then().spec(SpecBuilder.getResponseSpec()).
                extract().
                response();
    }

    public static Response getWithSingleParam(String path, String queryParam, Integer value){
        return given(SpecBuilder.getRequestSpec()).
                params(queryParam, value).
                when().get(path).
                then().spec(SpecBuilder.getResponseSpec()).
                extract().
                response();
    }

    public static Response update(String path, String token, Object request){
        return given(SpecBuilder.getRequestSpec()).
                auth().oauth2(token).
                body(request).
        when().put(path).
        then().spec(SpecBuilder.getResponseSpec()).
                extract().
                response();
    }

    public static Response update(String path, Object request){
        return given(SpecBuilder.getRequestSpec()).
                body(request).
                when().put(path).
                then().spec(SpecBuilder.getResponseSpec()).
                extract().
                response();
    }
}
