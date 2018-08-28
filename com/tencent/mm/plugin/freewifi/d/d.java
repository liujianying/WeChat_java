package com.tencent.mm.plugin.freewifi.d;

import com.tencent.mm.ab.b.a;
import com.tencent.mm.protocal.c.nz;
import com.tencent.mm.protocal.c.oa;

public final class d extends c {
    protected final void aOR() {
        a aVar = new a();
        aVar.dIG = new nz();
        aVar.dIH = new oa();
        aVar.uri = "/cgi-bin/mmo2o-bin/checkifcallup";
        aVar.dIF = 1155;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
    }

    public final int getType() {
        return 1155;
    }

    public d(String str, String str2, String str3, String str4, String str5, long j, String str6, String str7) {
        aOR();
        nz nzVar = (nz) this.diG.dID.dIL;
        nzVar.rsb = str;
        nzVar.rsc = str2;
        nzVar.rsd = str3;
        nzVar.rse = str4;
        nzVar.rsf = str5;
        nzVar.rsg = j;
        nzVar.rsh = str6;
        nzVar.rsi = str7;
    }

    public final oa aOZ() {
        return (oa) this.diG.dIE.dIL;
    }
}
