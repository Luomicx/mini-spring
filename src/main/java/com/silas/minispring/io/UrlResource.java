package com.silas.minispring.io;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * @Author: 无糖茶 wiretender.top
 * @CreateTime: 2026-02-02
 * @Description:
 * @Version: 1.0
 */
public class UrlResource implements Resource {

    private final URL url;

    public UrlResource(URL url) {
        this.url = url;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        // 1.打开URL链接
        URLConnection urlConnection = url.openConnection();
        // 2.建立实际链接
        urlConnection.connect();
        // 3.获取字节输入流，这样后续的解析器就能读取内容
        return urlConnection.getInputStream();
    }
}
