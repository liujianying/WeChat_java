package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.l;
import com.tencent.mm.ab.v.a;
import com.tencent.mm.protocal.c.bvj;

class l$1 implements a {
    final /* synthetic */ String dhF;
    final /* synthetic */ int fmg;
    final /* synthetic */ long fmh;
    final /* synthetic */ l fmi;

    public l$1(l lVar, String str, int i, long j) {
        this.fmi = lVar;
        this.dhF = str;
        this.fmg = i;
        this.fmh = j;
    }

    public final int a(int i, int i2, String str, b bVar, l lVar) {
        if (!(i == 0 && i2 == 0 && ((bvj) bVar.dIE.dIL).rrI.iwS == 0) && l.a(this.fmi).isOpen()) {
            l.a aVar = new l.a();
            aVar.field_username = this.dhF;
            aVar.field_versionType = this.fmg;
            aVar.field_updateTime = this.fmh;
            l.b(this.fmi).a(aVar, false, new String[]{"updateTime", "username", "versionType"});
            if (!this.fmi.aq(this.dhF, this.fmg)) {
                this.fmi.b("single", 3, aVar);
            }
        }
        return 0;
    }
}
