package com.tencent.mm.plugin.brandservice.b;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.asd;
import com.tencent.mm.protocal.c.asg;
import com.tencent.mm.protocal.c.ash;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class l extends com.tencent.mm.ab.l implements k {
    public b diG;
    private e diJ;

    public l(String str, LinkedList<asd> linkedList) {
        a aVar = new a();
        aVar.dIG = new asg();
        aVar.dIH = new ash();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/setrecvtmpmsgoption";
        aVar.dIF = 1030;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        asg asg = (asg) this.diG.dID.dIL;
        asg.rPS = str;
        asg.rUz = linkedList;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.brandservice.NetSceneSetRecvTmpMsgOption", "onGYNetEnd code(%d, %d)", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (this.diJ != null) {
            this.diJ.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1030;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        x.i("MicroMsg.brandservice.NetSceneSetRecvTmpMsgOption", "do scene");
        return a(eVar, this.diG, this);
    }
}
