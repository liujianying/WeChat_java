package com.tencent.mm.plugin.freewifi.b;

import com.tencent.mm.plugin.freewifi.m;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class a {
    private boolean jjc;
    private Map<String, b> jjd;

    /* synthetic */ a(byte b) {
        this();
    }

    private a() {
        this.jjc = false;
        this.jjd = new LinkedHashMap<String, b>() {
            protected final boolean removeEldestEntry(Entry entry) {
                return size() > 512;
            }
        };
    }

    private static String cN(String str, String str2) {
        return str + "-" + str2;
    }

    public final synchronized void d(String str, String str2, String str3, int i) {
        if (!(m.isEmpty(str) || m.isEmpty(str2) || m.isEmpty(str3) || (i != 4 && i != 31))) {
            b bVar = new b();
            bVar.bIQ = str3;
            bVar.jie = i;
            this.jjd.put(cN(str, str2), bVar);
        }
    }

    public final synchronized b cO(String str, String str2) {
        b bVar;
        if (m.isEmpty(str) || m.isEmpty(str2)) {
            bVar = null;
        } else {
            bVar = (b) this.jjd.get(cN(str, str2));
        }
        return bVar;
    }

    public final synchronized int size() {
        return this.jjd.size();
    }
}
