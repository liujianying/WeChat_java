package com.tencent.mm.plugin.appbrand.launching.precondition;

import android.os.Looper;

class b$4 implements Runnable {
    final /* synthetic */ b ghq;

    b$4(b bVar) {
        this.ghq = bVar;
    }

    public final void run() {
        Looper.myLooper().quit();
    }
}
