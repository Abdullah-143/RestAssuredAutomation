package tests;
import base.TestBase;
import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pojo.requests.CreateUserRequest;
import pojo.responses.CreateUserResponse;
import services.UserServices;
import utils.AssertUtils;
import utils.JsonUtils;
import java.util.List;

import static utils.ExtentReportManager.getTest;
import static utils.FilePath.CREATE_USER_FILE_PATH;

public class UserTest extends TestBase {
    AssertUtils assertUtils;
    UserServices userServices = new UserServices();

    @DataProvider(name = "userData")
    public Object[][] userData() {
        List<CreateUserRequest> users = JsonUtils.readJsonAsList(CREATE_USER_FILE_PATH, CreateUserRequest.class);
        return users.stream().map(u -> new Object[]{u}).toArray(Object[][]::new);
    }

    @Test(dataProvider = "userData")
    public void testCreateUser(CreateUserRequest createUserRequest){
        assertUtils = new AssertUtils(getTest());
        Response response = userServices.createUser(createUserRequest);
        assertUtils.assertEquals(response.getStatusCode(), 200,
                "Validate Status code");

        CreateUserResponse createUserResponse = response.as(CreateUserResponse.class);

        assertUtils.assertEquals(createUserRequest.getId(), createUserResponse.getId(),
                "Validate Id");
        assertUtils.assertEquals(createUserRequest.getUsername(), createUserResponse.getUsername(),
                "Validate Username");
        assertUtils.assertEquals(createUserRequest.getFirstName(), createUserResponse.getFirstName(),
                "Validate Firstname");
        assertUtils.assertEquals(createUserRequest.getLastName(), createUserResponse.getLastName(),
                "Validate Lastname");
        assertUtils.assertEquals(createUserRequest.getEmail(), createUserResponse.getEmail(),
                "Validate Email");
        assertUtils.assertEquals(createUserRequest.getPassword(), createUserResponse.getPassword(),
                "Validate Password");
        assertUtils.assertEquals(createUserRequest.getPhone(), createUserResponse.getPhone(),
                "Validate Phone Number");
        assertUtils.assertEquals(createUserRequest.getUserStatus(), createUserResponse.getUserStatus(),
                "Validate User status");
    }

    @Test
    public void testUpdateUser(){
        assertUtils = new AssertUtils(getTest());
        CreateUserRequest createUserRequest = JsonUtils.readJsonAsList(CREATE_USER_FILE_PATH, CreateUserRequest.class).get(0);
        Response response = userServices.createUser(createUserRequest);
        String username = response.jsonPath().getString("username");
        createUserRequest.setEmail("abdullah@gmail.com");
        response = userServices.updateUser(username, createUserRequest);

        assertUtils.assertEquals(response.getStatusCode(), 200,
                "Validate Status code");

        CreateUserResponse createUserResponse = response.as(CreateUserResponse.class);

        assertUtils.assertEquals(createUserRequest.getId(), createUserResponse.getId(),
                "Validate Id");
        assertUtils.assertEquals(createUserRequest.getUsername(), createUserResponse.getUsername(),
                "Validate Username");
        assertUtils.assertEquals(createUserRequest.getFirstName(), createUserResponse.getFirstName(),
                "Validate Firstname");
        assertUtils.assertEquals(createUserRequest.getLastName(), createUserResponse.getLastName(),
                "Validate Lastname");
        assertUtils.assertEquals(createUserRequest.getEmail(), createUserResponse.getEmail(),
                "Validate Email");
        assertUtils.assertEquals(createUserRequest.getPassword(), createUserResponse.getPassword(),
                "Validate Password");
        assertUtils.assertEquals(createUserRequest.getPhone(), createUserResponse.getPhone(),
                "Validate Phone Number");
        assertUtils.assertEquals(createUserRequest.getUserStatus(), createUserResponse.getUserStatus(),
                "Validate User status");
    }

    @Test
    public void testGetUser(){
        assertUtils = new AssertUtils(getTest());
        CreateUserRequest createUserRequest = JsonUtils.readJsonAsList(CREATE_USER_FILE_PATH, CreateUserRequest.class).get(0);
        Response response = userServices.createUser(createUserRequest);
        String username = response.jsonPath().getString("username");

        response = userServices.getUserByUsername(username);

        assertUtils.assertEquals(response.getStatusCode(), 200,
                "Validate Status code");

        CreateUserResponse createUserResponse = response.as(CreateUserResponse.class);

        assertUtils.assertEquals(createUserRequest.getId(), createUserResponse.getId(),
                "Validate Id");
        assertUtils.assertEquals(createUserRequest.getUsername(), createUserResponse.getUsername(),
                "Validate Username");
        assertUtils.assertEquals(createUserRequest.getFirstName(), createUserResponse.getFirstName(),
                "Validate Firstname");
        assertUtils.assertEquals(createUserRequest.getLastName(), createUserResponse.getLastName(),
                "Validate Lastname");
        assertUtils.assertEquals(createUserRequest.getEmail(), createUserResponse.getEmail(),
                "Validate Email");
        assertUtils.assertEquals(createUserRequest.getPassword(), createUserResponse.getPassword(),
                "Validate Password");
        assertUtils.assertEquals(createUserRequest.getPhone(), createUserResponse.getPhone(),
                "Validate Phone Number");
        assertUtils.assertEquals(createUserRequest.getUserStatus(), createUserResponse.getUserStatus(),
                "Validate User status");
    }

    @Test
    public void testDeleteUser() {
        assertUtils = new AssertUtils(getTest());
        CreateUserRequest createUserRequest = JsonUtils.readJsonAsList(CREATE_USER_FILE_PATH, CreateUserRequest.class).get(0);
        Response response = userServices.createUser(createUserRequest);
        String username = response.jsonPath().getString("username");

        response = userServices.deleteUserByUsername(username);

        assertUtils.assertEquals(response.getStatusCode(), 200,
                "Validate Status code");
    }

}
