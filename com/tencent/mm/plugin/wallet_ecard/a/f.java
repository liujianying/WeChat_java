package com.tencent.mm.plugin.wallet_ecard.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bdb;
import com.tencent.mm.protocal.c.bdc;
import com.tencent.mm.sdk.platformtools.x;

public final class f extends l implements k {
    private b diG;
    private e diJ;
    public bdc pCd;

    public f(String str, int i) {
        a aVar = new a();
        aVar.dIG = new bdb();
        aVar.dIH = new bdc();
        aVar.dIF = 1988;
        aVar.uri = "/cgi-bin/mmpay-bin/qryecardbanklist4bind";
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        bdb bdb = (bdb) this.diG.dID.dIL;
        bdb.rhb = str;
        bdb.bVB = i;
        x.i("MicroMsg.NetSceneQryBankList4Bind", "cardType: %s, openScene: %s", new Object[]{str, Integer.valueOf(i)});
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneQryBankList4Bind", "errType: %s, errCode: %s, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.pCd = (bdc) ((b) qVar).dIE.dIL;
        x.i("MicroMsg.NetSceneQryBankList4Bind", "ret_code: %d, ret_msg: %s", new Object[]{Integer.valueOf(this.pCd.hwV), this.pCd.hwW});
        if (this.diJ != null) {
            this.diJ.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1988;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }
}
