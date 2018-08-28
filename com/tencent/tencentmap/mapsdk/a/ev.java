package com.tencent.tencentmap.mapsdk.a;

public class ev {
    private static eu a = null;

    public static synchronized eu a() {
        eu euVar;
        synchronized (ev.class) {
            if (a == null) {
                a = new ez();
            }
            euVar = a;
        }
        return euVar;
    }
}
