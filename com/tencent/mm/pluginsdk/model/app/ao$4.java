package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.g.a.cm;
import com.tencent.mm.g.a.ct;
import com.tencent.mm.k.g;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;

class ao$4 extends c<cm> {
    final /* synthetic */ ao qAR;

    ao$4(ao aoVar) {
        this.qAR = aoVar;
        this.sFo = cm.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        int i = bi.getInt(g.AT().getValue("AndroidUseUnicodeEmoji"), 0);
        ct ctVar = new ct();
        ctVar.bKh.bKi = i;
        a.sFg.m(ctVar);
        return false;
    }
}
