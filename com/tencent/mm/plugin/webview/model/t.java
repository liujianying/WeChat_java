package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.awj;
import com.tencent.mm.protocal.c.awk;
import java.util.LinkedList;

public final class t extends l implements k {
    public final b diG;
    private e doG;
    public Object tag;

    public t(String str, int i, LinkedList<String> linkedList) {
        a aVar = new a();
        aVar.dIG = new awj();
        aVar.dIH = new awk();
        aVar.uri = "/cgi-bin/mmbiz-bin/oauth_authorize_confirm";
        aVar.dIF = 1373;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        awj awj = (awj) this.diG.dID.dIL;
        awj.rZG = str;
        awj.rZH = i;
        awj.rZI = linkedList;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        this.doG.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1373;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.doG = eVar2;
        return a(eVar, this.diG, this);
    }
}
