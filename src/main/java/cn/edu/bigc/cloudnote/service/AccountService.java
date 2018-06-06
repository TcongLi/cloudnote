package cn.edu.bigc.cloudnote.service;

import cn.edu.bigc.cloudnote.model.UserPO;
import cn.edu.bigc.cloudnote.model.UserTypePO;

import java.util.List;

public interface AccountService {
    /**
     * 登陆
     * @return 成功返回用户实体类, 失败返回 null
     */
    UserPO signIn(String username, String password);

    /**
     * 注册
     * @param po 用户实体类
     * @return 成功返回生成的主键, 失败返回 null
     */
    Integer signUp(UserPO po);

    /**
     * 查找所有用户类型
     * @return 用户类型列表
     */
    List<UserTypePO> getAllUserTypes();

    /**
     * 用户升级或降级
     * @param userId 用户 id
     * @param typeId 目标用户类型 id
     */
    void promote(Integer userId, Integer typeId);
}
