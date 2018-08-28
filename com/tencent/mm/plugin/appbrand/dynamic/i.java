package com.tencent.mm.plugin.appbrand.dynamic;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class i {
    private static final i fuP = new i();
    public Map<String, String> fuO = new HashMap();

    public static i aeT() {
        return fuP;
    }

    public final String sz(String str) {
        return (String) this.fuO.get(str);
    }

    public final Collection<String> aeU() {
        return this.fuO.values();
    }
}
