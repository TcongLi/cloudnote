package cn.edu.bigc.cloudnote.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by TiancongLi(tiancong.li@hotmail.com) on 2018/5/28.
 */
@Data @NoArgsConstructor @AllArgsConstructor
public class UserPO {
    private Integer userId;

    private String userName;

    private String userPassword;

    private Integer userTypeId;
}
