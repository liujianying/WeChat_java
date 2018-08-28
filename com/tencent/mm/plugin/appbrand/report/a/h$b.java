package com.tencent.mm.plugin.appbrand.report.a;

import android.support.v4.e.i.a;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

final class h$b implements a<h.a> {
    private final Queue<h.a> grD;

    private h$b() {
        this.grD = new ConcurrentLinkedQueue();
    }

    /* synthetic */ h$b(byte b) {
        this();
    }

    /* renamed from: amO */
    public final h.a bW() {
        h.a aVar = (h.a) this.grD.poll();
        return aVar == null ? new h.a((byte) 0) : aVar;
    }

    /* renamed from: a */
    public final boolean j(h.a aVar) {
        return this.grD.offer(aVar);
    }
}
