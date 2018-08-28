package com.tencent.mm.plugin.appbrand.r;

public final class h {
    public static Boolean bs(Object obj) {
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if ("true".equalsIgnoreCase(str)) {
                return Boolean.valueOf(true);
            }
            if ("false".equalsIgnoreCase(str)) {
                return Boolean.valueOf(false);
            }
        }
        return null;
    }
}
