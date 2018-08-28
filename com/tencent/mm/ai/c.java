package com.tencent.mm.ai;

import android.database.Cursor;
import android.util.Pair;
import com.tencent.mm.a.f;
import com.tencent.mm.ab.v;
import com.tencent.mm.model.am.b;
import com.tencent.mm.model.am.b.a;
import com.tencent.mm.model.au;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.protocal.c.ack;
import com.tencent.mm.protocal.c.acl;
import com.tencent.mm.protocal.c.bhz;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

final class c implements b {
    boolean dGS = false;
    private long dHc = 0;
    private f<String, Integer> dSK = new f(200);
    Map<String, a> dSL = new HashMap();
    Queue<ack> dSM = new LinkedList();
    Queue<a> dSN = new LinkedList();
    long dSO = 0;
    final int dSP = 500;
    final int dSQ = 10000;
    al dSR = new al(au.Em().lnJ.getLooper(), new 1(this), false);
    final al dSS = new al(au.Em().lnJ.getLooper(), new 4(this), true);

    c() {
    }

    public final void iw(String str) {
        this.dSL.remove(str);
    }

    public final void R(String str, String str2) {
        x.i("MicroMsg.GetContactService", "dkverify add Contact :" + str + " chatroom: " + str2 + " stack:" + bi.cjd());
        if (ao(str, str2)) {
            this.dSR.J(500, 500);
        }
    }

    public final void S(String str, String str2) {
        boolean z = false;
        if (!bi.oW(str)) {
            String GF = q.GF();
            String GG = q.GG();
            if (str.equals(GF) || str.equals(GG)) {
                x.i("MicroMsg.GetContactService", "addToStg username: " + str + " equal to user: " + GF + " alias: " + GG + " ret");
            } else {
                a aVar = new a();
                aVar.username = str;
                aVar.dCY = bi.oV(str2);
                aVar.dSJ = bi.f(Integer.valueOf(1));
                aVar.dSH = bi.VF();
                z = d.OK().a(aVar);
            }
        }
        if (z) {
            this.dSR.J(500, 500);
        }
    }

    public final void a(String str, String str2, a aVar) {
        x.i("MicroMsg.GetContactService", "dkverify getNow :" + str + " chatroom: " + str2 + " stack:" + bi.cjd());
        if (ao(str, str2)) {
            this.dSL.put(str, aVar);
            this.dSR.J(0, 0);
        }
    }

    private static boolean ao(String str, String str2) {
        if (bi.oW(str)) {
            return false;
        }
        String GF = q.GF();
        String GG = q.GG();
        if (str.equals(GF) || str.equals(GG)) {
            x.i("MicroMsg.GetContactService", "addToStg username: " + str + " equal to user: " + GF + " alias: " + GG + " ret");
            return false;
        }
        a aVar = new a();
        aVar.username = str;
        aVar.dCX = bi.oV(str2);
        aVar.dSH = bi.VF();
        return d.OK().a(aVar);
    }

