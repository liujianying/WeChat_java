package com.tencent.mm.wallet_core.e.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.model.q;
import com.tencent.mm.network.e;
import com.tencent.mm.protocal.c.bal;
import com.tencent.mm.protocal.c.bam;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.i;
import com.tencent.mm.wallet_core.c.n;
import com.tenpay.android.wechat.TenpayUtil;
import java.net.URLEncoder;

public abstract class a extends i {
    public abstract int bOo();

    public final int bNX() {
        return bOo();
    }

    public final void J(boolean z, boolean z2) {
        b bVar = this.diG;
        if (bVar == null) {
            com.tencent.mm.ab.b.a aVar = new com.tencent.mm.ab.b.a();
            aVar.dIG = new bal();
            aVar.dIH = new bam();
            aVar.uri = "/cgi-bin/mmpay-bin/payu";
            aVar.dIF = 1518;
            aVar.dII = 0;
            aVar.dIJ = 0;
            bVar = aVar.KT();
            bVar.dIU = true;
        }
        b bVar2 = bVar;
        bal bal = (bal) bVar2.dID.dIL;
        if (z) {
            bal.rPs = bOo();
        }
        if (z2) {
            bal.rPt = 1;
        }
        this.diG = bVar2;
    }

    public final int getType() {
        return 1518;
    }

    public final String OT(String str) {
        return TenpayUtil.signWith3Des(str);
    }

    public final void a(b bVar, bhy bhy) {
        ((bal) bVar.dID.dIL).rPu = bhy;
    }

    public final void b(b bVar, bhy bhy) {
        ((bal) bVar.dID.dIL).scR = bhy;
    }

    public final n d(b bVar) {
        bam bam = (bam) bVar.dIE.dIL;
        n nVar = new n();
        nVar.rPy = bam.rPy;
        nVar.rPx = bam.rPx;
        nVar.rPw = bam.rPw;
        nVar.rPv = bam.rPv;
        nVar.iwT = bam.scT;
        nVar.uXp = bam.scS;
        return nVar;
    }

    public int a(e eVar, com.tencent.mm.ab.e eVar2) {
        this.diJ = eVar2;
        if (q.GS()) {
            return a(eVar, this.diG, this);
        }
        x.e("MicroMsg.NetScenePayUBase", "hy: serious error: not payupay");
        eVar2.a(1000, -100868, "Pay Method Err", this);
        return 1;
    }

    public final void b(StringBuilder stringBuilder, String str) {
        stringBuilder.append(URLEncoder.encode(str));
    }
}
