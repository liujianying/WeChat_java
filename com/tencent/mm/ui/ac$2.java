package com.tencent.mm.ui;

import android.os.Looper;

class ac$2 implements Runnable {
    final /* synthetic */ ac tpr;

    ac$2(ac acVar) {
        this.tpr = acVar;
    }

    public final void run() {
        Looper.myQueue().addIdleHandler(this.tpr.tpi);
    }
}
