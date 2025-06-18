package pojo.requests;

import lombok.Data;

@Data
public class CreateUserRequest {
    private int id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private int userStatus;
}
