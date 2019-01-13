package com.xiaotian.ssm.web.interceptor;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {

    //controller执行前调用此方法
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {

        //拦截
        //1.排除不需要拦截的路径
        System.out.println("客户端访问资源的路径"+ request.getRequestURI());
        if( request.getRequestURI().endsWith("login.do")){
            return true;//放行
        }
        //2.如果已经登陆
        if(request.getSession().getAttribute("user") != null){
            return true;
        }

        //3.进入登陆界面
        request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request,response);
        return false;
    }

    //controller执行后，但未返回视图前调用此方法
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("未返回视图前  后处理。。。。");
    }

    //controller执行后，并且视图返回后调用此方法
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("返回视图前  后处理。。。。");
    }
}
