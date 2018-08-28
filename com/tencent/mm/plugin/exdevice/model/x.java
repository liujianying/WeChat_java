package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.protocal.c.alx;
import com.tencent.mm.protocal.c.bul;
import com.tencent.mm.protocal.c.bum;

public final class x extends l implements k {
    private b diG;
    private e diJ;
    public alx ivH;

    public x(alx alx, int i) {
        this.ivH = alx;
        a aVar = new a();
        aVar.dIG = new bul();
        aVar.dIH = new bum();
        aVar.dIF = 537;
        aVar.uri = "/cgi-bin/micromsg-bin/unbindharddevice";
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        bul bul = (bul) this.diG.dID.dIL;
        bul.rhk = alx;
        bul.rbZ = i;
    }

    public final int getType() {
        return 537;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.exdevice.NetSceneUnBindHardDevice", "onGYNetEnd netId = %d, errType= %d, errCode = %d , errMsg =%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        i iVar = i.ivn;
        i.cH(0);
        com.tencent.mm.plugin.exdevice.h.b Al = ad.aHe().Al(this.ivH.hbO);
        if (Al != null) {
            if (!(u.aHG().isY == null || u.aHG().isY.cT(Al.field_mac))) {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.exdevice.NetSceneUnBindHardDevice", "stopChannel Failed!!!");
            }
            if (!ad.aHe().cB(this.ivH.hbO, this.ivH.reT)) {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.exdevice.NetSceneUnBindHardDevice", "deleteByDeviceId Failed!!!");
            }
        } else {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.exdevice.NetSceneUnBindHardDevice", "getByDeviceIdServer Failed!!! DeviceIDServer = %s", new Object[]{this.ivH.hbO});
        }
        if (!(i2 == 0 && i3 == 0)) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.exdevice.NetSceneUnBindHardDevice", "scene.getType() = %s", new Object[]{Integer.valueOf(537)});
        }
        bum bum = (this.diG == null || this.diG.dIE.dIL == null) ? null : (bum) this.diG.dIE.dIL;
        if (bum == null) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.exdevice.NetSceneUnBindHardDevice", "UnbindHardDevice resp or req is null");
        }
        this.diJ.a(i2, i3, str, this);
    }
}
