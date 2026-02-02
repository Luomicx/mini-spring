package com.silas.minispring.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: 无糖茶 wiretender.top
 * @CreateTime: 2026-02-02
 * @Description: Spring 内部定位资源的接口
 * @Version: 1.0
 */
public interface Resource {

    InputStream getInputStream() throws IOException;
}
