package com.tencent.mm.ipcinvoker;

import android.os.HandlerThread;
import com.tencent.mm.ipcinvoker.h.b;

class l$1 implements Runnable {
    final /* synthetic */ HandlerThread dmO;
    final /* synthetic */ l dmP;

    l$1(l lVar, HandlerThread handlerThread) {
        this.dmP = lVar;
        this.dmO = handlerThread;
    }

    public final void run() {
        b.i("IPC.ThreadPool", "createHandlerThread(id : %d)", new Object[]{Integer.valueOf(this.dmO.getThreadId())});
    }
}
