package com.tencent.tencentmap.mapsdk.a;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class dj extends ci {
    protected HashMap<String, byte[]> e = null;
    md f = new md();
    private HashMap<String, Object> g = new HashMap();

    public <T> void a(String str, T t) {
        if (this.e == null) {
            super.a(str, t);
        } else if (str == null) {
            throw new IllegalArgumentException("put key can not is null");
        } else if (t == null) {
            throw new IllegalArgumentException("put value can not is null");
        } else if (t instanceof Set) {
            throw new IllegalArgumentException("can not support Set");
        } else {
            me meVar = new me();
            meVar.a(this.c);
            meVar.a(t, 0);
            this.e.put(str, mg.a(meVar.a()));
        }
    }

    public <T> T b(String str) {
        return a(str, true, null);
    }

    public <T> T a(String str, boolean z, ClassLoader classLoader) {
        if (this.e == null) {
            return super.a(str, z, classLoader);
        }
        throw new RuntimeException("data is encoded by new version, please use getByClass(String name, T proxy)");
    }

    public byte[] a() {
        if (this.e == null) {
            return super.a();
        }
        me meVar = new me(0);
        meVar.a(this.c);
        meVar.a(this.e, 0);
        return mg.a(meVar.a());
    }

    public void a(byte[] bArr) {
        try {
            super.a(bArr);
        } catch (Exception e) {
            this.f.a(bArr);
            this.f.a(this.c);
            Map hashMap = new HashMap(1);
            hashMap.put("", new byte[0]);
            this.e = this.f.a(hashMap, 0, false);
        }
    }
}
