//package com.roobtyan.interceptor;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//
///**
// * 登陆拦截器
// * author:liuzixin
// * */
//public class LoginInterceptor implements HandlerInterceptor {
//
//    //进入Handler方法之前执行
//    //用于身份认证、身份授权
//    //比如身份认证，如果认证身份没有登录，就拦截，不向下执行
//    @Override
//    public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception {
//        //获取请求的URL
//        String url = request.getRequestURI();
//        //判断URL是否为公开地址（实际开发中，将公开地址配置在配置文件中）
//        //这里公开地址是登陆提交地址
//        if(url.indexOf("login")>=0||url.indexOf("register")>=0) {
//            //如果进行登陆提交，放行
//            return true;
//        }
//        //判断session
//        HttpSession session = request.getSession();
//        //从session中取出用户信息
//        String username = (String) session.getAttribute("userName");
//        if(username !=null) {
//            //身份存在,放行
//            return true;
//        }
//        //执行这里表示身份需要认证，跳转到登陆页面
//        request.getRequestDispatcher("login.jsp").forward(request, response);
//
//        //return false 表示拦截，不向下执行
//        //return true 表示放行
//        return false;
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
//            throws Exception {
//        // TODO Auto-generated method stub
//
//    }
//
//    @Override
//    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
//            throws Exception {
//        // TODO Auto-generated method stub
//
//    }
//
//}
