package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import android.app.Activity;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.ui.j;

class b$1 implements Runnable {
    final /* synthetic */ l fCl;
    final /* synthetic */ b fVA;

    b$1(b bVar, l lVar) {
        this.fVA = bVar;
        this.fCl = lVar;
    }

    public final void run() {
        this.fCl.fdO.finish();
        Activity cJ = j.cJ(this.fCl.getContext());
        if (cJ != null && !cJ.isFinishing()) {
            cJ.moveTaskToBack(true);
        }
    }
}
