package com.tencent.mm.plugin.appbrand.s.e;

import java.util.Collections;
import java.util.Iterator;
import java.util.TreeMap;

public class g implements c {
    private byte[] content;
    private TreeMap<String, String> gDW = new TreeMap(String.CASE_INSENSITIVE_ORDER);

    public final Iterator<String> aoQ() {
        return Collections.unmodifiableSet(this.gDW.keySet()).iterator();
    }

    public final String wa(String str) {
        String str2 = (String) this.gDW.get(str);
        if (str2 == null) {
            return "";
        }
        return str2;
    }

    public final byte[] aoR() {
        return this.content;
    }

    public final void put(String str, String str2) {
        this.gDW.put(str, str2);
    }

    public final boolean wb(String str) {
        return this.gDW.containsKey(str);
    }
}
