package com.tencent.mm.plugin.freewifi.d;

import com.tencent.mm.ab.b.a;
import com.tencent.mm.protocal.c.agi;
import com.tencent.mm.protocal.c.agj;
import com.tencent.mm.protocal.c.xq;

public final class h extends c {
    protected final void aOR() {
        a aVar = new a();
        aVar.dIG = new agi();
        aVar.dIH = new agj();
        aVar.uri = "/cgi-bin/mmo2o-bin/getpcfrontpage";
        aVar.dIF = 1760;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
    }

    public final int getType() {
        return 1760;
    }

    public h(String str, int i, String str2) {
        aOR();
        agi agi = (agi) this.diG.dID.dIL;
        agi.appId = str;
        agi.jnQ = i;
        agi.bLe = str2;
    }

    public final xq aOV() {
        agj agj = (agj) this.diG.dIE.dIL;
        if (agj != null) {
            return agj.qZq;
        }
        return null;
    }
}
