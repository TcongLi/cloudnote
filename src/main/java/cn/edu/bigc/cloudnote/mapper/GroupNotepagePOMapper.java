package cn.edu.bigc.cloudnote.mapper;

import cn.edu.bigc.cloudnote.model.GroupNotepagePO;

import java.util.List;

public interface GroupNotepagePOMapper extends BaseMapper<GroupNotepagePO> {
    @Override
    GroupNotepagePO select(Integer id);

    @Override
    List<GroupNotepagePO> selectAll();

    @Override
    void insert(GroupNotepagePO po);

    @Override
    void update(GroupNotepagePO po);

    @Override
    void delete(Integer id);
}
