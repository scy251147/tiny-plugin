package org.tiny.plugin.core.utils;

import lombok.extern.slf4j.Slf4j;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import org.tiny.plugin.core.classloader.*;

@Slf4j
public class PluginUtil {

    /**
     * 从jar文件中提取出对应的插件类
     *
     * @param pluginClass
     * @param jarFile
     * @return
     */
    public static Set<Class> loadPluginFromJarFile(Class pluginClass, JarFile jarFile, TinyPluginClassLoader tinyPluginClassLoader) {
        Set<Class> pluginClasses = new HashSet<Class>();
        Enumeration<JarEntry> jars = jarFile.entries();
        while (jars.hasMoreElements()) {
            JarEntry jarEntry = jars.nextElement();
            String jarEntryName = jarEntry.getName();
            if (jarEntryName.charAt(0) == '/') {
                jarEntryName = jarEntryName.substring(1);
            }
            if (jarEntry.isDirectory() || !jarEntryName.endsWith(".class")) {
                continue;
            }
            String className = jarEntryName.substring(0, jarEntryName.length() - 6);
            try {
                Class clazz = tinyPluginClassLoader.loadClass(className.replace("/", "."));
                if (clazz != null && !clazz.isInterface() && pluginClass.isAssignableFrom(clazz)) {
                    pluginClasses.add(clazz);
                }
            } catch (ClassNotFoundException e) {
                log.error("PluginUtil.loadPluginFromJarFile fail",e);
            }
        }
        return pluginClasses;
    }

}
