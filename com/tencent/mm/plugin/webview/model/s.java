package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.awl;
import com.tencent.mm.protocal.c.awm;

public final class s extends l implements k {
    public final b diG;
    private e doG;
    public String pRt;
    public Object tag;

    public s(String str, String str2, int i) {
        a aVar = new a();
        aVar.dIG = new awl();
        aVar.dIH = new awm();
        aVar.uri = "/cgi-bin/mmbiz-bin/oauth_authorize";
        aVar.dIF = 1254;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.pRt = str;
        this.diG = aVar.KT();
        awl awl = (awl) this.diG.dID.dIL;
        awl.rZG = str;
        awl.rjm = str2;
        awl.scene = i;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        this.doG.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1254;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.doG = eVar2;
        return a(eVar, this.diG, this);
    }
}
