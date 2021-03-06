package xyz.softeng.shopping.users.user;

import lombok.Data;
import xyz.softeng.shopping.common.UserRole;

@Data
public class UserDto {
    private String username;

    private String password;

    private UserRole role;

    private Integer wealth;
}
