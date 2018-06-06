package cn.edu.bigc.cloudnote.controller;

import cn.edu.bigc.cloudnote.model.NotepagePO;
import cn.edu.bigc.cloudnote.service.GroupService;
import cn.edu.bigc.cloudnote.service.NotebookService;
import cn.edu.bigc.cloudnote.service.NotepageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notepages")
public class NotepageController {
    @Autowired
    private NotebookService notebookService;

    @Autowired
    private NotepageService notepageService;

    @Autowired
    private GroupService groupService;

    @GetMapping("/notebooks/{notebookId}")
    public List<NotepagePO> getNotepagesFrombyNotebookId(@PathVariable Integer notebookId) {
        return notepageService.getAllNotepages(notebookId);
    }

    @GetMapping("/groups/{groupId}")
    public List<NotepagePO> getAllNotepagesByGroup(@PathVariable Integer groupId) {
        return groupService.getAllNotepages(groupId);
    }

    @PostMapping("/notebooks/{notebookId}")
    public Integer createNotepage(@PathVariable Integer notebookId, @RequestBody NotepagePO po) {
        if (po.getNotebookId() == null) {
            po.setNotebookId(notebookId);
        }
        return notepageService.createNotepage(po);
    }

    @PutMapping("/{notepageId}")
    public void updateNotepage(@PathVariable Integer notepageId, @RequestBody NotepagePO po) {
        if (po.getNotepageId() == null) {
            po.setNotepageId(notepageId);
        }
        notepageService.updateNotepage(po);
    }

    @DeleteMapping("/{notepageId}")
    public void deleteNotepage(@PathVariable Integer notepageId) {
        notepageService.deleteNotepage(notepageId);
    }

    @PutMapping("/recover/{notepageId}")
    public void recoverNotepage(@PathVariable Integer notepageId) {
        notepageService.recoverNotepage(notepageId);
    }
}
