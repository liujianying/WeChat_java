package com.tencent.mm.plugin.extqlauncher;

import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

class b$1 implements b {
    final /* synthetic */ b iLM;

    b$1(b bVar) {
        this.iLM = bVar;
    }

    public final void a(int i, m mVar, Object obj) {
        x.d("MicroMsg.SubCoreExtQLauncher", "onNotifyChange");
        if (!this.iLM.iLD) {
            au.HU();
            if (mVar != c.FW()) {
                return;
            }
            if (mVar == null || obj == null) {
                x.e("MicroMsg.SubCoreExtQLauncher", "onConversationChange, wrong args");
            } else if (ad.getContext() == null || !au.HX()) {
                x.w("MicroMsg.SubCoreExtQLauncher", "wrong account status");
            } else {
                this.iLM.aJn();
            }
        }
    }
}
