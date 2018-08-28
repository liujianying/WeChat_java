package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.ab.a;
import com.tencent.mm.protocal.c.akl;
import com.tencent.mm.protocal.c.akm;

public final class b extends a<akm> {
    public final com.tencent.mm.ab.b diG;

    public b(String str, int i, String str2, int i2, int i3) {
        akl akl = new akl();
        akl.rkb = i;
        akl.bPS = str;
        akl.rMZ = str2;
        akl.rNa = i2;
        akl.rNb = i3;
        this(akl);
    }

    public b(akl akl) {
        com.tencent.mm.ab.b.a aVar = new com.tencent.mm.ab.b.a();
        aVar.dIF = 1139;
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/getwxacdndownloadurl";
        aVar.dIG = akl;
        aVar.dIH = new akm();
        com.tencent.mm.ab.b KT = aVar.KT();
        this.diG = KT;
        this.diG = KT;
    }

    public b(String str, int i, String str2, int i2) {
        this(str, i, str2, i2, 0);
    }
}
