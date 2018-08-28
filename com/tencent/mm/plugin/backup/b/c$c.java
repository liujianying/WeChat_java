package com.tencent.mm.plugin.backup.b;

import com.tencent.mm.plugin.backup.b.c.b;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.concurrent.LinkedBlockingQueue;

class c$c {
    LinkedBlockingQueue<Object> gSN = new LinkedBlockingQueue();
    ae gSO = new ae();
    b gSP = null;
    private Runnable gSQ = new 1(this);
    final /* synthetic */ c gSo;
    c$a gSt = new c$a(this.gSo, (byte) 0);

    public c$c(c cVar) {
        this.gSo = cVar;
        e.b(this.gSQ, "tagRunnable").start();
    }
}
