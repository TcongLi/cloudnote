package cn.edu.bigc.cloudnote.service;

import cn.edu.bigc.cloudnote.model.NotepagePO;

import java.util.List;

public interface NotepageService {
    /**
     * 查找该笔记本的所有笔记页
     * @param notebookId 该笔记本 id
     * @return 笔记页实体类
     */
    List<NotepagePO> getAllNotepages(Integer notebookId);

    /**
     * 插入一个笔记页
     * @param po 笔记页实体
     * @return 生成的笔记页主键
     */
    Integer createNotepage(NotepagePO po);

    /**
     * 更新一个笔记页
     * @param po 笔记页实体
     */
    void updateNotepage(NotepagePO po);

    /**
     * 删除一个笔记页面到废纸篓
     * @param notepageId 要删除的笔记页 id
     */
    void deleteNotepage(Integer notepageId);

    /**
     * 恢复一个笔记页
     * @param notepageId 要恢复的笔记页 id
     */
    void recoverNotepage(Integer notepageId);
}
