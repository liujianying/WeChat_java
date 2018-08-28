package com.tencent.mm.plugin.talkroom.b;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aik;
import com.tencent.mm.protocal.c.ail;
import com.tencent.mm.protocal.c.bsm;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;

public final class c extends f {
    private final b diG;
    private e diJ;
    private final String kGu;
    public int owV;
    public LinkedList<bsm> oxr;
    private int sceneType = 0;

    public c(int i, long j, String str, int i2) {
        this.sceneType = i2;
        a aVar = new a();
        aVar.dIG = new aik();
        aVar.dIH = new ail();
        aVar.uri = "/cgi-bin/micromsg-bin/gettalkroommember";
        aVar.dIF = 336;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        aik aik = (aik) this.diG.dID.dIL;
        aik.rxG = i;
        aik.rxH = j;
        this.kGu = str;
        aik.otY = i2;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.d("MicroMsg.NetSceneGetTalkRoomMember", "doScene");
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final int getType() {
        return 336;
    }

    public final String bHj() {
        return this.kGu;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneGetTalkRoomMember", "onGYNetEnd errType:" + i2 + " errCode:" + i3);
        if (i2 == 0 && i3 == 0) {
            ail ail = (ail) this.diG.dIE.dIL;
            x.i("MicroMsg.NetSceneGetTalkRoomMember", "resp %s", new Object[]{ail.toString()});
            this.owV = ail.rxI;
            this.oxr = ah(ail.rbQ);
            this.diJ.a(i2, i3, str, this);
            return;
        }
        this.diJ.a(i2, i3, str, this);
    }

    private static LinkedList<bsm> ah(LinkedList<bsm> linkedList) {
        LinkedList<bsm> linkedList2 = new LinkedList();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            bsm bsm = (bsm) it.next();
            if (!bi.oW(bsm.hbL)) {
                linkedList2.add(bsm);
            }
        }
        return linkedList2;
    }

    public final int bHk() {
        return this.sceneType;
    }
}
