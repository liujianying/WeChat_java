package com.tencent.mm.plugin.facedetect.b;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aqe;
import com.tencent.mm.protocal.c.bbt;
import com.tencent.mm.protocal.c.vl;
import com.tencent.mm.protocal.c.vm;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class l extends com.tencent.mm.ab.l implements k {
    private b diG;
    private e diJ;
    private LinkedList<aqe> iMv = null;
    public bbt iMw = null;
    public String iMx = null;
    public String iMy = null;
    public String iMz = null;

    public l(String str, String str2) {
        a aVar = new a();
        aVar.dIG = new vl();
        aVar.dIH = new vm();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/faceidentifyprepage";
        aVar.dIF = 1147;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        vl vlVar = (vl) this.diG.dID.dIL;
        vlVar.bPS = str;
        vlVar.ryI = str2;
    }

    public final int getType() {
        return 1147;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneFaceGetConfirmPageInfo", "alvinluo errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        vm vmVar = (vm) ((b) qVar).dIE.dIL;
        if (vmVar != null) {
            this.iMv = vmVar.rqi;
            this.iMw = vmVar.ryJ;
            this.iMx = vmVar.ryL;
            this.iMy = vmVar.ryM;
            this.iMz = vmVar.ryN;
            if (this.diJ != null) {
                this.diJ.a(i2, i3, str, this);
            }
        }
    }
}
