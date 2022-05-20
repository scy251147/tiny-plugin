package org.tiny.plugin.client;

/**
 * 插件服务，插件实现都需要继承此类
 * 之所以此类专门独立到一个module中，就是为了防止外部插件打包的时候，fat jar干净，冲突会少很多
 */
public interface IPluginService {

    /**
     * 插件版本
     * @return
     */
    String getPluginVersion();

    /**
     * 插件执行顺序
     * @return
     */
    int getPluginIndex();

    /**
     * 插件名称
     * @return
     */
    String getPluginName();

    /**
     * 插件业务逻辑
     */
    void Process();

}
