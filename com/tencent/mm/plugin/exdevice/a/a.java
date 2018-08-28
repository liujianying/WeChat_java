package com.tencent.mm.plugin.exdevice.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.sdk.platformtools.x;

public abstract class a<RequestType extends com.tencent.mm.bk.a, ResponseType extends com.tencent.mm.bk.a> extends l implements k {
    private e doG;
    protected b isw;

    public abstract RequestType aGw();

    public abstract ResponseType aGx();

    public abstract String getUri();

    public void g(RequestType requestType) {
    }

    public final ResponseType asj() {
        if (this.isw == null || this.isw.dIE.dIL == null) {
            return null;
        }
        return this.isw.dIE.dIL;
    }

    public void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.BaseNetScene", "onGYNetEnd netId %d, errType %d, errCode %d, errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (this.doG != null) {
            this.doG.a(i2, i3, str, this);
        }
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.doG = eVar2;
        if (this.isw == null) {
            com.tencent.mm.ab.b.a aVar = new com.tencent.mm.ab.b.a();
            aVar.dIF = getType();
            aVar.uri = getUri();
            aVar.dIG = aGw();
            aVar.dIH = aGx();
            aVar.dII = 0;
            aVar.dIJ = 0;
            this.isw = aVar.KT();
            g(this.isw.dID.dIL);
        }
        return a(eVar, this.isw, this);
    }
}
