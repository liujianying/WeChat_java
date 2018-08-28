package com.tencent.mm.plugin.sight.decode.a;

import android.view.View;

class b$d implements Runnable {
    final /* synthetic */ b ncT;

    private b$d(b bVar) {
        this.ncT = bVar;
    }

    /* synthetic */ b$d(b bVar, byte b) {
        this(bVar);
    }

    public final void run() {
        if (b.k(this.ncT).get() != null) {
            ((View) b.k(this.ncT).get()).startAnimation(b.l(this.ncT));
        }
    }
}
