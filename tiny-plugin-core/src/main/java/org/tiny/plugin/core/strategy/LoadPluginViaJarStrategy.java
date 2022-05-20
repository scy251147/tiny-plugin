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
 * 从指定jar文件中加载插件
 * URL格式： URL url = new URL("jar:file:/D:/project/tiny-plugin-hello/target/tiny-plugin-hello-1.0-SNAPSHOT.jar!/");
 */
@Slf4j
public class LoadPluginViaJarStrategy extends AbstractPluginLoadStrategy {

    /**
     * 加载插件
     *
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
