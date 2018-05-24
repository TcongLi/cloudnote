package cn.edu.bigc.cloudnote.controller;

import cn.edu.bigc.cloudnote.entity.Fucker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloController {

    @GetMapping("/fucker/{fuckerId}")
    public Fucker fuck(@PathVariable("fuckerId") Integer fuckerId) {
        return new Fucker("faggot", fuckerId);
    }
}
