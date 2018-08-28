package com.tencent.mm.wallet_core.f;

import java.util.WeakHashMap;

public final class a {
    public WeakHashMap<Object, Boolean> uXQ = new WeakHashMap();

    public static synchronized a cDt() {
        a aVar;
        synchronized (a.class) {
            aVar = a.uXR;
        }
        return aVar;
    }
}
