package com.tencent.mm.plugin.chatroom.d;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.m;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.protocal.c.ati;
import com.tencent.mm.protocal.c.atj;
import com.tencent.mm.protocal.c.bn;
import com.tencent.mm.protocal.c.bo;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class d extends l implements k {
    public int bSU = 0;
    public final List<String> bTR;
    public final List<String> bTU;
    public final List<String> bTW;
    public final List<String> bTX;
    public String chatroomName = null;
    private final b diG;
    private e diJ = null;
    public final List<String> hKU;
    public final List<String> hKV;
    public final List<String> hKW;

    public d(String str, List<String> list, String str2) {
        a aVar = new a();
        aVar.dIG = new bn();
        aVar.dIH = new bo();
        aVar.uri = "/cgi-bin/micromsg-bin/addchatroommember";
        aVar.dIF = 120;
        aVar.dII = 36;
        aVar.dIJ = 1000000036;
        this.diG = aVar.KT();
        bn bnVar = (bn) this.diG.dID.dIL;
        bnVar.rbR = ab.oT(str);
        this.chatroomName = str;
        LinkedList linkedList = new LinkedList();
        for (String str3 : list) {
            ati ati = new ati();
            ati.rvo = ab.oT(str3);
            linkedList.add(ati);
        }
        bnVar.rbQ = linkedList;
        bnVar.hLg = linkedList.size();
        this.hKU = new ArrayList();
        this.bTU = new LinkedList();
        this.hKV = new LinkedList();
        this.bTW = new LinkedList();
        this.bTX = new LinkedList();
        this.hKW = new ArrayList();
        this.bTR = list;
        bnVar.rbT = str2;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final int getType() {
        return 120;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        bn bnVar = (bn) this.diG.dID.dIL;
        bo boVar = (bo) this.diG.dIE.dIL;
        this.bSU = boVar.hLg;
        List list = boVar.rbQ;
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= list.size()) {
                break;
            }
            i4 = ((atj) list.get(i5)).rWG;
            if (i4 == 0) {
                this.hKU.add(ab.a(((atj) list.get(i5)).rvo));
            } else if (i4 == 3) {
                x.d("MicroMsg.NetSceneAddChatRoomMember", " blacklist : " + ((atj) list.get(i5)).rvo);
                this.hKV.add(ab.a(((atj) list.get(i5)).rvo));
            } else if (i4 == 1) {
                x.d("MicroMsg.NetSceneAddChatRoomMember", " not user : " + ((atj) list.get(i5)).rvo);
                this.bTW.add(ab.a(((atj) list.get(i5)).rvo));
            } else if (i4 == 2) {
                x.d("MicroMsg.NetSceneAddChatRoomMember", " invalid username : " + ((atj) list.get(i5)).rvo);
                this.bTU.add(ab.a(((atj) list.get(i5)).rvo));
            } else if (i4 == 4) {
                x.d("MicroMsg.NetSceneAddChatRoomMember", " verify user : " + ((atj) list.get(i5)).rvo);
                this.bTX.add(ab.a(((atj) list.get(i5)).rvo));
            } else if (i4 != 5) {
                if (i4 == 6) {
                    this.hKW.add(ab.a(((atj) list.get(i5)).rvo));
                } else {
                    x.w("MicroMsg.NetSceneAddChatRoomMember", "unknown member status : status = " + i4);
                }
            }
            i4 = i5 + 1;
        }
        this.diJ.a(i2, i3, str, this);
        if (i2 == 0 && i3 == 0) {
            m.a(ab.a(bnVar.rbR), boVar);
        }
    }
}
