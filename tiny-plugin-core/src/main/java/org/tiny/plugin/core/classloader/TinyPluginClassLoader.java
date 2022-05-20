package org.tiny.plugin.core.classloader;

import java.net.URL;
import java.net.URLClassLoader;

public class TinyPluginClassLoader extends URLClassLoader {

    /**
     * 带参构造
     * @param urls
     */
    public TinyPluginClassLoader(URL[] urls, ClassLoader parent) {
        super(urls, parent);
    }

    /**
     * 添加URL路径
     * @param url
     */
    public void addURL(URL url) {
        super.addURL(url);
    }
}
