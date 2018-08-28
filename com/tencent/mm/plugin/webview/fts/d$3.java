package com.tencent.mm.plugin.webview.fts;

import com.tencent.mm.an.b;
import com.tencent.mm.g.a.jt;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.h;
import com.tencent.mm.protocal.c.avq;
import com.tencent.mm.sdk.b.c;

class d$3 extends c<jt> {
    final /* synthetic */ d pOF;

    d$3(d dVar) {
        this.pOF = dVar;
        this.sFo = jt.class.getName().hashCode();
    }

    private boolean a(jt jtVar) {
        avq avq = jtVar.bTE.bTy;
        if (avq != null && b.d(avq)) {
            switch (jtVar.bTE.action) {
                case 0:
                case 1:
                    for (Integer intValue : this.pOF.pOv) {
                        h.Bh(intValue.intValue()).cJ(avq.rsp, 1);
                    }
                    break;
                case 2:
                case 3:
                case 4:
                    for (Integer intValue2 : this.pOF.pOv) {
                        h.Bh(intValue2.intValue()).cJ(avq.rsp, 0);
                    }
                    break;
            }
        }
        return false;
    }
}
