package more.controller;

import com.zy.more.Page;
import com.zy.more.Result;
import more.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

/**
 * @author: zhangyao
 * @create:2020-06-28 18:18
 **/
@RestController
@RequestMapping("/user")
@RefreshScope
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public Result getUser(Page page){
        if(page.getPage()==0){
            return userService.getUser();
        }else{
            return userService.getUser(PageRequest.of(page.getPage(),page.getSize()));
        }
    }

    @GetMapping("/{name}")
    public Result getUserByName(@PathVariable String name){
        return userService.findUserByUserName(name);
    }

}
