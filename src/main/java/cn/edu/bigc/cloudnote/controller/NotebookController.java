package cn.edu.bigc.cloudnote.controller;

import cn.edu.bigc.cloudnote.model.NotebookPO;
import cn.edu.bigc.cloudnote.service.NotebookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notebooks")
public class NotebookController {
    @Autowired
    private NotebookService notebookService;

    @GetMapping("/{userId}")
    public List<NotebookPO> getAllNotebooks(@PathVariable Integer userId) {
        return notebookService.getAllNotebooks(userId);
    }

    @PostMapping("/")
    public Integer createNotebook(@RequestBody NotebookPO po) {
        return notebookService.createNotebook(po);
    }

    @PutMapping("/{notebookId}")
    public void updateNotebook(@PathVariable Integer notebookId, @RequestBody NotebookPO po) {
        if (po.getNotebookId() == null) {
            po.setNotebookId(notebookId);
        }
        notebookService.updateNotebook(po);
    }

    @DeleteMapping("/{notebookId}")
    public void deleteNotebook(@PathVariable Integer notebookId) {
        notebookService.deleteNotebook(notebookId);
    }

    @PutMapping("/recover/{notebookId}")
    public void recoverNotebook(@PathVariable Integer notebookId) {
        notebookService.recoverNotebook(notebookId);
    }
}
