package cn.edu.bigc.cloudnote.controller;

import cn.edu.bigc.cloudnote.model.UserPO;
import cn.edu.bigc.cloudnote.model.UserTypePO;
import cn.edu.bigc.cloudnote.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class AccountController {
    @Autowired
    private AccountService service;

    @PostMapping("/signup")
    Integer signUp(UserPO user) {
        return service.signUp(user);
    }

    @GetMapping("/signin")
    UserPO signIn(@RequestParam("username") String username, @RequestParam("password") String password) {
        return service.signIn(username, password);
    }

    @GetMapping("/usertypes")
    List<UserTypePO> getAllUserTypes() {
        return service.getAllUserTypes();
    }
}
