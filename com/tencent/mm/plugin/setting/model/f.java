package com.tencent.mm.plugin.setting.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.protocal.c.aiy;
import com.tencent.mm.protocal.c.aiz;

public final class f extends l implements k {
    private e diJ;
    public aiz mOJ;
    public byte[] mOK;

    public f(byte[] bArr) {
        this.mOK = bArr;
    }

    public final int getType() {
        return 1146;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        a aVar = new a();
        aiy aiy = new aiy();
        if (this.mOK != null) {
            aiy.rLH = ab.O(this.mOK).siK;
        }
        aVar.dIG = aiy;
        this.mOJ = new aiz();
        aVar.dIH = this.mOJ;
        aVar.uri = "/cgi-bin/mmbiz-bin/getuserauthlist";
        aVar.dIF = 1146;
        aVar.dII = 0;
        aVar.dIJ = 0;
        return a(eVar, aVar.KT(), this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        this.mOJ = (aiz) ((b) qVar).dIE.dIL;
        if (this.mOJ.rvs != null) {
            i3 = this.mOJ.rvs.bMH;
            str = this.mOJ.rvs.bMI;
        }
        this.diJ.a(i2, i3, str, this);
    }
}
