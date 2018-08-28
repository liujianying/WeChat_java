package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.g.a.py;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class SnsTimeLineUI$8 extends c<py> {
    final /* synthetic */ SnsTimeLineUI odw;

    SnsTimeLineUI$8(SnsTimeLineUI snsTimeLineUI) {
        this.odw = snsTimeLineUI;
        this.sFo = py.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        py pyVar = (py) bVar;
        if (!(SnsTimeLineUI.g(this.odw) == null || SnsTimeLineUI.g(this.odw).nLK == null)) {
            com.tencent.mm.plugin.sns.h.b bVar2 = SnsTimeLineUI.g(this.odw).nLK.nrb;
            bVar2.nxd.add(pyVar.caE.bSZ);
        }
        return false;
    }
}
