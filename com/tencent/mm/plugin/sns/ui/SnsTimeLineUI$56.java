package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.g.a.qg;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class SnsTimeLineUI$56 extends c<qg> {
    final /* synthetic */ SnsTimeLineUI odw;

    SnsTimeLineUI$56(SnsTimeLineUI snsTimeLineUI) {
        this.odw = snsTimeLineUI;
        this.sFo = qg.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        qg qgVar = (qg) bVar;
        if (SnsTimeLineUI.g(this.odw) != null) {
            com.tencent.mm.plugin.sns.h.b bVar2;
            if (qgVar.caP.caQ) {
                bVar2 = SnsTimeLineUI.g(this.odw).nLK.nrb;
                bVar2.nxi.add(qgVar.caP.username);
                bVar2.nvL = bVar2.nxi.size();
            } else {
                bVar2 = SnsTimeLineUI.g(this.odw).nLK.nrb;
                bVar2.nxj.add(qgVar.caP.username);
                bVar2.nvM = bVar2.nxj.size();
            }
        }
        return false;
    }
}
