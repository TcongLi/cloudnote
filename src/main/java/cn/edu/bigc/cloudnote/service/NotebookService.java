package cn.edu.bigc.cloudnote.service;

import cn.edu.bigc.cloudnote.model.NotebookPO;

import java.util.List;

public interface NotebookService{
    /**
     * 查看一个用户所有的笔记本, 不包含删除的
     * @param userId 用户主键
     * @return 该用户所有笔记本列表
     */
    List<NotebookPO> getAllNotebooks(Integer userId);

    /**
     * 查看一个用户所有已经删除的笔记本
     * @param userId 用户主键
     * @return 该用户所有已经删除的笔记本列表
     */
    List<NotebookPO> getAllDeletedBooks(Integer userId);

    /**
     * 添加笔记本
     * @param po 笔记本实体类, ownerId(笔记本属主)必填
     * @return 成功返回笔记本主键 id
     */
    Integer createNotebook(NotebookPO po);

    /**
     * 更新笔记本元信息
     * @param po 笔记本实体类, updatedAt 必填
     */
    void updateNotebook(NotebookPO po);

    /**
     * 删除笔记本到废纸篓
     * @param id 要删除的笔记本 id
     */
    void deleteNotebook(Integer id);

    /**
     * 恢复笔记本
     * @param id 要恢复的笔记本 id
     */
    void recoverNotebook(Integer id);
}
