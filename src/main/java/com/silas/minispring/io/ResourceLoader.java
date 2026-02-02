package com.silas.minispring.io;

import java.net.URL;

/**
 * @Author: 无糖茶 wiretender.top
 * @CreateTime: 2026-02-02
 * @Description: 接受URL路径，返回具体的Resource实现类
 * @Version: 1.0
 */
public class ResourceLoader {

    public Resource getResource(String location){
        // 从classpath 中查找并获得指定资源的URL
        URL resource = this.getClass().getClassLoader().getResource(location);
        return new UrlResource(resource);
    }
}
