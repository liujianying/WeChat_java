package com.tencent.mm.plugin.remittance.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.mr;
import com.tencent.mm.protocal.c.ms;
import com.tencent.mm.sdk.platformtools.x;

public final class s extends l implements k {
    private e diJ;
    private b eAN;
    public ms mxz;

    public s(String str, String str2, String str3, String str4, long j, String str5) {
        a aVar = new a();
        aVar.dIG = new mr();
        aVar.dIH = new ms();
        aVar.dIF = 1779;
        aVar.uri = "/cgi-bin/mmpay-bin/transferoldpaycheck";
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.eAN = aVar.KT();
        mr mrVar = (mr) this.eAN.dID.dIL;
        mrVar.bQa = str;
        mrVar.rqG = str2;
        mrVar.myq = str3;
        mrVar.myl = str4;
        mrVar.mzF = j;
        mrVar.rqo = str5;
        x.i("MicroMsg.NetSceneRemittancePayCheck", "reqKey: %s, transfer: %s, fee: %s", new Object[]{str, str2, Long.valueOf(j)});
    }

    public final int getType() {
        return 1779;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.eAN, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneRemittancePayCheck", "errType: %s, errCode: %s, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.mxz = (ms) ((b) qVar).dIE.dIL;
        x.i("MicroMsg.NetSceneRemittancePayCheck", "ret_code: %s, ret_msg: %s", new Object[]{Integer.valueOf(this.mxz.hUm), this.mxz.hUn});
        if (this.diJ != null) {
            this.diJ.a(i2, i3, str, this);
        }
    }
}
