package org.tiny.plugin.core;

import lombok.extern.slf4j.Slf4j;
import org.tiny.plugin.client.IPluginService;
import java.net.URL;
import java.util.ServiceLoader;

/**
 * 插件执行
 */
@Slf4j
public class PluginExecuteService {

    /**
     * 插件加载工厂
     */
    private static PluginLoadFactory pluginLoadFactory = new PluginLoadFactory();

    /**
     * 执行插件
     */
    public void processPlugins(URL... urls) {
        handleAppPlugins();
        handleJarPlugins(urls);
        ServiceLoader<IPluginService> serviceLoader = ServiceLoader.load(IPluginService.class, pluginLoadFactory.getPluginLoader());
        for (IPluginService pluginService : serviceLoader) {
            pluginService.Process();
        }
    }

    /**
     * 处理应用内插件
     */
    private void handleAppPlugins() {
        pluginLoadFactory.loadAppPlugins();
    }

    /**
     * 处理指定jar文件
     *
     * @param urls
     */
    private void handleJarPlugins(URL... urls) {
        if (urls == null || urls.length == 0) {
            log.error("jar url path empty");
            return;
        }
        for (URL url : urls) {
            pluginLoadFactory.loadJarPlugins(url);
        }
    }
}