package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bts;
import com.tencent.mm.protocal.c.btt;
import com.tencent.mm.sdk.platformtools.x;

public final class w extends l implements k {
    public final b diG;
    private e doG;

    public w(String str, String str2) {
        a aVar = new a();
        aVar.dIG = new bts();
        aVar.dIH = new btt();
        aVar.uri = "/cgi-bin/mmbiz-bin/transid";
        aVar.dIF = 1142;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        bts bts = (bts) this.diG.dID.dIL;
        bts.bPS = str;
        bts.srl = str2;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneSendAppMsgToSpecifiedContact", "errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.doG.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1142;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.i("MicroMsg.NetSceneSendAppMsgToSpecifiedContact", "doScene");
        this.doG = eVar2;
        return a(eVar, this.diG, this);
    }
}