    private void OH() {
        String[] strArr = new String[]{String.valueOf(this.dSO), "80"};
        Cursor b = d.OK().dCZ.b("select getcontactinfov2.username,getcontactinfov2.inserttime,getcontactinfov2.type,getcontactinfov2.lastgettime,getcontactinfov2.reserved1,getcontactinfov2.reserved2,getcontactinfov2.reserved3,getcontactinfov2.reserved4 from getcontactinfov2 where inserttime> ?  order by inserttime asc limit ?", strArr, 0);
        if (b != null) {
            x.i("MicroMsg.GetContactService", "getFromDb count:%d", new Object[]{Integer.valueOf(b.getCount())});
            if (b.getCount() <= 0) {
                b.close();
                return;
            }
            int a;
            LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            LinkedList linkedList3 = new LinkedList();
            LinkedList linkedList4 = new LinkedList();
            while (b.moveToNext()) {
                boolean isLast;
                a aVar = new a();
                aVar.username = b.getString(0);
                aVar.dSH = b.getLong(1);
                aVar.type = b.getInt(2);
                aVar.dSI = b.getInt(3);
                aVar.dCV = b.getInt(4);
                aVar.dSJ = b.getInt(5);
                aVar.dCX = b.getString(6);
                aVar.dCY = b.getString(7);
                String username = aVar.getUsername();
                String oV = bi.oV(aVar.IB());
                int f = bi.f(Integer.valueOf(aVar.dSJ));
                String oV2 = bi.oV(aVar.OG());
                this.dSO = aVar.dSH;
                String str = username + "#" + oV;
                a = bi.a((Integer) this.dSK.get(str), 0);
                if (a < 3) {
                    this.dSK.m(str, Integer.valueOf(a + 1));
                    if (f == 1) {
                        linkedList3.add(new Pair(new bhz().VO(username), new bhz().VO(oV2)));
                        x.i("MicroMsg.GetContactService", "getFromDb add user:%s scene:%s ticket:%s", new Object[]{username, Integer.valueOf(f), oV2});
                    } else {
                        linkedList.add(new bhz().VO(username));
                        linkedList2.add(new bhz().VO(oV));
                        x.i("MicroMsg.GetContactService", "getFromDb add user:%s room:%s", new Object[]{username, oV});
                    }
                } else {
                    linkedList4.add(username);
                    ah.A(new 2(this, username));
                }
                if (linkedList.size() < 20) {
                    isLast = b.isLast();
                    if (!isLast) {
                        linkedList = linkedList2;
                        linkedList2 = isLast;
                    }
                }
                ack ack = new ack();
                ack.rgF = linkedList;
                ack.rGU = linkedList.size();
                ack.rGY = linkedList2;
                ack.rGX = linkedList2.size();
                this.dSM.add(ack);
                linkedList2 = new LinkedList();
                isLast = new LinkedList();
                x.i("MicroMsg.GetContactService", "getFromDb now reqlist size:%d , this req usr count:%d", new Object[]{Integer.valueOf(this.dSM.size()), Integer.valueOf(ack.rgF.size())});
                linkedList = linkedList2;
                linkedList2 = isLast;
            }
            b.close();
            Iterator it = linkedList3.iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                ack ack2 = new ack();
                LinkedList linkedList5 = new LinkedList();
                linkedList5.add(pair.first);
                ack2.rgF = linkedList5;
                ack2.rGU = linkedList5.size();
                ack2.rGZ = 1;
                ack2.rHa = (bhz) pair.second;
                this.dSM.add(ack2);
            }
            linkedList3.clear();
            a = 0;
            while (true) {
                int i = a;
                if (i < linkedList4.size()) {
                    String str2 = (String) linkedList4.get(i);
                    x.w("MicroMsg.GetContactService", "getFromDb try getContact Too much room usr:%s; remove from table:%s ", new Object[]{str2, Boolean.valueOf(s.fq(str2))});
                    if (s.fq(str2)) {
                        d.OK().lE(str2);
                    }
                    boolean gX = s.gX(str2);
                    x.w("MicroMsg.GetContactService", "getFromDb try getContact Too much biz usr:%s; remove from table:%s ", new Object[]{str2, Boolean.valueOf(r1)});
                    if (gX) {
                        d.OK().lE(str2);
                        com.tencent.mm.plugin.report.f.mDy.a(832, 3, 1, false);
                    }
                    a = i + 1;
                } else {
                    return;
                }
            }
        }
    }

    final synchronized void OI() {
        if (com.tencent.mm.plugin.subapp.b.ezo.vs()) {
            x.w("MicroMsg.GetContactService", "tryStartNetscene need init , never get contact");
        } else {
            long VF = bi.VF();
            if (this.dGS && VF - this.dHc > 600000) {
                x.w("MicroMsg.GetContactService", "tryStartNetscene Not Callback too long:%d . Force Run Now", new Object[]{Long.valueOf(VF - this.dHc)});
                this.dGS = false;
            }
            if (this.dGS) {
                x.i("MicroMsg.GetContactService", "tryStartNetscene netSceneRunning: " + this.dGS + " ret");
            } else {
                com.tencent.mm.bk.a aVar = (ack) this.dSM.poll();
                if (aVar == null) {
                    OH();
                    aVar = (ack) this.dSM.poll();
                    if (aVar == null || aVar.rgF == null || aVar.rgF.size() == 0) {
                        x.i("MicroMsg.GetContactService", "tryStartNetscene Not any more contact.");
                    }
                }
                this.dHc = VF;
                this.dGS = true;
                com.tencent.mm.ab.b.a aVar2 = new com.tencent.mm.ab.b.a();
                aVar2.dIG = aVar;
                aVar2.dIH = new acl();
                aVar2.uri = "/cgi-bin/micromsg-bin/getcontact";
                aVar2.dIF = com.tencent.mm.plugin.game.gamewebview.jsapi.biz.au.CTRL_BYTE;
                v.a(aVar2.KT(), new 3(this), true);
            }
        }
    }
}
