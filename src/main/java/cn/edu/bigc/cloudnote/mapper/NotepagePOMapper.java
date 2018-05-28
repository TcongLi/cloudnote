package cn.edu.bigc.cloudnote.mapper;

import cn.edu.bigc.cloudnote.model.NotepagePO;

import java.util.List;

/**
 * Created by TiancongLi(tiancong.li@hotmail.com) on 2018/5/28.
 */
public interface NotepagePOMapper extends BaseMapper<NotepagePO> {
    @Override
    NotepagePO select(Integer id);

    @Override
    List<NotepagePO> selectAll();

    @Override
    void insert(NotepagePO po);

    @Override
    void update(NotepagePO po);

    @Override
    void delete(Integer id);
}
