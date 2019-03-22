package jurlon.cjeditor.web.controller;

import jurlon.cjeditor.common.service.INavigationBarService;
import jurlon.cjeditor.common.vo.NavigationBarVo;
import jurlon.cjeditor.web.util.JSONResultUtil;
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
@RequestMapping("navigationBar")
public class NavigationBarController {
    @Autowired
    private INavigationBarService navigationBarService;
    
    @ResponseBody
    @RequestMapping("list")
    public JSONResultUtil listBy(){
        List<NavigationBarVo> list = navigationBarService.listAllAble();
        return JSONResultUtil.success(list);
    }
}
