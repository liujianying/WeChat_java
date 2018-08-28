package com.tencent.mm.plugin.ipcall.a.d;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ble;
import com.tencent.mm.protocal.c.blf;
import com.tencent.mm.protocal.c.cce;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class m extends l implements k {
    private b diG = null;
    private e diJ;
    private ble krE = null;
    public blf krF = null;

    public m(int i, int i2, LinkedList<cce> linkedList) {
        a aVar = new a();
        aVar.dIG = new ble();
        aVar.dIH = new blf();
        aVar.dIF = 871;
        aVar.uri = "/cgi-bin/micromsg-bin/sendwcofeedback";
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        this.krE = (ble) this.diG.dID.dIL;
        this.krE.rXf = i2;
        this.krE.skm = linkedList;
        this.krE.skl = linkedList.size();
        this.krE.skn = i;
        x.i("MicroMsg.NetSceneIPCallSendFeedback", "NetSceneIPCallSendFeedback roomid=%d, level=%d, feedbackCount=%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(linkedList.size())});
    }

    public final int getType() {
        return 871;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneIPCallSendFeedback", "onGYNetEnd, errType: %d, errCode: %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        this.krF = (blf) ((b) qVar).dIE.dIL;
        if (this.diJ != null) {
            this.diJ.a(i2, i3, str, this);
        }
    }
}
