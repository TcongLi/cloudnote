package cn.edu.bigc.cloudnote.mapper;

import cn.edu.bigc.cloudnote.model.UserTypePO;

import java.util.List;

public interface UserTypePOMapper extends BaseMapper<UserTypePO> {
    @Override
    UserTypePO select(Integer id);

    @Override
    List<UserTypePO> selectAll();

    @Override
    void insert(UserTypePO po);

    @Override
    void update(UserTypePO po);

    @Override
    void delete(Integer id);
}
