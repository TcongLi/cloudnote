package cn.edu.bigc.cloudnote.mapper;

import cn.edu.bigc.cloudnote.model.NotebookPO;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by TiancongLi(tiancong.li@hotmail.com) on 2018/5/28.
 */
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
