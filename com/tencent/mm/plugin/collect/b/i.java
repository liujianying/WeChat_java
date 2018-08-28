package com.tencent.mm.plugin.collect.b;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.lu;
import com.tencent.mm.protocal.c.lv;
import com.tencent.mm.sdk.platformtools.x;

public final class i extends l implements k {
    public String bJh;
    private e diJ;
    private b eAN;
    public lv hUi;

    public i(int i, com.tencent.mm.bk.b bVar, String str) {
        a aVar = new a();
        aVar.dIG = new lu();
        aVar.dIH = new lv();
        aVar.dIF = 1384;
        aVar.uri = "/cgi-bin/mmpay-bin/getf2frcvvoice";
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.eAN = aVar.KT();
        lu luVar = (lu) this.eAN.dID.dIL;
        luVar.amount = i;
        luVar.rpW = 1;
        luVar.hUM = str;
        luVar.rpU = null;
        luVar.rpV = bVar;
        this.bJh = str;
        x.i("MicroMsg.NetSceneF2FRcvVoice", "amount: %d, outtradeno: %s", new Object[]{Integer.valueOf(i), str});
    }

    public final int getType() {
        return 1384;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.eAN, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneF2FRcvVoice", "errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.hUi = (lv) ((b) qVar).dIE.dIL;
        x.i("MicroMsg.NetSceneF2FRcvVoice", "ret_code: %d, ret_msg: %s，voice_type: %d", new Object[]{Integer.valueOf(this.hUi.hUm), this.hUi.hUn, Integer.valueOf(this.hUi.rpW)});
        if (this.diJ != null) {
            this.diJ.a(i2, i3, str, this);
        }
    }
}
