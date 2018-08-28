package com.tencent.mm.app;

import android.os.HandlerThread;
import android.os.Process;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.h.d;
import com.tencent.mm.vending.h.h;

public final class i {
    static i byx;
    HandlerThread byy;
    d byz;
    ag handler = new ag(this.byy.getLooper());

    public i(String str) {
        this.byy = e.cZ(str, 10);
        this.byy.start();
        this.byz = new h(com.tencent.mm.by.d.b(this.handler), str);
    }

    public final void uW() {
        if (this.byy == null || !this.byy.isAlive()) {
            x.e("MicroMsg.InitThreadController", "setHighPriority failed thread is dead");
            return;
        }
        int threadId = this.byy.getThreadId();
        try {
            if (-8 == Process.getThreadPriority(threadId)) {
                x.w("MicroMsg.InitThreadController", "setHighPriority No Need.");
                return;
            }
            Process.setThreadPriority(threadId, -8);
            x.i("MicroMsg.InitThreadController", "InitThreadController:%d setHighPriority to %d", new Object[]{Integer.valueOf(threadId), Integer.valueOf(Process.getThreadPriority(threadId))});
        } catch (Throwable e) {
            x.w("MicroMsg.InitThreadController", "thread:%d setHighPriority failed", new Object[]{Integer.valueOf(threadId)});
            x.printErrStackTrace("MicroMsg.InitThreadController", e, "", new Object[0]);
        }
    }
}
