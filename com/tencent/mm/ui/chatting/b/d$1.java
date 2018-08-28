package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.plugin.messenger.a.g;
import com.tencent.mm.pluginsdk.ui.applet.q.a;

class d$1 implements a {
    final /* synthetic */ String dMs;
    final /* synthetic */ String tOs;
    final /* synthetic */ boolean tOt;
    final /* synthetic */ d tOu;

    d$1(d dVar, String str, String str2, boolean z) {
        this.tOu = dVar;
        this.dMs = str;
        this.tOs = str2;
        this.tOt = z;
    }

    public final void a(boolean z, String str, int i) {
        this.tOu.bAG.YC();
        if (z) {
            g.bcT().l(this.dMs, this.tOs, this.tOt);
            g.bcT().dF(str, this.tOs);
        }
    }
}
