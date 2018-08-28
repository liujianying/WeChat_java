package com.tencent.mm.plugin.scanner.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.id;
import com.tencent.mm.protocal.c.ie;
import com.tencent.mm.sdk.platformtools.x;

public final class d extends l implements k {
    private String bKk;
    public b diG;
    private e diJ;
    private String hWu;
    private int scene;

    public d(String str, int i, String str2) {
        this.bKk = str;
        this.scene = i;
        this.hWu = str2;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        a aVar = new a();
        aVar.dIG = new id();
        aVar.dIH = new ie();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/bizscangetproductinfo";
        aVar.dIF = 1063;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        id idVar = (id) this.diG.dID.dIL;
        idVar.rem = this.bKk;
        idVar.otY = this.scene;
        idVar.rjh = this.hWu;
        return a(eVar, this.diG, this);
    }

    protected final int a(q qVar) {
        id idVar = (id) ((b) qVar).dID.dIL;
        if (idVar.otY >= 0 && idVar.rem != null && idVar.rem.length() > 0) {
            return l.b.dJm;
        }
        x.e("MicroMsg.scanner.NetSceneGetProductInfo", "ERR: Security Check Failed, Scene = %s", new Object[]{Integer.valueOf(idVar.otY)});
        return l.b.dJn;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.scanner.NetSceneGetProductInfo", "onGYNetEnd errtype:" + i2 + " errcode:" + i3 + " errMsg:" + str);
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1063;
    }
}
