package org.tiny.plugin.core.strategy;

import lombok.extern.slf4j.Slf4j;
import org.tiny.plugin.client.IPluginService;
import org.tiny.plugin.core.utils.PluginUtil;
import java.io.IOException;
import java.net.JarURLConnection;
import java.net.URL;
import java.util.Set;
import java.util.jar.JarFile;

/**
 * 从网络加载插件
 * URL格式：  URL url = new URL("jar:http://100.124.10.16/tiny-plugin-hello-1.0-SNAPSHOT.jar!/");
 */
@Slf4j
public class LoadPluginViaWebStrategy extends AbstractPluginLoadStrategy {

    /**
     * 从指定web路径加载插件
     *
     * @param jarURL
     * @return
     */
    @Override
    public Set<Class> loadPlugins(URL jarURL) {
        try {
            JarFile jarFile = ((JarURLConnection) jarURL.openConnection()).getJarFile();
            getTinyPluginClassLoader().addURL(jarURL);
            return PluginUtil.loadPluginFromJarFile(IPluginService.class, jarFile, getTinyPluginClassLoader());
        } catch (IOException e) {
            log.error("LoadPluginViaJarStrategy.loadPlugins fail", e);
            return null;
        }
    }

}
