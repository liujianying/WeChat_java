package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.amw;
import com.tencent.mm.protocal.c.btw;
import com.tencent.mm.protocal.c.btx;
import com.tencent.mm.sdk.platformtools.x;

public final class n extends l implements k {
    public String byN = null;
    b diG = null;
    private e diJ = null;
    public int ivD = 0;

    public n(amw amw, String str, String str2, int i) {
        a aVar = new a();
        aVar.dIG = new btw();
        aVar.dIH = new btx();
        aVar.uri = "/cgi-bin/mmoc-bin/hardware/transfermsgtodevice";
        aVar.dIF = 1717;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        btw btw = (btw) this.diG.dID.dIL;
        btw.reT = str;
        btw.ruf = str2;
        btw.srn = amw;
        btw.sro = i;
        this.byN = str2;
        this.ivD = i;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.exdevice.NetSceneGetAppMsgInfo", "onGYNetEnd netId = " + i + " errType = " + i2 + " errCode = " + i3 + str);
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1717;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }
}
