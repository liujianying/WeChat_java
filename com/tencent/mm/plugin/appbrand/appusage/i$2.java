package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.v;
import com.tencent.mm.modelgeo.a$a;
import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.protocal.c.akn;
import com.tencent.mm.protocal.c.ako;

class i$2 implements a$a {
    final /* synthetic */ PBool flF;
    final /* synthetic */ PBool flG;
    private int flH = 0;

    i$2(PBool pBool, PBool pBool2) {
        this.flG = pBool;
        this.flF = pBool2;
    }

    public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
        c.az(this);
        com.tencent.mm.modelgeo.c.OB().c(this);
        int i2 = this.flH + 1;
        this.flH = i2;
        if (i2 > 1 || this.flG.value) {
            return false;
        }
        this.flF.value = true;
        if (z) {
            a aVar = new a();
            aVar.dIF = 1056;
            aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/getwxaappnearby";
            akn akn = new akn();
            akn.rNe = (double) f;
            akn.rNf = (double) f2;
            akn.rNh = !i.acR();
            aVar.dIG = akn;
            aVar.dIH = new ako();
            v.a(aVar.KT(), new 1(this), true);
            return false;
        }
        i.a(null);
        return false;
    }
}
