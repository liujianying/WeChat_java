package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.protocal.c.bhz;
import com.tencent.mm.protocal.c.cam;
import com.tencent.mm.protocal.c.can;
import com.tencent.mm.protocal.c.cas;

public final class i extends n<cam, can> {
    String TAG = "MicroMsg.NetSceneVoipShutDown";

    public i(int i, long j, String str) {
        a aVar = new a();
        aVar.dIG = new cam();
        aVar.dIH = new can();
        aVar.uri = "/cgi-bin/micromsg-bin/voipshutdown";
        aVar.dIF = 173;
        aVar.dII = 66;
        aVar.dIJ = 1000000066;
        this.diG = aVar.KT();
        cam cam = (cam) this.diG.dID.dIL;
        cam.rxG = i;
        cam.rxH = j;
        cas cas = new cas();
        bhz bhz = new bhz();
        bhz.VO(str);
        cas.spT = bhz;
        cam.svJ = cas;
        cam.suO = System.currentTimeMillis();
    }

    public final int getType() {
        return 173;
    }

    public final e bLm() {
        return new 1(this);
    }
}
