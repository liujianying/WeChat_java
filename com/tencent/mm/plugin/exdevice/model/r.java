package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.protocal.c.alx;
import com.tencent.mm.protocal.c.alz;
import com.tencent.mm.protocal.c.ama;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.sdk.platformtools.x;

public final class r extends l implements k {
    private String bKC;
    private b diG = null;
    private e diJ = null;
    String ivE;

    public r(String str, String str2, String str3, int i, byte[] bArr) {
        a aVar = new a();
        aVar.dIG = new alz();
        aVar.dIH = new ama();
        aVar.uri = "/cgi-bin/micromsg-bin/harddeviceauth";
        aVar.dIF = 541;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        alz alz = (alz) this.diG.dID.dIL;
        alx alx = new alx();
        alx.reT = str2;
        alx.hbO = str3;
        alz.rhk = alx;
        alz.rOG = i;
        alz.rOH = new bhy().bq(bArr);
        this.ivE = str3;
        this.bKC = str;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.exdevice.NetSceneHardDeviceAuth", "onGYNetEnd netId = " + i + " errType = " + i2 + " errCode = " + i3 + str);
        com.tencent.mm.plugin.exdevice.h.b Al = ad.aHe().Al(this.ivE);
        if (i2 == 0 && i3 == 0) {
            ama ama = (ama) this.diG.dIE.dIL;
            if (Al != null) {
                byte[] aGY = aGY();
                if (aGY != null) {
                    Al.field_authBuf = aGY;
                }
                Al.cCO = ama.rOL;
                Al.cpN = true;
                Al.cCN = ama.rOK;
                Al.cpN = true;
                byte[] DE = DE();
                if (DE != null) {
                    u.aHF().b(Al.field_mac, DE, 2);
                    if (u.aHG().isY != null) {
                        u.aHG().isY.setChannelSessionKey(Al.field_mac, DE);
                    }
                    Al.field_sessionKey = DE;
                }
                DE = aGZ();
                if (DE != null) {
                    u.aHF().b(Al.field_mac, DE, 3);
                    Al.field_sessionBuf = DE;
                }
                DE = aGY();
                if (aGY != null) {
                    u.aHF().b(Al.field_mac, DE, 1);
                    Al.field_authBuf = aGY;
                }
                Al.cCP = System.currentTimeMillis() / 1000;
                Al.cpN = true;
                if (2 == u.aHF().cM(Al.field_mac)) {
                    ad.aHp();
                    e.e(this.bKC, Al.field_url, 2, Al.field_deviceID);
                }
                u.aHF().cP(Al.field_mac);
                boolean c = ad.aHe().c(Al, new String[0]);
                x.i("MicroMsg.exdevice.NetSceneHardDeviceAuth", "update local device auth infos = %b", new Object[]{Boolean.valueOf(c)});
            } else {
                x.e("MicroMsg.exdevice.NetSceneHardDeviceAuth", "SubCoreExDevice.getHardDeviceInfoStorage().getByDeviceIdServer == null");
            }
        } else {
            if (Al != null) {
                u.aHF().cQ(Al.field_mac);
                ad.aHp();
                e.e(this.bKC, Al.field_url, 4, Al.field_deviceID);
            }
            ad.aHp();
            e.bj(this.bKC, 3);
        }
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return 541;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    private byte[] DE() {
        try {
            return ((ama) this.diG.dIE.dIL).rer.siK.lR;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.exdevice.NetSceneHardDeviceAuth", e, "", new Object[0]);
            return null;
        }
    }

    public final byte[] aGY() {
        try {
            return ((ama) this.diG.dIE.dIL).rOJ.siK.lR;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.exdevice.NetSceneHardDeviceAuth", e, "", new Object[0]);
            return null;
        }
    }

    private byte[] aGZ() {
        try {
            return ((ama) this.diG.dIE.dIL).rOI.siK.lR;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.exdevice.NetSceneHardDeviceAuth", e, "", new Object[0]);
            return null;
        }
    }
}
