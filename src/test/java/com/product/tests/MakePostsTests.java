package com.product.tests;

import com.product.api.StatusCode;
import com.product.api.applicationApi.PostsApi;
import com.product.pojo.socialNetwork.Post;
import com.product.utils.DataLoader;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@Epic("Social Network v0")
@Feature("Social Network APIs")
public class MakePostsTests extends BaseTest {

    @Story("Able to make posts")
    @Issue("12345678")
    @Description("This is the test description")
    @Test(description = "should be able to make posts on this social network platform")
    public void ShouldBeAbleToMakePosts(){
        Post requestPost = PostBuilder(1, 101, DataLoader.getInstance().makePostTitle(), DataLoader.getInstance().makePostBody());
        Response response = PostsApi.makePost(requestPost);
        assertStatusCode(response.statusCode(), StatusCode.CODE_201);
        //response POJO validation
        assertPostEqual(response.as(Post.class), requestPost);
    }

    @Step
    public Post PostBuilder(Integer id, Integer userId, String postTitle, String postBody){
        return Post.builder().
                userId(id).
                id(userId).
                title(postTitle).
                body(postBody).build();
    }

    @Step
    public void assertPostEqual(Post responsePost, Post requestPost){
        assertThat(responsePost.getId(), equalTo(requestPost.getId()));
        assertThat(responsePost.getUserId(), equalTo(requestPost.getUserId()));
        assertThat(responsePost.getTitle(), equalTo(requestPost.getTitle()));
        assertThat(responsePost.getBody(), equalTo(requestPost.getBody()));

    }

    //can be moved to some common class for better reusability. Keeping here for demo
    @Step
    public void assertStatusCode(int actualStatusCode, StatusCode statusCode){
        assertThat(actualStatusCode, equalTo(statusCode.code));
    }

}
