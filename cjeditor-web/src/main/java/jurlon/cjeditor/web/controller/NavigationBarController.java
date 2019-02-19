package jurlon.cjeditor.web.controller;

import jurlon.cjeditor.mybatis.model.NavigationBar;
import jurlon.cjeditor.service.INavigationBarService;
import jurlon.cjeditor.service.impl.NavigationBarService;
import jurlon.cjeditor.web.util.IMoocJSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: jurlon@163.com
 * @DateTime: 2019/2/19 17:58
 * @FileName: NavigationBarController
 * @Description
 */
@Controller
@RequestMapping("")
public class NavigationBarController {
    @Autowired
    private INavigationBarService navigationBarService;
    
    @ResponseBody
    @RequestMapping("list")
    public IMoocJSONResult listBy(){
        List<NavigationBar> list = navigationBarService.listBy();
        return IMoocJSONResult.ok(list);
    }
}
