package com.tencent.mm.plugin.appbrand.page;

import android.os.Looper;
import com.tencent.mm.plugin.appbrand.page.u.4;

class p$3 implements v {
    final /* synthetic */ p gnH;

    p$3(p pVar) {
        this.gnH = pVar;
    }

    public final boolean alT() {
        if (this.gnH.fdO.aaw()) {
            return false;
        }
        u uVar = this.gnH.gnq;
        4 4 = new 4(uVar, Boolean.valueOf(false));
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            4.a(null);
        }
        4.a(uVar.mHandler);
        return true;
    }
}
