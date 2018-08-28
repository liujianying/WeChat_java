package com.tencent.mm.aw;

import android.os.Looper;
import android.os.MessageQueue.IdleHandler;

class e$2 implements Runnable {
    final /* synthetic */ e ehE;

    e$2(e eVar) {
        this.ehE = eVar;
    }

    public final void run() {
        Looper.myQueue().addIdleHandler(new IdleHandler() {
            public final boolean queueIdle() {
                e$2.this.ehE.b(new 1(this));
                return false;
            }
        });
    }
}
