package com.tencent.mm.plugin.appbrand.jsapi.file;

import java.util.HashMap;
import java.util.Map;

public final class f$a {
    public final String Yy;
    public final Map<String, Object> values = new HashMap();

    public f$a(String str, Object... objArr) {
        this.Yy = String.format(str, objArr);
    }

    public final f$a t(String str, Object obj) {
        this.values.put(str, obj);
        return this;
    }

    public final f$a z(Map<String, Object> map) {
        if (map != null) {
            this.values.putAll(map);
        }
        return this;
    }
}
