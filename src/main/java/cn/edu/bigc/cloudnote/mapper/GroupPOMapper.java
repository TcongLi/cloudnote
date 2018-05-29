package cn.edu.bigc.cloudnote.mapper;

import cn.edu.bigc.cloudnote.model.GroupPO;

import java.util.List;

/**
 * Created by TiancongLi(tiancong.li@hotmail.com) on 2018/5/28.
 */
public interface GroupPOMapper extends BaseMapper<GroupPO> {
    @Override
    GroupPO select(Integer id);

    @Override
    List<GroupPO> selectAll();

    @Override
    void insert(GroupPO po);

    @Override
    void update(GroupPO po);

    @Override
    void delete(Integer id);
}
