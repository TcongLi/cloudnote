package cn.edu.bigc.cloudnote.service.impl;

import cn.edu.bigc.cloudnote.mapper.NotebookPOMapper;
import cn.edu.bigc.cloudnote.model.NotebookPO;
import cn.edu.bigc.cloudnote.service.NotebookService;
import lombok.experimental.var;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by TiancongLi(tiancong.li@hotmail.com) on 2018/5/29.
 */
@Service @Slf4j
public class NotebookServiceImpl implements NotebookService {
    @Autowired
    private NotebookPOMapper mapper;

    @Override
    public List<NotebookPO> getAllNotebooks(Integer userId) {
        var bookList = mapper.selectAll();
        return bookList.stream().filter(it -> it.getOwnerId().equals(userId)).collect(Collectors.toList());
    }

    @Override
    public List<NotebookPO> getAllDeletedBooks(Integer userId) {
        var bookList = mapper.selectAll();
        return bookList.stream().filter(it -> it.getOwnerId().equals(userId) && it.getDeleted()).collect(Collectors.toList());
    }

    @Override
    public Integer createNotebook(NotebookPO po) {
        mapper.insert(po);
        log.info("创建笔记本 {}", po);
        return po.getNotebookId();
    }

    @Override
    public void updateNotebook(NotebookPO po) {
        po.setUpdatedAt(Instant.now());
        log.info("更新笔记本 {}", po.getNotebookId());
        mapper.update(po);
    }

    @Override
    public void deleteNotebook(Integer id) {
        NotebookPO notebook = new NotebookPO();
        notebook.setNotebookId(id);
        notebook.setDeleted(true);
        log.info("删除笔记本 {}", id);
        mapper.update(notebook);
    }

    @Override
    public void recoverNotebook(Integer id) {
        NotebookPO notebook = new NotebookPO();
        notebook.setNotebookId(id);
        notebook.setDeleted(false);
        log.info("恢复笔记本 {}", id);
        mapper.update(notebook);
    }
}
