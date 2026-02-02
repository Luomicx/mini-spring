package com.silas.minispring;

import org.junit.Assert;

/**
 * @Author: 无糖茶 wiretender.top
 * @CreateTime: 2026-02-02
 * @Description:
 * @Version: 1.0
 */
public class OutputService {
    private HelloWorldService helloWorldService;

    public void output(String text){
        Assert.assertNotNull(helloWorldService);
        System.out.println(text);
    }

    public void setHelloWorldService(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }
}
