package org.tiny.plugin.core.test;

import org.junit.Test;
import org.tiny.plugin.core.PluginExecuteService;
import java.net.MalformedURLException;
import java.net.URL;

public class PlguinTest {

    @Test
    public void testWithApp() {
        PluginExecuteService executeService = new PluginExecuteService();
        executeService.processPlugins();
    }

    @Test
    public void testWithJar() throws MalformedURLException {
        PluginExecuteService executeService = new PluginExecuteService();
        URL url = new URL("jar:file:/D:/project/tiny-plugin-hello/tiny-plugin-print/target/tiny-plugin-print-1.0-SNAPSHOT.jar!/");
        executeService.processPlugins(url);
    }

    @Test
    public void testWithWeb() throws MalformedURLException {
        PluginExecuteService executeService = new PluginExecuteService();
        URL url = new URL("jar:http://100.124.10.16/tiny-plugin-print-1.0-SNAPSHOT.jar!/");
        executeService.processPlugins(url);
    }

    /**
     * 应用没有guava组件，但是插件里面有，看看能不能运行
     * todo 插件里面不能有fastjson，否则运行不起来，尝试解决
     */
    @Test
    public void testWithJarAndGuava() throws MalformedURLException {
        PluginExecuteService executeService = new PluginExecuteService();
        URL url = new URL("jar:file:/D:/project/tiny-plugin-hello/tiny-plugin-guava/target/tiny-plugin-guava-1.0-SNAPSHOT.jar!/");
        executeService.processPlugins(url);
    }

}
