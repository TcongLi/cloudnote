package cn.edu.bigc.cloudnote.mapper;

import cn.edu.bigc.cloudnote.model.GroupMemberPO;

import java.util.List;

public interface GroupMemberPOMapper extends BaseMapper<GroupMemberPO> {
    @Override
    GroupMemberPO select(Integer id);

    @Override
    List<GroupMemberPO> selectAll();

    @Override
    void insert(GroupMemberPO po);

    @Override
    void update(GroupMemberPO po);

    @Override
    void delete(Integer id);
}
