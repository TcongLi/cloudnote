package cn.edu.bigc.cloudnote.service.impl;

import cn.edu.bigc.cloudnote.model.NotebookPO;
import cn.edu.bigc.cloudnote.service.NotebookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NotebookServiceImplTest {
    @Autowired
    NotebookService service;

    @Test
    public void getAllNotebooks() {
        service.getAllNotebooks(2).forEach(System.out::println);
    }

    @Test
    public void getAllDeletedBooks() {
        service.getAllDeletedBooks(2).forEach(System.out::println);
    }

    @Test
    public void createNotebook() {
        Integer id = service.createNotebook(new NotebookPO(null, 2, "编程笔记", "记录编程过程中遇到的问题和解决方法", null, null, null, null));
        assertNotNull(id);
    }

    @Test
    public void updateNotebook() {
        NotebookPO notebook = new NotebookPO();
        notebook.setNotebookId(4);
        notebook.setStared(true);
        service.updateNotebook(notebook);
    }

    @Test
    public void deleteNotebook() {
        service.deleteNotebook(4);
    }

    @Test
    public void recoverNotebook() {
        service.recoverNotebook(4);
    }
}