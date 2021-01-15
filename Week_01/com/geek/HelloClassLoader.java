package com.geek;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class HelloClassLoader extends ClassLoader{

    private String classPath;
    public HelloClassLoader(String classPath){
        this.classPath = classPath;
    }
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] data = initxClazzData();
        return defineClass(name,data,0, data.length);
    }

    private byte[] initxClazzData() {
        String name = this.classPath;
        byte[] data =null;
        try {
            data = extracted(name);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return toHandleDate(data);
    }

    private byte[] toHandleDate(byte[] data) {
        for (int i = 0; i < data.length; i++) {
            data[i] = (byte)(255 - data[i]);
        }
        return data;
    }

    private byte[] extracted(String name) throws IOException {
        File file = new File(name);
        byte[] bytes = new byte[(int) file.length()];
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            fis.read(bytes);
        } finally {
            if (fis != null) {
                fis.close();
            }
        }
        return bytes;
    }
}
