package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.protocal.c.alx;
import com.tencent.mm.protocal.c.amb;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.protocal.c.bkk;
import com.tencent.mm.protocal.c.bkl;
import com.tencent.mm.sdk.platformtools.x;

public final class w extends l implements k {
    private e doG = null;
    String ivG;
    public b ivx = null;

    public w(long j, String str, String str2, long j2, long j3, byte[] bArr, int i) {
        x.i("MicroMsg.exdevice.NetSceneSendHardDeviceMsg", "NetSceneSendHardDeviceMsg deviceType = %s, deviceId = %s, sessionId = %d, createTime = %d, data length = %d, msgType = %d", new Object[]{str, str2, Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(bArr.length), Integer.valueOf(i)});
        this.ivG = str2;
        a aVar = new a();
        aVar.dIG = new bkk();
        aVar.dIH = new bkl();
        aVar.dIF = 538;
        aVar.uri = "/cgi-bin/micromsg-bin/sendharddevicemsg";
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.ivx = aVar.KT();
        bkk bkk = (bkk) this.ivx.dID.dIL;
        alx alx = new alx();
        alx.reT = str;
        alx.hbO = str2;
        bkk.rhk = alx;
        amb amb = new amb();
        amb.rON = j2;
        amb.lOH = (int) j3;
        amb.rfy = new bhy().bq(bArr);
        amb.hcE = i;
        bkk.sjY = amb;
        if (j != 0) {
            bkk.rOI = new bhy().bq(u.aHF().m(j, 2));
            return;
        }
        com.tencent.mm.plugin.exdevice.h.b Al = ad.aHe().Al(str2);
        if (Al != null) {
            bkk.rOI = new bhy().bq(Al.field_sessionBuf);
        }
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.exdevice.NetSceneSendHardDeviceMsg", "onGYNetEnd netId = " + i + " errType = " + i2 + " errCode = " + i3 + str);
        this.doG.a(i2, i3, str, this);
    }

    public final int getType() {
        return 538;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.doG = eVar2;
        return a(eVar, this.ivx, this);
    }
}
