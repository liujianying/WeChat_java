package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.agg;
import com.tencent.mm.protocal.c.agh;
import com.tencent.mm.sdk.platformtools.x;

public final class f extends l implements k {
    private b diG;
    private e diJ;
    public String pjb = "";
    public boolean pjc = false;

    public f() {
        a aVar = new a();
        aVar.dIG = new agg();
        aVar.dIH = new agh();
        aVar.uri = "/cgi-bin/mmpay-bin/getpayuserduty";
        aVar.dIF = 2541;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
    }

    public final int getType() {
        return 2541;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MircoMsg.NetSceneGetPayUserDuty", "errType = " + i2 + ", errCode = " + i3);
        if (i2 == 0 && i3 == 0) {
            agh agh = (agh) ((b) qVar).dIE.dIL;
            this.pjb = agh.pjb;
            this.pjc = agh.pjc;
            x.i("MircoMsg.NetSceneGetPayUserDuty", "duty_info %s need_agree_duty %s", new Object[]{this.pjb, Boolean.valueOf(this.pjc)});
            this.diJ.a(i2, i3, str, this);
            return;
        }
        this.diJ.a(i2, i3, str, this);
    }
}
