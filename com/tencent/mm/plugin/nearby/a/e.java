package com.tencent.mm.plugin.nearby.a;

import com.tencent.mm.aa.j;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aqv;
import com.tencent.mm.protocal.c.aqw;
import com.tencent.mm.protocal.c.aqx;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

public final class e extends l implements k {
    final b diG;
    private com.tencent.mm.ab.e diJ;

    public e(String str) {
        a aVar = new a();
        aVar.dIG = new aqw();
        aVar.dIH = new aqx();
        aVar.uri = "/cgi-bin/micromsg-bin/getroommember";
        aVar.dIF = 377;
        aVar.dII = 184;
        aVar.dIJ = 1000000184;
        this.diG = aVar.KT();
        ((aqw) this.diG.dID.dIL).ebL = str;
        x.d("MicroMsg.NetSceneLbsRoomGetMember", "Req: roomName:" + str);
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ab.e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final int getType() {
        return 377;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneLbsRoomGetMember", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        aqx aqx = (aqx) this.diG.dIE.dIL;
        if (i2 != 0) {
            this.diJ.a(i2, i3, str, this);
            return;
        }
        List arrayList = new ArrayList();
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 < aqx.rbQ.size()) {
                j jVar = new j();
                jVar.username = ((aqv) aqx.rbQ.get(i5)).hbL;
                jVar.dHR = ((aqv) aqx.rbQ.get(i5)).rqZ;
                jVar.dHQ = ((aqv) aqx.rbQ.get(i5)).rra;
                jVar.by(true);
                arrayList.add(jVar);
                i4 = i5 + 1;
            } else {
                com.tencent.mm.aa.q.KH().L(arrayList);
                this.diJ.a(i2, i3, str, this);
                return;
            }
        }
    }
}
