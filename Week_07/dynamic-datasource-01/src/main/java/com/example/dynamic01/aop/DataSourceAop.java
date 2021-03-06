package com.example.dynamic01.aop;

import com.example.dynamic01.config.DynamicDBType;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DataSourceAop {
    @Pointcut("@annotation(com.example.dynamic01.interfaces.Slave)")
    public void readPointcut() {
    }

    @Pointcut("@annotation(com.example.dynamic01.interfaces.Master)")
    public void writePointcut() {
    }

    @Before("readPointcut()")
    public void readAdvise() {
        DynamicDBType.slave();
    }

    @Before("writePointcut()")
    public void writeAdvise() {
        DynamicDBType.master();
    }
}
