package com.tencent.mm.plugin.ipcall.a.f;

import com.tencent.mm.model.au;
import com.tencent.mm.plugin.ipcall.a.d.g;

public final class b {
    private static b ksn;
    private g kso;

    public static b aXT() {
        if (ksn == null) {
            ksn = new b();
        }
        return ksn;
    }

    public final void fY(boolean z) {
        au.DF().c(this.kso);
        this.kso = null;
        if (z) {
            this.kso = new g(1);
        } else {
            this.kso = new g(0);
        }
        au.DF().a(this.kso, 0);
    }
}
