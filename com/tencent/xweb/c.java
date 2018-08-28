package com.tencent.xweb;

import android.content.Context;
import com.tencent.xweb.c.b.b;

public final class c {
    private static c vzW;
    static b vzX;

    public static synchronized c ij(Context context) {
        c cVar;
        synchronized (c.class) {
            if (vzW == null) {
                vzW = new c(context.getApplicationContext());
            }
            cVar = vzW;
        }
        return cVar;
    }

    public static synchronized c cIk() {
        c cVar;
        synchronized (c.class) {
            if (vzW == null) {
                throw new IllegalStateException("CookieSyncManager::createInstance() needs to be called before CookieSyncManager::getInstance()");
            }
            cVar = vzW;
        }
        return cVar;
    }

    private c(Context context) {
        if (vzX != null) {
            vzX.init(context);
        }
    }

    public static void sync() {
        if (vzX != null) {
            vzX.sync();
        }
    }
}
