package com.tencent.mm.plugin.aa.a.a;

import com.tencent.mm.protocal.c.p;
import com.tencent.mm.protocal.c.q;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends com.tencent.mm.ab.a<q> {
    public a(String str, long j, int i, String str2, String str3, String str4) {
        p pVar = new p();
        pVar.qYc = str;
        pVar.qYv = j;
        pVar.scene = i;
        pVar.qYd = str2;
        pVar.qYx = str3;
        pVar.myq = str4;
        com.tencent.mm.ab.b.a aVar = new com.tencent.mm.ab.b.a();
        aVar.dIG = pVar;
        aVar.dIH = new q();
        aVar.dIF = 1344;
        aVar.uri = "/cgi-bin/mmpay-bin/newaapaysucc";
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        x.i("MicroMsg.CgiAAPaySucc", "CgiAAPaySucc, bill_no: %s, pay_amount: %s, scene: %s, groupid: %s, out_trade_no: %s, trans_id: %s", new Object[]{pVar.qYc, Long.valueOf(pVar.qYv), Integer.valueOf(pVar.scene), pVar.qYd, pVar.qYx, pVar.myq});
    }
}
