package com.tencent.mm.plugin.collect.reward.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ml;
import com.tencent.mm.protocal.c.mm;
import com.tencent.mm.sdk.platformtools.x;

public final class h extends a {
    private final String TAG = "MicroMsg.NetSceneQrRewardSetPhotoWord";
    private b diG;
    private e diJ;
    public mm hVe;
    public String hqp;

    public h(String str) {
        a aVar = new a();
        aVar.dIG = new ml();
        aVar.dIH = new mm();
        aVar.dIF = 1649;
        aVar.uri = "/cgi-bin/mmpay-bin/setrewardqrcodephotoword";
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        ((ml) this.diG.dID.dIL).hqp = str;
        this.hqp = str;
        if (str.length() > 0 && str.length() <= 3) {
            com.tencent.mm.plugin.report.service.h.mEJ.a(724, 0, 1, false);
        } else if (str.length() > 3) {
            com.tencent.mm.plugin.report.service.h.mEJ.a(724, 1, 1, false);
        }
    }

    public final int getType() {
        return 1649;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void b(int i, int i2, String str, q qVar) {
        x.i("MicroMsg.NetSceneQrRewardSetPhotoWord", "errType: %s, errCode: %s, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        this.hVe = (mm) ((b) qVar).dIE.dIL;
        x.i("MicroMsg.NetSceneQrRewardSetPhotoWord", "retcode: %s, retmsg: %s", new Object[]{Integer.valueOf(this.hVe.hUm), this.hVe.hUn});
        if (!(this.hUU || this.hVe.hUm == 0)) {
            this.hUV = true;
        }
        if (this.diJ != null) {
            this.diJ.a(i, i2, str, this);
        }
    }
}
