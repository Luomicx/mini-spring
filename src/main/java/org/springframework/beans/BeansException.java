package org.springframework.beans;

/**
 * @Author: 无糖茶 wiretender.top
 * @CreateTime: 2026-03-13
 * @Description:
 * @Version: 1.0
 */
public class BeansException extends RuntimeException {
    public BeansException(String msg) {
        super(msg);
    }
    public BeansException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
