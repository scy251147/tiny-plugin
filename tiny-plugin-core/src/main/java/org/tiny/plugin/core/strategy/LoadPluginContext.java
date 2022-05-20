package org.tiny.plugin.core.strategy;

import org.tiny.plugin.core.classloader.TinyPluginClassLoader;
import java.net.URL;
import java.util.Set;

/**
 * 插件加载上下文
 */
public class LoadPluginContext {

    /**
     * 带参构造
     *
     * @param pluginLoadStrategy
     */
    public LoadPluginContext(AbstractPluginLoadStrategy pluginLoadStrategy, TinyPluginClassLoader tinyPluginClassLoader) {
        this.pluginLoadStrategy = pluginLoadStrategy;
        this.tinyPluginClassLoader = tinyPluginClassLoader;
    }

    /**
     * 注入的插件加载策略
     */
    private AbstractPluginLoadStrategy pluginLoadStrategy;

    /**
     * 插件的类加载器
     */
    private TinyPluginClassLoader tinyPluginClassLoader;

    /**
     * 加载插件
     *
     * @param jarURL
     * @return
     */
    public Set<Class> loadPlugins(URL jarURL) {
        //设置插件加载器
        pluginLoadStrategy.setTinyPluginClassLoader(tinyPluginClassLoader);
        //执行插件加载操作
        return pluginLoadStrategy.loadPlugins(jarURL);
    }
}
