package com.demo.common.annotate.handle;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
@Slf4j
public class LogHandle {
    /**
     * PointCut表示这是一个切点，@annotation表示这个切点切到一个注解上，后面带该注解的全类名
     * 切面最主要的就是切点，所有的故事都围绕切点发生
     * logPointCut()代表切点名称
     */
    @Pointcut("@annotation(com.demo.common.annotate.LogStorage)")
    private void roleHandle(){}

    /**
     * 目标方法调用之前执行
     * 注意这里不能使用 ProceedingJoinPoint
     * @param joinPoint
     */
    @Before("roleHandle()")
    public void doBefore(JoinPoint joinPoint){
        log.info("Before Test");
    }

    /**
     * 目标方法调用之后执行
     * 注意这里不能使用 ProceedingJoinPoint
     * @param joinPoint
     */
    @After("roleHandle()")
    public void doAfter(JoinPoint joinPoint){
        log.info("End Test");
    }

    /**
     * 环绕通知
     * @param proceedingJoinPoint
     */
    @Around("roleHandle()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        //方法调用前
        MethodSignature methodSignature =(MethodSignature) proceedingJoinPoint.getSignature();
        //获取方法名称
        String methodName=methodSignature.getName();

        //获取@InterfaceLog注解入参的值
        Method method = methodSignature.getMethod();

        //继续执行方法
        Object result=proceedingJoinPoint.proceed();

        //方法调用后，打印方法耗时
        System.out.println("执行结束");
        return result;
    }
}
