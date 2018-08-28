package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;

public abstract class dq {
    private static dq a = null;

    public abstract byte[] a(String str, byte[] bArr, dn dnVar);

    public static synchronized dq a(Context context) {
        dq dqVar;
        synchronized (dq.class) {
            if (a == null && context != null) {
                a = new a(context);
            }
            dqVar = a;
        }
        return dqVar;
    }
}
