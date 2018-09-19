package com.admin.demo;

import com.admin.demo.UserRepository;
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
     * @Return java.util.List<com.admin.demo.User>
    **/
    @GetMapping(value = "/users")
    public List<User> userList(){
        return userRepository.findAll();
    }

    /**
     * @Author oulafen
     * @Description 添加新用户
     * @Date 上午11:13 2018/9/19
     * @Param [name, age]
     * @Return java.lang.Object
    **/
    @PostMapping(value = "/users")
    public User userAdd(@RequestParam("name") String name, @RequestParam("age") Integer age){
        User user = new User();
        user.setName(name);
        user.setAge(age);
        user.setCreateDate(new Date());

        return userRepository.save(user);
    }

    /**
     * @Author oulafen
     * @Description 查看用户
     * @Date 上午11:42 2018/9/19
     * @Param [id]
     * @Return com.admin.demo.User
    **/
    @GetMapping(value = "/users/{id}")
    public User userFindOne(@PathVariable("id") Integer id){
        return userRepository.findById(id).orElse(null);
    }

    /**
     * @Author oulafen
     * @Description 修改用户
     * @Date 上午11:43 2018/9/19
     * @Param [id, name, age]
     * @Return com.admin.demo.User
    **/
    @PutMapping(value = "/users/{id}")
    public User userUpdate(@PathVariable("id") Integer id, @RequestParam("name") String name, @RequestParam("age") Integer age){
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setAge(age);

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
