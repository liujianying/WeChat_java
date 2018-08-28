package com.google.android.gms.analytics.internal;

import com.google.android.gms.analytics.b;

@Deprecated
public final class e {
    private static volatile b aFi = new ad();

    public static void c(String str, Object obj) {
        Object obj2 = null;
        f mM = f.mM();
        if (mM != null) {
            mM.g(str, obj);
        } else {
            if (aFi != null && aFi.getLogLevel() <= 3) {
                obj2 = 1;
            }
            if (obj2 != null) {
                if (obj != null) {
                    new StringBuilder().append(str).append(":").append(obj);
                }
                aj.aHt.get();
            }
        }
        b bVar = aFi;
    }

    public static b mL() {
        return aFi;
    }
}
