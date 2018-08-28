package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.mm.ab.a;
import com.tencent.mm.ab.b;
import com.tencent.mm.protocal.c.akt;
import com.tencent.mm.protocal.c.aku;

class r extends a<aku> {
    r(int i, int i2, int i3, int i4) {
        b.a aVar = new b.a();
        akt akt = new akt();
        akt.aAk = i;
        akt.condition = i2;
        akt.rNG = i3;
        akt.rNH = i4;
        aVar.dIG = akt;
        aVar.dIH = new aku();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/getwxausagerecord";
        aVar.dIF = 1148;
        this.diG = aVar.KT();
    }
}
