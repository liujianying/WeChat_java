package com.tencent.map.lib.util;

import java.util.HashMap;

public final class c<T, K> {
    private HashMap<T, K> a;
    private int b = 0;
    private int c = 1024;

    public final synchronized void a(T t, K k) {
        if (this.a == null) {
            this.a = new HashMap();
        }
        this.a.put(t, k);
    }

    public final synchronized K a(T t) {
        K k;
        if (this.a == null) {
            k = null;
        } else {
            k = this.a.get(t);
        }
        return k;
    }
}
