package com.tencent.mm.plugin.freewifi.d;

import com.tencent.mm.ab.b.a;
import com.tencent.mm.protocal.c.agm;
import com.tencent.mm.protocal.c.agn;

public final class i extends c {
    protected final void aOR() {
        a aVar = new a();
        aVar.dIG = new agm();
        aVar.dIH = new agn();
        aVar.uri = "/cgi-bin/mmo2o-bin/getportalapinfo";
        aVar.dIF = 1709;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
    }

    public final int getType() {
        return 1709;
    }

    public i(String str, String str2, String str3, String str4, String str5, String str6) {
        aOR();
        agm agm = (agm) this.diG.dID.dIL;
        agm.bIQ = str;
        agm.jjP = str2;
        agm.jjQ = str3;
        agm.jjR = str4;
        agm.bLe = str5;
        agm.qZf = str6;
    }

    public final String aPc() {
        return ((agn) this.diG.dIE.dIL).jkX;
    }

    public final String aPd() {
        return ((agn) this.diG.dIE.dIL).jkY;
    }
}
