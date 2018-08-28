package com.tencent.mm.modelappbrand;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bsa;
import com.tencent.mm.protocal.c.gl;
import com.tencent.mm.protocal.c.gm;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class m extends l implements k {
    private final b dFA;
    private e doG;

    public m(LinkedList<bsa> linkedList) {
        a aVar = new a();
        aVar.dIG = new gl();
        aVar.dIH = new gm();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxausrevent/batchswitchservicenotifyoption";
        aVar.dIF = 1176;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.dFA = aVar.KT();
        ((gl) this.dFA.dID.dIL).rgT = linkedList;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneBatchSwitchServiceNotifyOption", "onGYNetEnd, errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (this.doG != null) {
            this.doG.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1176;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.i("MicroMsg.NetSceneBatchSwitchServiceNotifyOption", "doScene");
        this.doG = eVar2;
        return a(eVar, this.dFA, this);
    }
}
