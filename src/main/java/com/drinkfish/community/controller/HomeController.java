package com.drinkfish.community.controller;

import com.drinkfish.community.entity.DiscussPost;
import com.drinkfish.community.entity.Page;
import com.drinkfish.community.entity.User;
import com.drinkfish.community.service.DiscussPostService;
import com.drinkfish.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author DrinkFish
 */
@Controller
public class HomeController {

    @Autowired
    private DiscussPostService discussPostService;

    @Autowired
    private UserService userService;

    @GetMapping(path = "/index")
    public String getIndexPage(Model model, Page page) {
        // 方法调用前，SpringMVC会自动实例化Model和Page,并将Page注入Model，所以在thymeleaf中可以直接访问Page对象中的数据。
        page.setRows(discussPostService.findDiscussPostRows(0));
        page.setPath("/index");

        List<DiscussPost> list = discussPostService.findDiscussPosts(0, page.getOffset(), page.getLimit());
        List<Map<String,Object>> discussPosts = new ArrayList<>();
        if (list != null) {
            for (DiscussPost discussPost : list) {
                // 查询用户信息并封装
                User user = userService.findUserById(discussPost.getUserId());
                HashMap<String, Object> map = new HashMap<>();
                map.put("post", discussPost);
                map.put("user", user);
                discussPosts.add(map);
            }
        }
        model.addAttribute("discussPosts", discussPosts);
        return "/index";
    }
}
