package cn.edu.bigc.cloudnote.service;

import cn.edu.bigc.cloudnote.model.GroupPO;
import cn.edu.bigc.cloudnote.model.UserPO;

import java.util.List;

/**
 * Created by TiancongLi(tiancong.li@hotmail.com) on 2018/5/29.
 */
public interface GroupService {
    /**
     * 查找组详细信息
     * @param groupId 组 id
     * @return 小组实体
     */
    GroupPO getGroup(Integer groupId);

    /**
     * 查找小组所有成员
     * @param groupId 组 id
     * @return 用户列表
     */
    List<UserPO> getAllGroupMembers(Integer groupId);

    /**
     * 查找该用户所在的所有小组
     * @param userId 用户 id
     * @return 组实体列表
     */
    List<GroupPO> getAllGroupsJoined(Integer userId);

    /**
     * 查找该用户创建的所有小组
     * @param userId 用户 id
     * @return 组实体列表
     */
    List<GroupPO> getAllGroupsCreated(Integer userId);

    /**
     * 创建一个小组
     * @param po 组实体
     * @return 生成的组实体的主键
     */
    Integer createGroup(GroupPO po);

    /**
     * 加入一个小组
     * @param userId 用户 id
     * @param groupId 组 id
     */
    void joinGroup(Integer userId, Integer groupId);

    /**
     * 解散小组(只有创建者可以解散)
     * @param userId 创建者 id
     * @param groupId 组 id
     */
    void dissmissGroup(Integer userId, Integer groupId);

    /**
     * 退出小组
     * @param userId 用户 id
     * @param groupId 组 id
     */
    void exitGroup(Integer userId, Integer groupId);


    /**
     * 共享笔记页到小组
     * @param userId 共享人 id
     * @param notepageId 要共享的笔记页 id
     * @param groupId 共享到小组的 id
     */
    void shareNotepage(Integer userId, Integer notepageId, Integer groupId);

    /**
     * 撤回共享笔记
     * @param userId 撤回人 id
     * @param notepageId 笔记页 id
     * @param groupId 小组 id
     */
    void revokeNotepage(Integer userId, Integer notepageId, Integer groupId);
}
