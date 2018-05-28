package cn.edu.bigc.cloudnote.mapper;

import java.util.List;

/**
 * Created by TiancongLi(tiancong.li@hotmail.com) on 2018/5/28.
 */
public interface BaseMapper<T> {
    T select(Integer id);

    List<T> selectAll();

    void insert(T po);

    void update(T po);

    void delete(Integer id);
}
