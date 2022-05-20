package org.tiny.plugin.core.strategy;

public enum PluginLoadType {

    /**
     * 从当前应用获取
     */
    LAOD_IN_APP,

    /**
     * 从指定web路径获取
     */
    LOAD_IN_WEB,

    /**
     * 从指定jar路径获取
     */
    LOAD_IN_JAR,

    /**
     * 空类型
     */
    LOAD_IN_NULL

}
