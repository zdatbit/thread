### 自定义classloader加载class步骤
```
1.定义一个file，定位到class的位置
2.从class文件里读取出二进制文件
3.调用this.defineClass加载class
```