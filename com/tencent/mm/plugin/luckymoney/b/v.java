package com.tencent.mm.plugin.luckymoney.b;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.alm;
import com.tencent.mm.protocal.c.aln;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.h;

public final class v extends h {
    public aln kRa;

    public v(String str, String str2, String str3) {
        a aVar = new a();
        aVar.dIG = new alm();
        aVar.dIH = new aln();
        aVar.dIF = 2929;
        aVar.uri = "/cgi-bin/mmpay-bin/ftfhb/businesscallbackwxhb";
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        alm alm = (alm) this.diG.dID.dIL;
        alm.kLZ = str;
        alm.hTI = str2;
        alm.kRx = str3;
        x.i("MicroMsg.NetSceneLuckyMoneyBusinessCallback", "sendId: %s, %s", new Object[]{str, str3});
    }

    protected final void b(int i, int i2, String str, q qVar) {
        this.kRa = (aln) ((b) qVar).dIE.dIL;
        x.i("MicroMsg.NetSceneLuckyMoneyBusinessCallback", "retcode: %s, retmsg: %s", new Object[]{Integer.valueOf(this.kRa.hUm), this.kRa.hUn});
        if (this.diJ != null) {
            this.diJ.a(i, i2, str, this);
        }
    }

    protected final void f(q qVar) {
        aln aln = (aln) ((b) qVar).dIE.dIL;
        this.uXe = aln.hUm;
        this.uXf = aln.hUn;
    }

    public final int getType() {
        return 2929;
    }
}
