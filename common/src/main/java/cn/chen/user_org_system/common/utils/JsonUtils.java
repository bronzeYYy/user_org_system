package cn.chen.user_org_system.common.utils;


import com.fasterxml.jackson.databind.node.JsonNodeFactory;

public final class JsonUtils {
    public static String toJsonString(Object o) {
        return JsonNodeFactory.instance.pojoNode(o).toString();
    }
}
