package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.exdevice.service.f;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.protocal.c.hc;
import com.tencent.mm.protocal.c.hd;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class l extends com.tencent.mm.ab.l implements k {
    private b diG = null;
    private e diJ = null;

    public l(String str, int i) {
        a aVar = new a();
        aVar.dIG = new hc();
        aVar.dIH = new hd();
        aVar.uri = "/cgi-bin/micromsg-bin/bindharddevice";
        aVar.dIF = 536;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        hc hcVar = (hc) this.diG.dID.dIL;
        hcVar.rgQ = bi.oV(str);
        hcVar.rhj = bi.f(Integer.valueOf(i));
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.exdevice.NetSceneBindHardDevice", "onGYNetEnd netId = " + i + " errType = " + i2 + " errCode = " + i3 + str);
        if (i2 == 0 && i3 == 0) {
            int i4;
            hd aGX = aGX();
            x.i("MicroMsg.exdevice.NetSceneBindHardDevice", "hardDevice : DeviceIdServer = %s, DeviceType = %s", new Object[]{aGX.rhk.hbO, aGX.rhk.reT});
            String str2 = "MicroMsg.exdevice.NetSceneBindHardDevice";
            String str3 = "hardDeviceAttr : AuthKey = %s, BrandName = %s, Mac = %s, connProto = %s, ConnStrategy = %s, bindFlag = %s";
            Object[] objArr = new Object[6];
            objArr[0] = aGX.rhl.reA;
            objArr[1] = aGX.rhl.rOv;
            objArr[2] = aGX.rhl.rgL;
            objArr[3] = aGX.rhl.rOw;
            objArr[4] = Integer.valueOf(aGX.rhl.rOx);
            objArr[5] = aGX.rbZ == 0 ? "sync" : "async";
            x.i(str2, str3, objArr);
            if (ad.aHe().cA(aGX.rhl.rOv, aGX.rhk.hbO) != null) {
                x.i("MicroMsg.exdevice.NetSceneBindHardDevice", "delete local deviceinfo : %s, ret : %b", new Object[]{aGX.rhl.rOv, Boolean.valueOf(ad.aHe().cB(aGX.rhk.hbO, aGX.rhl.rOv))});
                if (ad.aHe().cB(aGX.rhk.hbO, aGX.rhl.rOv)) {
                    i4 = 1;
                } else {
                    i4 = 0;
                }
            } else {
                i4 = 1;
            }
            com.tencent.mm.plugin.exdevice.h.b bVar = new com.tencent.mm.plugin.exdevice.h.b();
            f.a(bVar, aGX.rhk, aGX.rhl);
            bVar.field_url = "";
            f.a cN = u.aHF().cN(bVar.field_mac);
            if (cN != null && cN.bLv == 2) {
                x.i("MicroMsg.exdevice.NetSceneBindHardDevice", "before do bind netscene, stop the channel now");
                ad.aHl();
                d.cB(bVar.field_mac);
                f aHF = u.aHF();
                long j = bVar.field_mac;
                if (aHF.iyJ.containsKey(Long.valueOf(j))) {
                    aHF.iyJ.remove(Long.valueOf(j));
                    x.i("MicroMsg.exdevice.ExdeviceInfoManager", "remove the device from map : %d", new Object[]{Long.valueOf(j)});
                } else {
                    x.i("MicroMsg.exdevice.ExdeviceInfoManager", "device id not contains in the map : %d", new Object[]{Long.valueOf(j)});
                }
            }
            if (i4 != 0) {
                ad.aHe().b(bVar);
            } else {
                ad.aHe().e(bVar);
            }
        }
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return 536;
    }

    public final hd aGX() {
        if (this.diG == null || this.diG.dIE.dIL == null) {
            return null;
        }
        return (hd) this.diG.dIE.dIL;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }
}
