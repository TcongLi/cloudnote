package cn.edu.bigc.cloudnote.mapper;

import cn.edu.bigc.cloudnote.model.UserPO;

import java.util.List;

/**
 * Created by TiancongLi(tiancong.li@hotmail.com) on 2018/5/28.
 */
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
