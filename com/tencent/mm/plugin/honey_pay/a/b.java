package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.mm.ab.b.a;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.nx;
import com.tencent.mm.protocal.c.ny;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.h;

public final class b extends h {
    private final String TAG = "MicroMsg.NetSceneCheckHoneyUser";
    public ny kjB;
    public String username;

    public b(String str, int i) {
        a aVar = new a();
        aVar.dIG = new nx();
        aVar.dIH = new ny();
        aVar.dIF = 2926;
        aVar.uri = "/cgi-bin/mmpay-bin/checkhoneyuser";
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        nx nxVar = (nx) this.diG.dID.dIL;
        nxVar.rrW = str;
        nxVar.huV = i;
        this.username = str;
    }

    public final int getType() {
        return 2926;
    }

    public final void b(int i, int i2, String str, q qVar) {
        x.i("MicroMsg.NetSceneCheckHoneyUser", "errType: %s, errCode: %s, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        this.kjB = (ny) ((com.tencent.mm.ab.b) qVar).dIE.dIL;
        x.i("MicroMsg.NetSceneCheckHoneyUser", "retcode: %s, retmsg: %s", new Object[]{Integer.valueOf(this.kjB.hwV), this.kjB.hwW});
        if (this.diJ != null) {
            this.diJ.a(i, i2, str, this);
        }
    }

    protected final void f(q qVar) {
        ny nyVar = (ny) ((com.tencent.mm.ab.b) qVar).dIE.dIL;
        this.uXe = nyVar.hwV;
        this.uXf = nyVar.hwW;
    }
}
