package com.tencent.mm.plugin.wallet.bind.a;

import com.tencent.mm.ab.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.m;

public final class b extends m {
    private com.tencent.mm.ab.b diG;
    private e diJ;
    private String pct;

    public final void e(int i, int i2, String str, q qVar) {
        x.d("MicroMsg.NetSceneSetMainBankCard", "errType:" + i + ",errCode:" + i2 + ",errMsg" + str);
        if (i == 0 && i2 == 0) {
            p.bNp();
            p.bNq();
            ag.Pc(this.pct);
        }
        this.diJ.a(i, i2, str, this);
    }

    public final int getType() {
        return 621;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }
}
