package com.geek;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class HelloClassLoaderTest {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class classname = new HelloClassLoader("/Users/nshijie/IdeaProjects/jk/src/com/jk/work/Hello.xlass").findClass("Hello");
        Method method = classname.getDeclaredMethod("hello");
        method.invoke(classname.newInstance());
    }
}
