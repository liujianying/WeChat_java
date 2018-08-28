package com.google.android.gms.analytics.internal;

import java.util.concurrent.Callable;

class y$1 implements Callable<String> {
    final /* synthetic */ y aGZ;

    y$1(y yVar) {
        this.aGZ = yVar;
    }

    public final /* synthetic */ Object call() {
        y yVar = this.aGZ;
        String ad = yVar.ad(yVar.aFn.ns().mContext);
        return ad == null ? yVar.nR() : ad;
    }
}
