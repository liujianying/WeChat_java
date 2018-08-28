package com.tencent.mm.plugin.chatroom.d;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.protocal.c.anu;
import com.tencent.mm.protocal.c.anv;
import com.tencent.mm.protocal.c.ati;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import java.util.LinkedList;
import java.util.List;

public final class k extends l implements com.tencent.mm.network.k {
    public bd bXQ;
    private final b diG;
    private e diJ;
    public int hLg;

    public k(String str, List<String> list) {
        a aVar = new a();
        aVar.dIG = new anu();
        aVar.dIH = new anv();
        aVar.uri = "/cgi-bin/micromsg-bin/invitechatroommember";
        aVar.dIF = 610;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        anu anu = (anu) this.diG.dID.dIL;
        LinkedList linkedList = new LinkedList();
        for (String str2 : list) {
            ati ati = new ati();
            ati.rvo = ab.oT(str2);
            linkedList.add(ati);
        }
        anu.rbQ = linkedList;
        anu.hLg = linkedList.size();
        anu.rbR = ab.oT(str);
        anu.rQx = 0;
    }

    public k(String str, List<String> list, String str2, bd bdVar) {
        this.bXQ = bdVar;
        a aVar = new a();
        aVar.dIG = new anu();
        aVar.dIH = new anv();
        aVar.uri = "/cgi-bin/micromsg-bin/invitechatroommember";
        aVar.dIF = 610;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        anu anu = (anu) this.diG.dID.dIL;
        LinkedList linkedList = new LinkedList();
        for (String str3 : list) {
            ati ati = new ati();
            ati.rvo = ab.oT(str3);
            linkedList.add(ati);
        }
        this.hLg = linkedList.size();
        anu.rbQ = linkedList;
        anu.hLg = linkedList.size();
        anu.rbR = ab.oT(str);
        anu.rQx = 2;
        anu.rQy = str2;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final int getType() {
        return 610;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneInviteChatRoomMember", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        this.diJ.a(i2, i3, str, this);
    }
}
