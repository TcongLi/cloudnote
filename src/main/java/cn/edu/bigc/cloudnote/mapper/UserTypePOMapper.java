package cn.edu.bigc.cloudnote.mapper;

import cn.edu.bigc.cloudnote.model.UserTypePO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by TiancongLi(tiancong.li@hotmail.com) on 2018/5/28.
 */
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
