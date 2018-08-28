package com.tencent.mm.by;

import android.os.Looper;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.vending.h.a;

public final class d implements a {
    private ag mHandler;

    public d(ag agVar) {
        this.mHandler = agVar;
    }

    public static d b(ag agVar) {
        return new d(agVar);
    }

    public final void j(Runnable runnable) {
        this.mHandler.post(runnable);
    }

    public final void k(Runnable runnable, long j) {
        this.mHandler.postDelayed(runnable, j);
    }

    public final Looper getLooper() {
        return this.mHandler.getLooper();
    }

    public final void cA() {
        this.mHandler.removeCallbacksAndMessages(null);
    }
}
