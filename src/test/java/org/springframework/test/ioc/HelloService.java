package org.springframework.test.ioc;

/**
 * @Author: 无糖茶 wiretender.top
 * @CreateTime: 2026-03-13
 * @Description:
 * @Version: 1.0
 */
public class HelloService {

    public String sayHello() {
        System.out.println("hello");
        return "hello";
    }
}
