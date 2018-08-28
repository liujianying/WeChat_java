package com.tencent.mm.plugin.collect.reward.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.mh;
import com.tencent.mm.protocal.c.mi;
import com.tencent.mm.sdk.platformtools.x;

public final class e extends a {
    private final String TAG = "MicroMsg.NetSceneQrRewardPlaceOrder";
    private b diG;
    private com.tencent.mm.ab.e diJ;
    public mi hVb;

    public e(int i, int i2, String str, String str2, String str3, int i3, String str4, String str5, String str6, String str7, String str8, int i4) {
        a aVar = new a();
        aVar.dIG = new mh();
        aVar.dIH = new mi();
        aVar.dIF = 1336;
        aVar.uri = "/cgi-bin/mmpay-bin/rewardqrcodeplaceorder";
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        mh mhVar = (mh) this.diG.dID.dIL;
        mhVar.amount = i;
        mhVar.rqu = i2;
        mhVar.rqs = str;
        mhVar.rqt = str2;
        mhVar.myf = str3;
        mhVar.bVU = i3;
        mhVar.rqv = str4;
        mhVar.rqp = str5;
        mhVar.rqw = str6;
        mhVar.rqx = str7;
        mhVar.rqy = str8;
        mhVar.rqz = i4;
    }

    public final int getType() {
        return 1336;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ab.e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void b(int i, int i2, String str, q qVar) {
        x.i("MicroMsg.NetSceneQrRewardPlaceOrder", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        this.hVb = (mi) ((b) qVar).dIE.dIL;
        x.i("MicroMsg.NetSceneQrRewardPlaceOrder", "retcode: %s, retmsg: %s", Integer.valueOf(this.hVb.hUm), this.hVb.hUn);
        if (!(this.hUU || this.hVb.hUm == 0)) {
            this.hUV = true;
        }
        if (this.diJ != null) {
            this.diJ.a(i, i2, str, this);
        }
    }
}
