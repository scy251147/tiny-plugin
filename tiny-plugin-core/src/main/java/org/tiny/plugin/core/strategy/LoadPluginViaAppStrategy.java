package org.tiny.plugin.core.strategy;

import lombok.extern.slf4j.Slf4j;
import org.tiny.plugin.client.IPluginService;
import java.net.URL;
import java.util.HashSet;
import java.util.ServiceLoader;
import java.util.Set;

/**
 * 从当前应用内加载插件
 */
@Slf4j
public class LoadPluginViaAppStrategy extends AbstractPluginLoadStrategy {

    /**
     * 加载插件
     *
     * @param jarURL
     * @return
     */
    @Override
    public Set<Class> loadPlugins(URL jarURL) {
        Set<Class> pluginClasses = new HashSet<Class>();
        ServiceLoader<IPluginService> serviceLoader = ServiceLoader.load(IPluginService.class, getTinyPluginClassLoader());
        for (IPluginService pluginService : serviceLoader) {
            pluginClasses.add(pluginService.getClass());
            try {
                getTinyPluginClassLoader().loadClass(pluginService.getClass().getName());
            } catch (ClassNotFoundException e) {
                log.error("LoadPluginViaAppStrategy.loadPlugins fail", e);
            }
        }
        return pluginClasses;
    }
}
