package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ame;
import com.tencent.mm.protocal.c.amf;
import com.tencent.mm.protocal.c.fl;
import com.tencent.mm.sdk.platformtools.x;

public final class s extends l implements k {
    private e doG = null;
    private String ius = null;
    private b ivF = null;

    public s(String str, String str2, String str3, int i) {
        a aVar = new a();
        aVar.dIG = new ame();
        aVar.dIH = new amf();
        aVar.uri = "/cgi-bin/mmbiz-bin/device/subscribestatus";
        aVar.dIF = 1090;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.ivF = aVar.KT();
        ame ame = (ame) this.ivF.dID.dIL;
        ame.rgu = com.tencent.mm.bk.b.Uw(str2);
        ame.rgs = com.tencent.mm.bk.b.Uw(str3);
        ame.jRb = i;
        this.ius = str;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.exdevice.NetSceneHardDeviceStatusSubscribe", "onGYNetEnd netId = " + i + " errType = " + i2 + " errCode = " + i3 + str);
        ad.aHe().Al(this.ius);
        if (i2 == 0 && i3 == 0) {
            fl flVar = ((amf) this.ivF.dIE.dIL).six;
            int i4 = flVar.rfn;
            if (flVar.rgv.siN) {
                String str2 = flVar.rgv.siM;
            }
            x.i("MicroMsg.exdevice.NetSceneHardDeviceStatusSubscribe", "HardDeviceStatusSubResponse: ret=" + i4 + ",msg=" + str);
        }
        this.doG.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1090;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.doG = eVar2;
        return a(eVar, this.ivF, this);
    }
}
