package com.tencent.mm.plugin.record.b;

import android.os.SystemClock;

final class c$a {
    int ewn;
    final /* synthetic */ c mrU;
    long mrV;

    private c$a(c cVar) {
        this.mrU = cVar;
        this.mrV = SystemClock.elapsedRealtime();
        this.ewn = this.mrU.mrP;
    }

    /* synthetic */ c$a(c cVar, byte b) {
        this(cVar);
    }
}
