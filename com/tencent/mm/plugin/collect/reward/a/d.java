package com.tencent.mm.plugin.collect.reward.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.mf;
import com.tencent.mm.protocal.c.mg;
import com.tencent.mm.sdk.platformtools.x;

public final class d extends a {
    private final String TAG = "MicroMsg.NetSceneQrRewardPayCheck";
    private b diG;
    private e diJ;
    private mg hVa;

    public d(String str, String str2, String str3, int i, String str4, String str5) {
        a aVar = new a();
        aVar.dIG = new mf();
        aVar.dIH = new mg();
        aVar.dIF = 1960;
        aVar.uri = "/cgi-bin/mmpay-bin/rewardqrcodepaycheck";
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        mf mfVar = (mf) this.diG.dID.dIL;
        mfVar.bQa = str;
        mfVar.rqr = str2;
        mfVar.rcE = str3;
        mfVar.amount = i;
        mfVar.rqp = str4;
        mfVar.rqo = str5;
        x.i("MicroMsg.NetSceneQrRewardPayCheck", "rewardid: %s, amt: %s", str2, Integer.valueOf(i));
    }

    public final int getType() {
        return 1960;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void b(int i, int i2, String str, q qVar) {
        x.i("MicroMsg.NetSceneQrRewardPayCheck", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        this.hVa = (mg) ((b) qVar).dIE.dIL;
        x.i("MicroMsg.NetSceneQrRewardPayCheck", "retcode: %s, retmsg: %s", Integer.valueOf(this.hVa.hUm), this.hVa.hUn);
        if (!(this.hUU || this.hVa.hUm == 0)) {
            this.hUV = true;
        }
        if (this.diJ != null) {
            this.diJ.a(i, i2, str, this);
        }
    }
}
