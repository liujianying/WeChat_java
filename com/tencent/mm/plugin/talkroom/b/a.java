package com.tencent.mm.plugin.talkroom.b;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bsl;
import com.tencent.mm.protocal.c.bsm;
import com.tencent.mm.protocal.c.tw;
import com.tencent.mm.protocal.c.tx;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;

public final class a extends f {
    private final b diG;
    private e diJ;
    private final String kGu;
    public int kpo;
    public long kpp;
    public int owV;
    public int owW;
    public LinkedList<bsl> owY;
    public LinkedList<bsm> oxr;
    private int sceneType = 0;

    public a(String str, int i) {
        com.tencent.mm.ab.b.a aVar = new com.tencent.mm.ab.b.a();
        this.sceneType = i;
        aVar.dIG = new tw();
        aVar.dIH = new tx();
        aVar.uri = "/cgi-bin/micromsg-bin/entertalkroom";
        aVar.dIF = 332;
        aVar.dII = 147;
        aVar.dIJ = 1000000147;
        this.diG = aVar.KT();
        ((tw) this.diG.dID.dIL).rxF = str;
        ((tw) this.diG.dID.dIL).otY = i;
        this.kGu = str;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.d("MicroMsg.NetSceneEnterTalkRoom", "doScene %d", new Object[]{Integer.valueOf(this.sceneType)});
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final int getType() {
        return 332;
    }

    public final String bHj() {
        return this.kGu;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneEnterTalkRoom", "onGYNetEnd errType:" + i2 + " errCode:" + i3);
        if (i2 == 0 && i3 == 0) {
            tx txVar = (tx) this.diG.dIE.dIL;
            x.i("MicroMsg.NetSceneEnterTalkRoom", "resp %s", new Object[]{txVar.toString()});
            this.kpo = txVar.rxG;
            this.kpp = txVar.rxH;
            this.owV = txVar.rxI;
            this.owW = txVar.rxK;
            this.oxr = ah(txVar.rbQ);
            this.owY = ai(txVar.rfi);
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

    private static LinkedList<bsl> ai(LinkedList<bsl> linkedList) {
        LinkedList<bsl> linkedList2 = new LinkedList();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            linkedList2.add((bsl) it.next());
        }
        return linkedList2;
    }

    public final int bHk() {
        return this.sceneType;
    }
}
