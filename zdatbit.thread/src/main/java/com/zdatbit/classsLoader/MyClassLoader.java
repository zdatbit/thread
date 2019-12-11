package com.zdatbit.classsLoader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * Created by zhangdi21 on 2019/12/11.
 */
public class MyClassLoader extends ClassLoader{

    private final String DEFAUT_FILEPATH = "E:\\classLoader";
    private String filePath = DEFAUT_FILEPATH;
    private String loaderName;

    public MyClassLoader(){
        super();
    }

    public MyClassLoader(String loaderName){
        super();
        this.loaderName = loaderName;
    }

    public MyClassLoader(String loaderName,ClassLoader loader){
        super(loader);
        this.loaderName = loaderName;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String className = name.replace(".","/");
        System.out.println(className);
        File classFile = new File(filePath,className+".class");
        if(!classFile.exists()){
            throw new ClassNotFoundException(name+"文件不存在");
        }

        byte[] classBytes = loadClassBytes(classFile);
        if(classBytes==null||classBytes.length==0){
            throw new ClassNotFoundException("");
        }

        return this.defineClass(name,classBytes,0,classBytes.length);
    }

    public byte[] loadClassBytes(File classFile){
        try(ByteArrayOutputStream baos = new ByteArrayOutputStream();
            FileInputStream fis = new FileInputStream(classFile)){
            byte[] bytes = new byte[1024];
            int len;
            while((len = fis.read(bytes))!=-1){
                baos.write(bytes,0,len);
            }
            baos.flush();
            return baos.toByteArray();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }


    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getLoaderName() {
        return loaderName;
    }

    public void setLoaderName(String loaderName) {
        this.loaderName = loaderName;
    }
}
