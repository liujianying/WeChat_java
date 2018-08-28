package com.google.android.gms.analytics.internal;

import com.google.android.gms.c.v;
import com.google.android.gms.common.internal.w;

final class j {
    private final v aFC;
    long aFD;

    public j(v vVar) {
        w.ah(vVar);
        this.aFC = vVar;
    }

    public j(v vVar, long j) {
        w.ah(vVar);
        this.aFC = vVar;
        this.aFD = j;
    }

    public final boolean Y(long j) {
        return this.aFD == 0 || this.aFC.elapsedRealtime() - this.aFD > j;
    }

    public final void start() {
        this.aFD = this.aFC.elapsedRealtime();
    }
}
