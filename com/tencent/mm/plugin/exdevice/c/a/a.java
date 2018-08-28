package com.tencent.mm.plugin.exdevice.c.a;

import com.tencent.mm.network.q;
import com.tencent.mm.plugin.exdevice.a.b;
import com.tencent.mm.protocal.c.px;
import com.tencent.mm.protocal.c.py;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;

public final class a extends com.tencent.mm.plugin.exdevice.a.a<px, py> {
    String appId;
    String bKv;
    String byN;
    String isU;
    private WeakReference<b<a>> isV;

    protected final /* synthetic */ com.tencent.mm.bk.a aGw() {
        return new px();
    }

    protected final /* synthetic */ com.tencent.mm.bk.a aGx() {
        return new py();
    }

    protected final /* bridge */ /* synthetic */ void g(com.tencent.mm.bk.a aVar) {
        px pxVar = (px) aVar;
        pxVar.ruf = this.byN;
        pxVar.reT = this.bKv;
        pxVar.rug = this.isU;
        pxVar.jQb = this.appId;
    }

    public a(String str, String str2, String str3, String str4, b<a> bVar) {
        this.byN = bi.oV(str);
        this.bKv = bi.oV(str2);
        this.isU = bi.oV(str3);
        this.appId = bi.oV(str4);
        this.isV = new WeakReference(bVar);
    }

    public final int getType() {
        return 1799;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneConnectedRouter", "ap: connected router end. errType: %d, errCode: %d, errMsg: %s, resp: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, qVar.toString()});
        super.a(i, i2, i3, str, qVar, bArr);
        b bVar = (b) this.isV.get();
        if (bVar != null) {
            bVar.b(i2, i3, str, this);
        }
    }

    protected final String getUri() {
        return "/cgi-bin/mmoc-bin/hardware/mydevice/connectedrouter";
    }
}
