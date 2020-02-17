package com.example.demo.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @Describe 定义日志切面:
 * @Aspect注解定义一个切面
 * @Lazy注解的value为false为取消延迟加载
 */


@Lazy(false)
@Aspect
@Component
public class LoggerAspect {

    /**
     * 定义切入点:对要拦截的方法进行定义与限制,可以是包或类
     * 例如:
     * 1、execution(public * *(..)) 任意的公共方法
     * 2、execution（* set*（..）） 以set开头的所有的方法
     * 3、execution（* com.lingyejun.annotation.LoggerApply.*（..））com.lingyejun.annotation.LoggerApply这个类里的所有的方法
     * 4、execution（* com.lingyejun.annotation.*.*（..））com.lingyejun.annotation包下的所有的类的所有的方法
     * 5、execution（* com.lingyejun.annotation..*.*（..））com.lingyejun.annotation包及子包下所有的类的所有的方法
     * 6、execution(* com.lingyejun.annotation..*.*(String,?,Long)) com.lingyejun.annotation包及子包下所有的类的有三个参数，第一个参数为String类型，第二个参数为任意类型，第三个参数为Long类型的方法
     * 7、execution(@annotation(com.lingyejun.annotation.Lingyejun))
     */
    @Pointcut("@annotation(com.example.demo.annotation.MyAnnotation)")
    private void cutMethod() {

    }

    /**
     * 前置通知:在切入点执行前前调用
     */
    @Before("cutMethod()")
    public void begin() {
        System.out.println("前置通知@Before");
    }

    /**
     * 后置通知:在切入点执行成功后调用
     */
    @AfterReturning("cutMethod()")
    public void afterReturning() {
        System.out.println("后置通知方法调用成功执行@AfterReturing");
    }

    /**
     * 最终通知:在切入点执行后无论成功与否都调用
     */
    @After("cutMethod()")
    public void after() {
        System.out.println("后置最终通知@After");
    }

    /**
     * 异常通知:切入点执行抛异常通知
     */
    @AfterThrowing("cutMethod()")
    public void afterThrowing() {
        System.out.println("异常通知@AfterThrowing");
    }

    /**
     * 环绕通知:获取切入点的完全控制权(方法是否执行,控制参数,控制返回值)
     * 使用环绕通知时,目标的一切信息都能通过invocation参数获取到
     */
    @Around("cutMethod()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        //从切入点获取方法名称
        String methodName = joinPoint.getSignature().getName();
        //获取方法传入参数
        Object[] params = joinPoint.getArgs();
        MyAnnotation myAnnotation = getDeclareAnnotation(joinPoint);
        System.out.println("环绕通知,切入点前执行");
        //执行切入点源方法
        joinPoint.proceed();
        //模拟进行验证
        System.out.println("环绕通知,切入点后执行");
    }


    /**
     * 获取方法名中声明的注解
     */
    public MyAnnotation getDeclareAnnotation(ProceedingJoinPoint joinPoint) throws NoSuchMethodException {
        //获取方法名
        String methodName = joinPoint.getSignature().getName();
        //反射获取目标类
        Class<?> targetClass = joinPoint.getTarget().getClass();
        //拿到方法对应的参数类型
        Class<?>[] parameterTypes = ((MethodSignature) joinPoint.getSignature()).getParameterTypes();
        //根据类,方法,参数类型获取到方法的具体信息
        Method objMethod = targetClass.getMethod(methodName, parameterTypes);
        //拿到方法定义的注解信息
        MyAnnotation annotation = objMethod.getDeclaredAnnotation(MyAnnotation.class);
        return annotation;
    }
}
