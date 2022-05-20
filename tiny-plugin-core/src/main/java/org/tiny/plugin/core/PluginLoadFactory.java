package org.tiny.plugin.core;

import lombok.extern.slf4j.Slf4j;
import org.tiny.plugin.core.classloader.TinyPluginClassLoader;
import org.tiny.plugin.core.strategy.*;
import java.net.URL;
import java.util.Set;

@Slf4j
public class PluginLoadFactory {

    /**
     * 插件jar的类加载器
     */
    private static TinyPluginClassLoader urlClassLoader = new TinyPluginClassLoader(new URL[]{}, PluginLoadFactory.class.getClassLoader());

    /**
     * 获取当前类加载器
     *
     * @return
     */
    public TinyPluginClassLoader getPluginLoader() {
        return urlClassLoader;
    }

    /**
     * 加载当前应用所有插件
     *
     * @return
     */
    public Set<Class> loadAppPlugins() {
        AbstractPluginLoadStrategy pluginLoadStrategy = new LoadPluginViaAppStrategy();
        LoadPluginContext loadPluginContext = new LoadPluginContext(pluginLoadStrategy, urlClassLoader);
        log.debug("PluginLoadFactory.loadAppPlugins success");
        return loadPluginContext.loadPlugins(null);
    }

    /**
     * 加载指定jar中的插件
     *
     * @param url
     * @return
     */
    public Set<Class> loadJarPlugins(URL url) {
        AbstractPluginLoadStrategy pluginLoadStrategy = new LoadPluginViaJarStrategy();
        LoadPluginContext loadPluginContext = new LoadPluginContext(pluginLoadStrategy, urlClassLoader);
        log.debug("PluginLoadFactory.loadJarPlugins success");
        return loadPluginContext.loadPlugins(url);
    }

    /**
     * 加载指定web路径中的插件
     *
     * @param url
     * @return
     */
    public Set<Class> loadWebPlugins(URL url) {
        AbstractPluginLoadStrategy pluginLoadStrategy = new LoadPluginViaWebStrategy();
        LoadPluginContext loadPluginContext = new LoadPluginContext(pluginLoadStrategy, urlClassLoader);
        log.debug("PluginLoadFactory.loadWebPlugins success");
        return loadPluginContext.loadPlugins(url);
    }

}
