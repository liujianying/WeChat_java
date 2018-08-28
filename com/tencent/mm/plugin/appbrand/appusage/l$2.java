package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.l;
import com.tencent.mm.ab.v.a;
import com.tencent.mm.protocal.c.bvj;

class l$2 implements a {
    final /* synthetic */ String dhF;
    final /* synthetic */ int fmg;
    final /* synthetic */ l fmi;
    final /* synthetic */ l.a fmj;

    l$2(l lVar, l.a aVar, String str, int i) {
        this.fmi = lVar;
        this.fmj = aVar;
        this.dhF = str;
        this.fmg = i;
    }

    public final int a(int i, int i2, String str, b bVar, l lVar) {
        if (!(i == 0 && i2 == 0 && ((bvj) bVar.dIE.dIL).rrI.iwS == 0) && l.a(this.fmi).isOpen()) {
            l.b(this.fmi).a(this.fmj, false);
            if (this.fmi.aq(this.dhF, this.fmg)) {
                this.fmi.b("single", 2, this.fmj);
            }
        }
        return 0;
    }
}
