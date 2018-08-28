package com.tencent.mm.d;

import android.os.Handler;
import android.os.Looper;
import java.util.TimerTask;

class e$a extends TimerTask {
    private b bCA;
    final /* synthetic */ e bCB;
    private Handler mHandler = new Handler(Looper.getMainLooper());

    public e$a(e eVar, b bVar) {
        this.bCB = eVar;
        this.bCA = bVar;
    }

    public final void run() {
        this.mHandler.post(new 1(this));
    }
}
