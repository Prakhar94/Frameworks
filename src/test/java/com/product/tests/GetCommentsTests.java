package com.product.tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.product.api.StatusCode;
import com.product.api.applicationApi.CommentsApi;
import com.product.api.applicationApi.UsersApi;
import com.product.pojo.playlist.Error;
import com.product.pojo.socialNetwork.GetComment;
import com.product.pojo.socialNetwork.Post;
import com.product.utils.DataLoader;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@Epic("Social Network v0")
@Feature("Social Network APIs")
public class GetCommentsTests extends BaseTest {

    @Story("Get all the available comments for a user")
    @Issue("1234567")
    @Description("This is the test description")
    @Test(description = "should be able to get all the available comments for a userId on this social network platform")
    public void ShouldBeAbleToGetAllCommentsAvailable(){
        Response response = CommentsApi.getComments("id", 1);
        assertStatusCode(response.statusCode(), StatusCode.CODE_200);
        //response POJO validation
        assertThat(response.path("[0].id").toString(), equalTo("1"));
        assertThat(response.path("[0].name").toString(), equalTo(DataLoader.getInstance().getCommentTitle()));
        assertThat(response.path("[0].body").toString(), equalTo(DataLoader.getInstance().getCommentBody()));
    }

    //can be moved to some common class for better reusability. Keeping here for demo
    @Step
    public void assertStatusCode(int actualStatusCode, StatusCode statusCode){
        assertThat(actualStatusCode, equalTo(statusCode.code));
    }

    //can be moved to some common class for better reusability. Keeping here for demo
    @Step
    public void assertError(Error responseErr, StatusCode statusCode){
        assertThat(responseErr.getError().getStatus(), equalTo(statusCode.code));
        assertThat(responseErr.getError().getMessage(), equalTo(statusCode.msg));
    }
}
