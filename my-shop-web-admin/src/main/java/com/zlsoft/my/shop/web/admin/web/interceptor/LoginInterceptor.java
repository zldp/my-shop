package com.zlsoft.my.shop.web.admin.web.interceptor;

import com.zlsoft.my.shop.domain.TbUser;
import com.zlsoft.my.shop.domain.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author dp
 * @version 1.0.0
 * @date 2019-07-11 15:00
 */
public class LoginInterceptor implements HandlerInterceptor {

    // 这个方法是在controller执行之前执行  在配置时先配置先执行
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        TbUser user = (TbUser) httpServletRequest.getSession().getAttribute("user");

        // 判断用户是否登录
        if (user == null) {
            // 用户未登录，重定向到登录页
            httpServletResponse.sendRedirect("/login");
            return false;
        }

        // 放行
        return true;
    }

    // 这个方法在preHandle（）方法返回true时  controller执行完成时执行  先配置后执行
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
