package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.biq;
import com.tencent.mm.protocal.c.bir;
import java.util.LinkedList;

public final class v extends l implements k {
    public final b diG;
    private e doG;

    public v(int i, String str, String str2, String str3, LinkedList<String> linkedList) {
        a aVar = new a();
        aVar.dIG = new biq();
        aVar.dIH = new bir();
        aVar.uri = "/cgi-bin/mmbiz-bin/sdk_oauth_authorize_confirm ";
        aVar.dIF = 1346;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        biq biq = (biq) this.diG.dID.dIL;
        biq.rZH = i;
        biq.bPS = str;
        biq.rZI = linkedList;
        biq.state = str2;
        biq.sjf = str3;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        this.doG.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1346;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.doG = eVar2;
        return a(eVar, this.diG, this);
    }
}
