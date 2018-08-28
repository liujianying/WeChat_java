package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.alx;
import com.tencent.mm.protocal.c.hk;
import com.tencent.mm.protocal.c.hl;
import com.tencent.mm.sdk.platformtools.x;

public final class m extends l implements k {
    private b diG;
    private e diJ;
    private long ivA;
    private String ivB;
    private long ivC;
    private String ivz;

    public m(long j, String str, String str2, long j2) {
        this.ivA = j;
        this.ivB = str;
        this.ivz = str2;
        this.ivC = j2;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneBindUnauthDevice", "onGYNetEnd netId = " + i + " errType = " + i2 + " errCode = " + i3 + str);
        if (i2 == 0 && i3 == 0) {
            Object obj;
            hl hlVar = (hl) this.diG.dIE.dIL;
            alx alx = hlVar.rhk;
            String str2 = null;
            String str3 = null;
            if (alx != null) {
                str2 = alx.hbO;
                str3 = alx.reT;
            }
            x.d("MicroMsg.NetSceneBindUnauthDevice", "unauth bind deviceId = %s, deviceType = %s", new Object[]{str2, str3});
            if (ad.aHe().cA(str3, str2) != null) {
                x.i("MicroMsg.NetSceneBindUnauthDevice", "delete local deviceinfo : %s, ret : %b", new Object[]{str3, Boolean.valueOf(ad.aHe().cB(str2, str3))});
                if (ad.aHe().cB(str2, str3)) {
                    obj = 1;
                } else {
                    obj = null;
                }
            } else {
                obj = 1;
            }
            com.tencent.mm.plugin.exdevice.h.b bVar = new com.tencent.mm.plugin.exdevice.h.b();
            bVar.field_connProto = this.ivz;
            bVar.field_connStrategy = 1;
            bVar.field_closeStrategy = 1;
            bVar.field_url = "";
            f.a(bVar, alx, hlVar.rhl);
            if (bVar.field_mac == 0) {
                x.d("MicroMsg.NetSceneBindUnauthDevice", "onSceneEnd, mac of hardDeviceAttr is 0 so set a local mac.");
                bVar.field_mac = this.ivA;
            }
            if (obj != null) {
                ad.aHe().b(bVar);
            } else {
                ad.aHe().e(bVar);
            }
        }
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1262;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        a aVar = new a();
        aVar.dIG = new hk();
        aVar.dIH = new hl();
        aVar.uri = "/cgi-bin/mmoc-bin/hardware/bindunauthdevice";
        aVar.dIF = 1262;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        hk hkVar = (hk) this.diG.dID.dIL;
        hkVar.mac = com.tencent.mm.plugin.exdevice.j.b.cZ(this.ivA);
        hkVar.rif = this.ivB;
        hkVar.rie = this.ivz;
        hkVar.rig = this.ivC;
        return a(eVar, this.diG, this);
    }
}
