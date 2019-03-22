package jurlon.cjeditor.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: jurlon@163.com
 * @DateTime: 2019/3/21 9:07
 * @FileName: IndexController
 * @Description
 */
@Controller
@Slf4j
public class IndexController {
    
    @RequestMapping("/")
    public String index(HttpServletRequest request){
        log.info("ip:"+request.getRemoteHost());
        StringBuffer url = request.getRequestURL();
        String tempContextUrl = url.delete(url.length() - request.getRequestURI().length(), url.length()).append(request.getServletContext().getContextPath()).append("/").toString();
        log.info(tempContextUrl);
        return "index";
    }
    
    
    
}
