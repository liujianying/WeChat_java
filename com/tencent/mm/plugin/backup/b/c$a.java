package com.tencent.mm.plugin.backup.b;

import com.tencent.mm.sdk.platformtools.ae;
import java.util.concurrent.atomic.AtomicLong;

class c$a {
    final /* synthetic */ c gSo;
    volatile AtomicLong gSp;
    ae gSq;
    ae gSr;

    private c$a(c cVar) {
        this.gSo = cVar;
        this.gSp = new AtomicLong(0);
        this.gSq = new ae(true);
        this.gSr = new ae(true);
    }

    /* synthetic */ c$a(c cVar, byte b) {
        this(cVar);
    }
}
