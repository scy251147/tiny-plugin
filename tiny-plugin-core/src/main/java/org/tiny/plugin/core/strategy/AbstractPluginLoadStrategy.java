package org.tiny.plugin.core.strategy;

import lombok.Getter;
import lombok.Setter;
import java.net.URL;
import java.util.Set;
import org.tiny.plugin.core.classloader.*;

public abstract class AbstractPluginLoadStrategy {

    /**
     * 插件加载器
     */
    @Setter
    @Getter
    private TinyPluginClassLoader tinyPluginClassLoader;


    /**
     * 加载插件
     * @param jarURL
     * @return
     */
    public abstract Set<Class> loadPlugins(URL jarURL);
}
