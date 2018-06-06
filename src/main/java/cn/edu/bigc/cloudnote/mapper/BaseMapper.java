package cn.edu.bigc.cloudnote.mapper;

import java.util.List;

public interface BaseMapper<T> {
    T select(Integer id);

    List<T> selectAll();

    void insert(T po);

    void update(T po);

    void delete(Integer id);
}
