package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.protocal.c.cab;
import com.tencent.mm.protocal.c.cac;

public final class f extends n<cab, cac> {
    String TAG = "MicroMsg.NetSceneVoipHeartBeat";

    public f(int i, long j, int i2) {
        a aVar = new a();
        aVar.dIG = new cab();
        aVar.dIH = new cac();
        aVar.uri = "/cgi-bin/micromsg-bin/voipheartbeat";
        aVar.dIF = 178;
        aVar.dII = 81;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        cab cab = (cab) this.diG.dID.dIL;
        cab.rxG = i;
        cab.rxH = j;
        cab.suO = System.currentTimeMillis();
        cab.svU = i2;
    }

    public final int getType() {
        return 178;
    }

    public final e bLm() {
        return new 1(this);
    }
}
