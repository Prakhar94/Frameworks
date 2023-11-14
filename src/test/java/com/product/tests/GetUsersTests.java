package com.product.tests;

import com.product.api.StatusCode;
import com.product.api.applicationApi.UsersApi;
import com.product.pojo.playlist.Error;
import com.product.pojo.socialNetwork.GetUsers;
import com.product.utils.DataLoader;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static com.product.utils.DataLoader.*;

@Epic("Social Network v0")
@Feature("Social Network APIs")
public class GetUsersTests extends BaseTest {

    @Story("Get all the available users")
    @Issue("1234567")
    @Description("This is the test description")
    @Test(description = "should be able to get all the available users on this social network platform")
    public void ShouldBeAbleToGetAllUsersAvailable(){
        Response response = UsersApi.getUserDetails();
        assertStatusCode(response.statusCode(), StatusCode.CODE_200);
        //JSON path validation
        assertThat(response.path("[0].id").toString(), equalTo(DataLoader.getInstance().getGetUser01Id()));
        assertThat(response.path("[0].name").toString(), equalTo(DataLoader.getInstance().getGetUser01Name()));
        assertThat(response.path("[0].email").toString(), equalTo(DataLoader.getInstance().getGetUser01Email()));
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
