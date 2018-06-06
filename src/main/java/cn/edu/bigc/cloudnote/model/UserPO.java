package cn.edu.bigc.cloudnote.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class UserPO {
    private Integer userId;

    private String userName;

    private String userPassword;

    private Integer userTypeId;
}
