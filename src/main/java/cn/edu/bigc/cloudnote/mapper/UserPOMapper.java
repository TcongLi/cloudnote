package cn.edu.bigc.cloudnote.mapper;

import cn.edu.bigc.cloudnote.model.UserPO;

import java.util.List;

public interface UserPOMapper extends BaseMapper<UserPO> {
    @Override
    UserPO select(Integer id);

    @Override
    List<UserPO> selectAll();

    @Override
    void insert(UserPO po);

    @Override
    void update(UserPO po);

    @Override
    void delete(Integer id);
}
