package com.tencent.mm.plugin.chatroom.d;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.m;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.protocal.c.qy;
import com.tencent.mm.protocal.c.qz;
import com.tencent.mm.protocal.c.rh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.List;

public final class g extends l implements k {
    public List<String> bTR;
    private b diG;
    private e diJ;

    public g(String str, List<String> list) {
        this(str, list, 0);
    }

    public g(String str, List<String> list, int i) {
        a aVar = new a();
        aVar.dIG = new qy();
        aVar.dIH = new qz();
        aVar.uri = "/cgi-bin/micromsg-bin/delchatroommember";
        aVar.dIF = 179;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        qy qyVar = (qy) this.diG.dID.dIL;
        qyVar.rvj = str;
        LinkedList linkedList = new LinkedList();
        for (String str2 : list) {
            rh rhVar = new rh();
            rhVar.rvo = ab.oT(str2);
            linkedList.add(rhVar);
        }
        qyVar.rbQ = linkedList;
        qyVar.hLg = linkedList.size();
        qyVar.otY = i;
        this.bTR = list;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final int getType() {
        return 179;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneDelChatRoomMember", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        qy qyVar = (qy) this.diG.dID.dIL;
        qz qzVar = (qz) this.diG.dIE.dIL;
        if (this.diG.dIE.qWB != 0) {
            this.diJ.a(i2, i3, str, this);
            return;
        }
        m.a(qyVar.rvj, qzVar);
        this.diJ.a(i2, i3, str, this);
    }
}
