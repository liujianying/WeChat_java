package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.protocal.c.bhz;
import com.tencent.mm.protocal.c.cas;
import com.tencent.mm.protocal.c.cat;
import com.tencent.mm.protocal.c.cau;

public final class l extends n<cat, cau> {
    public l(String str, String str2, String str3, String str4, String str5) {
        a aVar = new a();
        aVar.dIG = new cat();
        aVar.dIH = new cau();
        aVar.uri = "/cgi-bin/micromsg-bin/voipstatreport";
        aVar.dIF = 320;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        cat cat = (cat) this.diG.dID.dIL;
        cas cas = new cas();
        bhz bhz = new bhz();
        bhz.VO(str);
        cas.spT = bhz;
        cas cas2 = new cas();
        bhz bhz2 = new bhz();
        bhz2.VO(str2);
        cas2.spT = bhz2;
        cas cas3 = new cas();
        bhz bhz3 = new bhz();
        bhz3.VO(str3);
        cas3.spT = bhz3;
        cas cas4 = new cas();
        bhz bhz4 = new bhz();
        bhz4.VO(str4);
        cas4.spT = bhz4;
        cas cas5 = new cas();
        bhz bhz5 = new bhz();
        bhz5.VO(str5);
        cas5.spT = bhz5;
        cat.svJ = cas;
        cat.sxe = cas2;
        cat.sxd = cas3;
        cat.sxf = cas4;
        cat.sxg = cas5;
    }

    public final int getType() {
        return 320;
    }

    public final e bLm() {
        return new 1(this);
    }
}
