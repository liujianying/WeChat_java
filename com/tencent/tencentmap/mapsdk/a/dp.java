package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;

public final class dp extends dn {
    public dp(Context context) {
        super(context, 0, 100);
    }

    public final void b(boolean z) {
    }

    public final cn a() {
        try {
            cn a = e.a(c(), c.m(), "".getBytes(), -1, -1);
            return a != null ? a : null;
        } catch (Throwable th) {
            ct.a(th);
            ct.d("encode2RequestPackage failed", new Object[0]);
            return null;
        }
    }
}
