package org.tiny.plugin.core.plugins;

import org.tiny.plugin.client.IPluginService;

public class PrintPluginService implements IPluginService {

    @Override
    public String getPluginVersion() {
        return "1.0.0";
    }

    @Override
    public int getPluginIndex() {
        return 0;
    }

    public String getPluginName(){
        return "日志打印插件";
    }

    public void Process() {
        System.out.println("----> this is test message write by plugin service");
    }
}
