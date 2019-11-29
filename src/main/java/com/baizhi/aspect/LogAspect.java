package com.baizhi.aspect;

import com.baizhi.entity.Admin;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

//开发日志切面(通知+切入点)
@Slf4j
@Component
@Aspect
public class LogAspect {
    @Autowired
    HttpServletRequest request;

    @Around("pt()")
    public Object LogAround(ProceedingJoinPoint proceedingJoinPoint) {

        //注意：由于代理方式的差异，拿到的方法对象有可能不一样 基于jdk 拿到的是接口中的抽象方法
        //     基于cglib的代理方式拿到才是实现类中的方法对象

        /*
         * who 在 when 操作了 what 结果是 result
         * */
        Admin admin = (Admin) request.getSession().getAttribute("admin");
        String who = admin.getName();

        Date when = new Date();

        //获取自定义注解上的name属性的信息
        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        Method method = signature.getMethod();
        Log annotation = method.getAnnotation(Log.class);
        String what = annotation.name();


        boolean result = false;


        Object proceed = null;
        try {
            proceed = proceedingJoinPoint.proceed();
            result = true;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        } finally {
            log.debug("who===> :{},when===> :{},what===> :{},result===> :{}", who, new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(when), what, result);
        }

        return proceed;
    }

    @Pointcut("@annotation(com.baizhi.aspect.Log)")
    public void pt() {
    }

}
