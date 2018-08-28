package com.tencent.mm.plugin.freewifi.d;

import com.tencent.mm.ab.b.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.protocal.c.aen;
import com.tencent.mm.protocal.c.aeo;

public final class g extends c {
    protected final void aOR() {
        a aVar = new a();
        aVar.dIG = new aen();
        aVar.dIH = new aeo();
        aVar.uri = "/cgi-bin/mmo2o-bin/getprotocol31schemaurl";
        aVar.dIF = 1746;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
    }

    public final int getType() {
        return 1746;
    }

    public g(String str, String str2, String str3) {
        aOR();
        aen aen = (aen) this.diG.dID.dIL;
        aen.jjP = str;
        aen.jjQ = str2;
        aen.jjR = str3;
        aen.qZw = m.aOi();
    }

    public final String aPb() {
        return ((aeo) this.diG.dIE.dIL).rIC;
    }
}
