package com.tencent.mm.plugin.exdevice.f.a;

import com.tencent.mm.network.q;
import com.tencent.mm.plugin.exdevice.a.a;
import com.tencent.mm.plugin.exdevice.a.b;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.protocal.c.rf;
import com.tencent.mm.protocal.c.rg;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;

public final class h extends a<rf, rg> {
    private final WeakReference<b<h>> isV;
    String username;

    protected final /* synthetic */ com.tencent.mm.bk.a aGw() {
        return new rf();
    }

    protected final /* synthetic */ com.tencent.mm.bk.a aGx() {
        return new rg();
    }

    protected final /* bridge */ /* synthetic */ void g(com.tencent.mm.bk.a aVar) {
        ((rf) aVar).rvn = this.username;
    }

    public h(String str, b<h> bVar) {
        this.username = str;
        this.isV = new WeakReference(bVar);
    }

    public final int getType() {
        return 1792;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneDelFollow", "hy: del follow end. errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        super.a(i, i2, i3, str, qVar, bArr);
        if (i2 == 0 && i3 == 0) {
            ad.aHg().Ag(this.username);
        }
        b bVar = (b) this.isV.get();
        if (bVar != null) {
            bVar.b(i2, i3, str, this);
        }
    }

    protected final String getUri() {
        return "/cgi-bin/mmoc-bin/hardware/delfollow";
    }
}
