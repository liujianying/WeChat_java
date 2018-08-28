package com.tencent.mm.plugin.appbrand.dynamic.h;

import android.content.Context;
import com.tencent.mm.u.c.e;

class e$1 implements Runnable {
    final /* synthetic */ Context val$context;

    e$1(Context context) {
        this.val$context = context;
    }

    public final void run() {
        synchronized (e.class) {
            if (e.afw() != null) {
                return;
            }
            e b = e.b(e.afx());
            synchronized (e.class) {
                e.a(b);
            }
        }
    }
}
