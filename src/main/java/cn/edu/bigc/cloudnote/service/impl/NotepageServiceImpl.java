package cn.edu.bigc.cloudnote.service.impl;

import cn.edu.bigc.cloudnote.mapper.NotepagePOMapper;
import cn.edu.bigc.cloudnote.model.NotepagePO;
import cn.edu.bigc.cloudnote.service.NotepageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by TiancongLi(tiancong.li@hotmail.com) on 2018/5/29.
 */
@Service
@Slf4j
public class NotepageServiceImpl implements NotepageService {
    @Autowired
    private NotepagePOMapper mapper;

    @Override
    public List<NotepagePO> getAllNotepages(Integer notebookId) {
        return mapper.selectAll().stream().filter(it -> it.getNotebookId().equals(notebookId)).collect(Collectors.toList());
    }

    @Override
    public Integer createNotepage(NotepagePO po) {
        mapper.insert(po);
        log.info("向笔记本 {} 中添加笔记页", po.getNotebookId());
        return po.getNotepageId();
    }

    @Override
    public void updateNotepage(NotepagePO po) {
        po.setUpdatedAt(Instant.now());
        log.info("更新笔记页 {}", po.getNotepageId());
        mapper.update(po);
    }

    @Override
    public void deleteNotepage(Integer notepageId) {
        NotepagePO notepage = new NotepagePO();
        notepage.setNotepageId(notepageId);
        notepage.setUpdatedAt(Instant.now());
        notepage.setDeleted(true);
        log.info("删除笔记页 {}", notepageId);
        mapper.update(notepage);
    }

    @Override
    public void recoverNotepage(Integer notepageId) {
        NotepagePO notepage = new NotepagePO();
        notepage.setNotepageId(notepageId);
        notepage.setUpdatedAt(Instant.now());
        notepage.setDeleted(false);
        log.info("恢复笔记页 {}", notepageId);
        mapper.update(notepage);
    }
}
