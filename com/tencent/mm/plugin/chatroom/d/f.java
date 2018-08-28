package com.tencent.mm.plugin.chatroom.d;

import com.tencent.mm.aa.j;
import com.tencent.mm.aa.q;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.g.c.ai;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.m;
import com.tencent.mm.network.k;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.protocal.c.ati;
import com.tencent.mm.protocal.c.atj;
import com.tencent.mm.protocal.c.qn;
import com.tencent.mm.protocal.c.qo;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ay;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class f extends l implements k {
    public int bTS = 0;
    public String bTT;
    public final List<String> bTU;
    public final List<String> bTW;
    public List<String> bTX;
    public List<String> bTY;
    private final b diG;
    private e diJ;
    public final List<String> hKV;

    public f(String str, List<String> list) {
        x.d("MicroMsg.NetSceneCreateChatRoom", "topic : " + str + " size : " + list.size() + " username : " + ((String) list.get(0)));
        a aVar = new a();
        aVar.dIG = new qn();
        aVar.dIH = new qo();
        aVar.uri = "/cgi-bin/micromsg-bin/createchatroom";
        aVar.dIF = 119;
        aVar.dII = 37;
        aVar.dIJ = 1000000037;
        this.diG = aVar.KT();
        qn qnVar = (qn) this.diG.dID.dIL;
        qnVar.ruR = ab.oT(str);
        LinkedList linkedList = new LinkedList();
        for (String str2 : list) {
            ati ati = new ati();
            ati.rvo = ab.oT(str2);
            linkedList.add(ati);
        }
        qnVar.rbQ = linkedList;
        qnVar.hLg = linkedList.size();
        this.bTU = new LinkedList();
        this.hKV = new LinkedList();
        this.bTW = new LinkedList();
        this.bTX = new LinkedList();
        this.bTY = new LinkedList();
        this.bTT = "";
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final int getType() {
        return 119;
    }

    private static boolean a(qo qoVar) {
        boolean z = false;
        if (!ab.a(qoVar.rbR).toLowerCase().endsWith("@chatroom") || qoVar.hLg == 0) {
            x.e("MicroMsg.NetSceneCreateChatRoom", "CreateChatroom: room:[" + qoVar.rbR + "] listCnt:" + qoVar.hLg);
            return false;
        }
        com.tencent.mm.storage.ab abVar = new com.tencent.mm.storage.ab();
        abVar.dx(ab.a(qoVar.ruR));
        abVar.dy(ab.a(qoVar.ruT));
        abVar.dz(ab.a(qoVar.ruU));
        abVar.setUsername(ab.a(qoVar.rbR));
        au.HU();
        ay FR = c.FR();
        if (!FR.Yi(abVar.field_username)) {
            FR.T(abVar);
        }
        j jVar = new j();
        jVar.username = abVar.field_username;
        jVar.dHR = qoVar.rqZ;
        jVar.dHQ = qoVar.rra;
        jVar.csA = 3;
        jVar.by(false);
        jVar.bWA = -1;
        q.KH().a(jVar);
        ArrayList arrayList = new ArrayList();
        while (true) {
            boolean z2 = z;
            if (z2 >= qoVar.rbQ.size()) {
                break;
            }
            if (((atj) qoVar.rbQ.get(z2)).rWG == 0) {
                ai aiVar;
                com.tencent.mm.storage.ab Yg = FR.Yg(ab.a(((atj) qoVar.rbQ.get(z2)).rvo));
                if (((int) Yg.dhP) != 0) {
                    Yg.Ba();
                    FR.a(Yg.field_username, Yg);
                    aiVar = Yg;
                } else {
                    aiVar = m.a(Yg, (atj) qoVar.rbQ.get(z2));
                    FR.T(aiVar);
                }
                arrayList.add(aiVar.field_username);
            }
            z = z2 + 1;
        }
        if (!arrayList.contains(com.tencent.mm.model.q.GF())) {
            arrayList.add(com.tencent.mm.model.q.GF());
            x.d("MicroMsg.NetSceneCreateChatRoom", "respon has not self add one " + arrayList.contains(com.tencent.mm.model.q.GF()));
        }
        return m.a(abVar.field_username, arrayList, com.tencent.mm.model.q.GF());
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneCreateChatRoom", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        qo qoVar = (qo) this.diG.dIE.dIL;
        this.bTT = ab.a(qoVar.rbR);
        int i4 = this.diG.dIE.qWB;
        this.bTS = qoVar.hLg;
        aC(qoVar.rbQ);
        if (!bi.oW(this.bTT) && i4 == 0) {
            a(qoVar);
        }
        this.diJ.a(i2, i3, str, this);
    }

    private void aC(List<atj> list) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                i = ((atj) list.get(i2)).rWG;
                if (i == 0) {
                    this.bTY.add(ab.a(((atj) list.get(i2)).rvo));
                } else if (i == 3) {
                    x.d("MicroMsg.NetSceneCreateChatRoom", " blacklist : " + ((atj) list.get(i2)).rvo);
                    this.hKV.add(ab.a(((atj) list.get(i2)).rvo));
                } else if (i == 1) {
                    x.d("MicroMsg.NetSceneCreateChatRoom", " not user : " + ((atj) list.get(i2)).rvo);
                    this.bTW.add(ab.a(((atj) list.get(i2)).rvo));
                } else if (i == 2) {
                    x.d("MicroMsg.NetSceneCreateChatRoom", " invalid username : " + ((atj) list.get(i2)).rvo);
                    this.bTU.add(ab.a(((atj) list.get(i2)).rvo));
                } else if (i == 4) {
                    x.d("MicroMsg.NetSceneCreateChatRoom", " verify user : " + ((atj) list.get(i2)).rvo);
                    this.bTX.add(ab.a(((atj) list.get(i2)).rvo));
                } else if (!(i == 5 || i == 6)) {
                    x.w("MicroMsg.NetSceneCreateChatRoom", "unknown member status : status = " + i);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }
}
