package com.tencent.mm.plugin.remittance.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.lo;
import com.tencent.mm.protocal.c.lp;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.h;
import java.net.URLDecoder;

public final class m extends h {
    private final String TAG = "MicroMsg.NetSceneF2fDynamicCode";
    public lp mxr;

    public m(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        a aVar = new a();
        aVar.dIG = new lo();
        aVar.dIH = new lp();
        aVar.dIF = 2736;
        aVar.uri = "/cgi-bin/mmpay-bin/f2fdynamiccode";
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        lo loVar = (lo) this.diG.dID.dIL;
        loVar.amount = i;
        loVar.hyG = str;
        loVar.myl = str2;
        loVar.rpI = URLDecoder.decode(str3);
        loVar.mxX = str4;
        loVar.mxY = str5;
        loVar.myo = str6;
        loVar.nickname = str7;
        loVar.mxM = str8;
        x.i("MicroMsg.NetSceneF2fDynamicCode", "amount: %s, username: %s, transfer_code_id: %s", new Object[]{Integer.valueOf(i), str, URLDecoder.decode(str3)});
    }

    public final int getType() {
        return 2736;
    }

    public final void b(int i, int i2, String str, q qVar) {
        x.i("MicroMsg.NetSceneF2fDynamicCode", "errType: %s, errCode: %s, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        this.mxr = (lp) ((b) qVar).dIE.dIL;
        x.i("MicroMsg.NetSceneF2fDynamicCode", "retcode: %s, retmsg: %s", new Object[]{Integer.valueOf(this.mxr.hUm), this.mxr.hUn});
        if (this.diJ != null) {
            this.diJ.a(i, i2, str, this);
        }
    }

    protected final void f(q qVar) {
        lp lpVar = (lp) ((b) qVar).dIE.dIL;
        this.uXe = lpVar.hUm;
        this.uXf = lpVar.hUn;
    }
}
