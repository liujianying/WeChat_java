package com.tencent.mm.plugin.ext.voicecontrol;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.dk;
import com.tencent.mm.protocal.c.dl;
import com.tencent.mm.protocal.c.dm;
import com.tencent.mm.protocal.c.dq;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends l implements k {
    public String appId;
    public int bNI = 1;
    public int dHI;
    public int dHJ;
    b diG;
    private e diJ;
    public int iLq;
    public com.tencent.mm.bk.b iLr;
    public String iLs;
    public dq iLt;
    public dk iLu;
    int iLv = 5000;
    long iLw = 0;
    public int sH;

    public a(int i, String str, int i2, String str2, dq dqVar) {
        boolean z = true;
        this.appId = str;
        this.iLq = i;
        this.sH = 1;
        this.dHI = i2;
        this.iLt = dqVar;
        this.iLu = null;
        this.iLs = str2;
        String str3 = "MicroMsg.ext.NetSceneAppVoiceControl";
        String str4 = "[voiceControl] new NetSceneAppVoiceControl, opCode=%s, appId=%s, voiceId=%s, totalLen=%s, controlType=%s, %s, %s";
        Object[] objArr = new Object[7];
        objArr[0] = Integer.valueOf(1);
        objArr[1] = str;
        objArr[2] = Integer.valueOf(i);
        objArr[3] = Integer.valueOf(i2);
        objArr[4] = Integer.valueOf(1);
        if (dqVar == null) {
            z = false;
        }
        objArr[5] = Boolean.valueOf(z);
        objArr[6] = Boolean.valueOf(false);
        x.i(str3, str4, objArr);
    }

    public a(int i, String str, dk dkVar, long j) {
        this.appId = str;
        this.iLq = i;
        this.sH = 1;
        this.iLt = null;
        this.iLu = dkVar;
        this.iLw = j;
        x.i("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] new NetSceneAppVoiceControl, opCode=%s, appId=%s, voiceId=%s, controlType=%s, %s, %s", new Object[]{Integer.valueOf(2), str, Integer.valueOf(i), Integer.valueOf(1), Boolean.valueOf(false), Boolean.valueOf(true)});
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        if (i2 == 0 && i3 == 0 && qVar != null) {
            x.i("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] onGYNetEnd netId %d , errType %d, errCode %d, %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        } else {
            x.e("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] onGYNetEnd netId %d , errType %d, errCode %d, %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        }
        if (this.diJ != null) {
            this.diJ.a(i2, i3, str, this);
        } else {
            x.e("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] callback null");
        }
    }

    public final int getType() {
        return 985;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        com.tencent.mm.ab.b.a aVar = new com.tencent.mm.ab.b.a();
        aVar.dIF = 985;
        aVar.uri = "/cgi-bin/micromsg-bin/appvoicecontrol";
        aVar.dIG = new dl();
        aVar.dIH = new dm();
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        dl dlVar = (dl) this.diG.dID.dIL;
        dlVar.qZc = this.bNI;
        dlVar.jQb = this.appId;
        dlVar.rdH = this.iLq;
        dlVar.rdI = this.sH;
        dlVar.rdJ = this.iLt;
        dlVar.rdK = this.iLu;
        return a(eVar, this.diG, this);
    }
}
