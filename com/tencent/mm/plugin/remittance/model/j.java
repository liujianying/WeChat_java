package com.tencent.mm.plugin.remittance.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ch;
import com.tencent.mm.protocal.c.jj;
import com.tencent.mm.protocal.c.jk;
import com.tencent.mm.sdk.platformtools.x;

public final class j extends l implements k {
    private e diJ;
    private b eAN;
    public jk mxm;

    public j(ch chVar, String str) {
        a aVar = new a();
        aVar.dIG = new jj();
        aVar.dIH = new jk();
        aVar.dIF = 2504;
        aVar.uri = "/cgi-bin/mmpay-bin/busif2fsucpage";
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.eAN = aVar.KT();
        jj jjVar = (jj) this.eAN.dID.dIL;
        jjVar.rkA = chVar;
        jjVar.rkM = str;
        x.i("MicroMsg.NetSceneBusiF2fSucpage", "NetSceneBusiF2fSucpage suc_page_extend %s req %s", new Object[]{str, a.a(chVar)});
    }

    public final int getType() {
        return 2504;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.eAN, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneBusiF2fSucpage", "errType: %s, errCode: %s, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.mxm = (jk) ((b) qVar).dIE.dIL;
        StringBuffer stringBuffer = new StringBuffer();
        if (this.mxm.pqb != null) {
            stringBuffer.append("response: " + this.mxm.rkZ);
            stringBuffer.append("is_show_btn: " + this.mxm.pqb.rxT);
            if (this.mxm.pqb.rxS != null) {
                stringBuffer.append("single_exposure_info_list " + this.mxm.pqb.rxS.size());
            }
        }
        x.i("MicroMsg.NetSceneBusiF2fSucpage", "ret_code: %s, ret_msg: %s %s", new Object[]{Integer.valueOf(this.mxm.hwV), this.mxm.hwW, stringBuffer.toString()});
        if (this.diJ != null) {
            this.diJ.a(i2, i3, str, this);
        }
    }
}
