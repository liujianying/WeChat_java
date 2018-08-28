package com.tencent.mm.plugin.collect.reward.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.mj;
import com.tencent.mm.protocal.c.mk;
import com.tencent.mm.sdk.platformtools.x;

public final class f extends a {
    private final String TAG = "MicroMsg.NetSceneQrRewardScanCode";
    private b diG;
    private e diJ;
    public mk hVc;

    public f(String str, int i, String str2) {
        a aVar = new a();
        aVar.dIG = new mj();
        aVar.dIH = new mk();
        aVar.dIF = 1516;
        aVar.uri = "/cgi-bin/mmpay-bin/scanrewardqrcode";
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        mj mjVar = (mj) this.diG.dID.dIL;
        mjVar.hUo = str;
        mjVar.bVU = i;
        mjVar.rqw = str2;
    }

    public final int getType() {
        return 1516;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void b(int i, int i2, String str, q qVar) {
        x.i("MicroMsg.NetSceneQrRewardScanCode", "errType: %s, errCode: %s, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        this.hVc = (mk) ((b) qVar).dIE.dIL;
        x.i("MicroMsg.NetSceneQrRewardScanCode", "retcode: %s, retmsg: %s", new Object[]{Integer.valueOf(this.hVc.hUm), this.hVc.hUn});
        if (!(this.hUU || this.hVc.hUm == 0)) {
            this.hUV = true;
        }
        if (this.diJ != null) {
            this.diJ.a(i, i2, str, this);
        }
    }

    protected final boolean aBP() {
        return false;
    }
}
