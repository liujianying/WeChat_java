package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.g.a.ps;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class SnsTimeLineUI$55 extends c<ps> {
    final /* synthetic */ SnsTimeLineUI odw;

    SnsTimeLineUI$55(SnsTimeLineUI snsTimeLineUI) {
        this.odw = snsTimeLineUI;
        this.sFo = ps.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ps psVar = (ps) bVar;
        if (SnsTimeLineUI.g(this.odw) != null) {
            com.tencent.mm.plugin.sns.h.b bVar2 = SnsTimeLineUI.g(this.odw).nLK.nrb;
            String str = psVar.cax.cay;
            bVar2.nwY.add(psVar.cax.bSZ);
            bVar2.nxg.add(str);
            bVar2.nvJ = bVar2.nxg.size();
        }
        return false;
    }
}
