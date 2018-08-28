package com.tencent.mm.plugin.freewifi.d;

import com.tencent.mm.ab.b.a;
import com.tencent.mm.protocal.c.bmc;
import com.tencent.mm.protocal.c.bmd;

public final class l extends c {
    protected final void aOR() {
        a aVar = new a();
        aVar.dIG = new bmc();
        aVar.dIH = new bmd();
        aVar.uri = "/cgi-bin/mmo2o-bin/setpcloginuserInfo";
        aVar.dIF = 1761;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
    }

    public final int getType() {
        return 1761;
    }

    public l(String str, int i, String str2) {
        aOR();
        bmc bmc = (bmc) this.diG.dID.dIL;
        bmc.appId = str;
        bmc.jnQ = i;
        bmc.bLe = str2;
    }
}
