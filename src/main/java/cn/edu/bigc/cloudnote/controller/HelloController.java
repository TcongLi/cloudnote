package cn.edu.bigc.cloudnote.controller;

import cn.edu.bigc.cloudnote.mapper.UserTypePOMapper;
import cn.edu.bigc.cloudnote.model.UserTypePO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloController {
    @Autowired
    UserTypePOMapper mapper;

    @GetMapping("/hello")
    void hello() {
        mapper.insert(new UserTypePO(null, "000", "普通会员", "最多只能创建 10 条笔记", 10));
    }
}
