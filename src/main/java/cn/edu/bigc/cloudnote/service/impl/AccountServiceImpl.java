package cn.edu.bigc.cloudnote.service.impl;

import cn.edu.bigc.cloudnote.constant.UserTypeConsts;
import cn.edu.bigc.cloudnote.mapper.UserPOMapper;
import cn.edu.bigc.cloudnote.mapper.UserTypePOMapper;
import cn.edu.bigc.cloudnote.model.UserPO;
import cn.edu.bigc.cloudnote.model.UserTypePO;
import cn.edu.bigc.cloudnote.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by TiancongLi(tiancong.li@hotmail.com) on 2018/5/29.
 */
@Service @Slf4j
public class AccountServiceImpl implements AccountService {
    @Autowired
    private UserPOMapper userPOMapper;

    @Autowired
    private UserTypePOMapper userTypePOMapper;


    @Override
    public UserPO signIn(String username, String password) {
        List<UserPO> uList = userPOMapper.selectAll();
        Optional<UserPO> po = uList.stream().filter(u -> u.getUserName().equals(username) && u.getUserPassword().equals(password)).findFirst();
        if (po.isPresent()) {
            UserPO user = po.get();
            user.setUserPassword("hidden");
            log.info("用户 {} 登陆成功", username);
            return user;
        }
        log.error("用户 {} 登陆失败", username);
        return null;
    }

    @Override
    public Integer signUp(UserPO po) {
        List<UserTypePO> types = userTypePOMapper.selectAll();
        if (po.getUserTypeId() == null) {
            UserTypePO normal = types.stream().filter(type -> type.getTypeCode().equals(UserTypeConsts.NOMAL)).collect(Collectors.toList()).get(0);
            po.setUserTypeId(normal.getTypeId());
        }
        userPOMapper.insert(po);
        log.info("用户 {} 注册成功", po.getUserId());
        return po.getUserId();
    }

    @Override
    public List<UserTypePO> getAllUserTypes() {
        return userTypePOMapper.selectAll();
    }

    @Override
    public void promote(Integer userId, Integer typeId) {
        UserPO user = new UserPO();
        user.setUserId(userId);
        user.setUserTypeId(typeId);
        userPOMapper.update(user);
    }
}
