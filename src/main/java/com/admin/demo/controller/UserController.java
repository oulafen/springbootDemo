package com.admin.demo.controller;

import com.admin.demo.domain.User;
import com.admin.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Date;

@RestController
@RequestMapping(value = "/api")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    /**
     * @Author oulafen
     * @Description 查询用户列表
     * @Date 上午11:16 2018/9/19
     * @Param []
     * @Return java.util.List<com.admin.demo.domain.User>
    **/
    @GetMapping(value = "/users")
    public List<User> userList(){
        return userRepository.findAll();
    }

    /**
     * @Author oulafen
     * @Description 添加新用户
     * @Date 上午11:13 2018/9/19
     * @Param [user]
     * @Return java.lang.Object
    **/
    @PostMapping(value = "/users")
    public User userAdd(User user){
        user.setName(user.getName());
        user.setAge(user.getAge());
        user.setCreateDate(new Date());

        return userRepository.save(user);
    }

    /**
     * @Author oulafen
     * @Description 查看用户
     * @Date 上午11:42 2018/9/19
     * @Param [id]
     * @Return com.admin.demo.domain.User
    **/
    @GetMapping(value = "/users/{id}")
    public User userFindOne(@PathVariable("id") Integer id){
        return userRepository.findById(id).orElse(null);
    }

    /**
     * @Author oulafen
     * @Description 修改用户
     * @Date 下午2:01 2018/9/19
     * @Param [id, user]
     * @Return com.admin.demo.domain.User
    **/
    @PutMapping(value = "/users/{id}")
    public User userUpdate(@PathVariable("id") Integer id, User user){
        user.setId(id);
        user.setName(user.getName());
        user.setAge(user.getAge());

        return userRepository.save(user);
    }

    /**
     * @Author oulafen
     * @Description 删除用户
     * @Date 上午11:43 2018/9/19
     * @Param [id]
     * @Return void
    **/
    @DeleteMapping(value = "/users/{id}")
    public void userDel(@PathVariable("id") Integer id){
        userRepository.deleteById(id);
    }
}
