package com.tencent.mm.plugin.chatroom.d;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.m;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ali;
import com.tencent.mm.protocal.c.pp;
import com.tencent.mm.protocal.c.pq;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;

public final class e extends l implements k {
    private LinkedList<ali> bTM;
    private final b diG;
    private com.tencent.mm.ab.e diJ;

    public e(LinkedList<ali> linkedList) {
        this.bTM = linkedList;
        a aVar = new a();
        aVar.dIG = new pp();
        aVar.dIH = new pq();
        aVar.uri = "/cgi-bin/micromsg-bin/collectchatroom";
        aVar.dIF = 181;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        pp ppVar = (pp) this.diG.dID.dIL;
        ppVar.rtS = linkedList;
        ppVar.rtR = linkedList.size();
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ab.e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final int getType() {
        return 181;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneCollectChatRoom", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        if (qVar.Id().qWB != 0) {
            this.diJ.a(i2, i3, str, this);
            return;
        }
        if (this.bTM != null) {
            Iterator it = this.bTM.iterator();
            while (it.hasNext()) {
                ali ali = (ali) it.next();
                x.d("MicroMsg.NetSceneCollectChatRoom", "del groupcard Name :" + ali.rNX);
                m.gF(ali.rNX);
            }
        }
        this.diJ.a(i2, i3, str, this);
    }
}
