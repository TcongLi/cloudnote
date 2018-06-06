package cn.edu.bigc.cloudnote.mapper;

import cn.edu.bigc.cloudnote.model.NotebookPO;

import java.util.List;

public interface NotebookPOMapper extends BaseMapper<NotebookPO> {
    @Override
    NotebookPO select(Integer id);

    @Override
    List<NotebookPO> selectAll();

    @Override
    void insert(NotebookPO po);

    @Override
    void update(NotebookPO po);

    @Override
    void delete(Integer id);
}
