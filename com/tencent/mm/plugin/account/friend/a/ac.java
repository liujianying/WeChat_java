package com.tencent.mm.plugin.account.friend.a;

import android.database.Cursor;
import com.tencent.mm.a.o;
import com.tencent.mm.aa.c;
import com.tencent.mm.aa.j;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.g.c.ai;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.h;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.protocal.c.agu;
import com.tencent.mm.protocal.c.agv;
import com.tencent.mm.protocal.c.bcv;
import com.tencent.mm.protocal.c.bcx;
import com.tencent.mm.protocal.c.bcy;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ac extends l implements k {
    public final b diG;
    private e diJ = null;

    public ac(int i) {
        a aVar = new a();
        aVar.dIG = new agu();
        aVar.dIH = new agv();
        aVar.uri = "/cgi-bin/micromsg-bin/getqqgroup";
        aVar.dIF = 143;
        aVar.dII = 38;
        aVar.dIJ = 1000000038;
        this.diG = aVar.KT();
        agu agu = (agu) this.diG.dID.dIL;
        agu.jRb = 1;
        agu.rKb = i;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        agu agu = (agu) this.diG.dID.dIL;
        if (agu.jRb != 1 || ((an) ((com.tencent.mm.plugin.account.a.a.a) g.n(com.tencent.mm.plugin.account.a.a.a.class)).getQQGroupStg()).jf(agu.rKb) != null) {
            return a(eVar, this.diG, this);
        }
        x.e("MicroMsg.NetSceneGetQQGroup", "Err group not exist");
        return -1;
    }

    public final int getType() {
        return 143;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        if (i2 == 0 && i3 == 0) {
            x.d("MicroMsg.NetSceneGetQQGroup", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
            agu agu = (agu) this.diG.dID.dIL;
            agv agv = (agv) this.diG.dIE.dIL;
            if (agu.jRb == 0) {
                a(agv.rKc);
            } else {
                ao aoVar;
                List<ao> arrayList = new ArrayList();
                List arrayList2 = new ArrayList();
                List arrayList3 = new ArrayList();
                int i4 = 0;
                while (true) {
                    int i5 = i4;
                    if (i5 >= agv.rKd.hbF) {
                        break;
                    }
                    Object obj;
                    j jVar;
                    j jVar2;
                    bcv bcv = (bcv) agv.rKd.sfc.get(i5);
                    int i6 = agu.rKb;
                    x.v("MicroMsg.NetSceneGetQQGroup", "friend");
                    ao aoVar2 = new ao();
                    aoVar2.eLw = new o(bcv.seY).longValue();
                    c.d(aoVar2.eLw, 3);
                    aoVar2.eLy = i6;
                    aoVar2.eLx = bcv.sfa;
                    if (bcv.sfa != 0) {
                        if (bcv.hbL == null || bcv.hbL.equals("")) {
                            obj = null;
                            arrayList.add(obj);
                            jVar = new j();
                            jVar.sex = bcv.eJH;
                            jVar.csJ = bcv.eJL;
                            jVar.csK = bcv.eJI;
                            jVar.csL = bcv.eJJ;
                            jVar.signature = bcv.eJK;
                            jVar.username = bcv.hbL;
                            arrayList2.add(jVar);
                            jVar2 = new j();
                            jVar2.csA = 3;
                            jVar2.by(true);
                            jVar2.username = bcv.hbL;
                            jVar2.dHR = bcv.rqZ;
                            jVar2.dHQ = bcv.rra;
                            arrayList3.add(jVar2);
                            i4 = i5 + 1;
                        } else {
                            ai Yg = ((i) g.l(i.class)).FR().Yg(bcv.hbL);
                            if (Yg != null && Yg.field_username.equals(bcv.hbL) && com.tencent.mm.l.a.gd(Yg.field_type)) {
                                aoVar2.eLx = 2;
                            } else {
                                aoVar2.eLx = 1;
                            }
                        }
                    }
                    aoVar2.username = bcv.hbL;
                    aoVar2.nickname = bcv.hcS;
                    aoVar2.eLE = bcv.sfb;
                    aoVar2.eLF = h.oJ(bcv.sfb);
                    aoVar2.eLG = h.oI(bcv.sfb);
                    aoVar2.eLz = h.oJ(bcv.hcS);
                    aoVar2.eLA = h.oI(bcv.hcS);
                    aoVar2.eLB = bcv.seZ;
                    aoVar2.eLC = h.oJ(bcv.seZ);
                    aoVar2.eLD = h.oI(bcv.seZ);
                    i6 = 32;
                    if (!bi.oW(aoVar2.Ya())) {
                        i6 = aoVar2.Ya().charAt(0);
                    } else if (!bi.oW(aoVar2.Yb())) {
                        i6 = aoVar2.Yb().charAt(0);
                    } else if (!bi.oW(aoVar2.XX())) {
                        i6 = aoVar2.XX().charAt(0);
                    } else if (!bi.oW(aoVar2.XY())) {
                        i6 = aoVar2.XY().charAt(0);
                    }
                    if (i6 >= 97 && i6 <= 122) {
                        i6 = (char) (i6 - 32);
                    } else if (i6 < 65 || i6 > 90) {
                        i6 = 123;
                    }
                    aoVar2.dHN = i6;
                    com.tencent.mm.plugin.d.a.ZN().Gw().fX(bcv.hbL, bcv.rEJ);
                    x.v("MicroMsg.NetSceneGetQQGroup", "QQ Friend nickname: " + aoVar2.XW() + "  remark: " + aoVar2.XZ());
                    ao obj2 = aoVar2;
                    arrayList.add(obj2);
                    jVar = new j();
                    jVar.sex = bcv.eJH;
                    jVar.csJ = bcv.eJL;
                    jVar.csK = bcv.eJI;
                    jVar.csL = bcv.eJJ;
                    jVar.signature = bcv.eJK;
                    jVar.username = bcv.hbL;
                    arrayList2.add(jVar);
                    jVar2 = new j();
                    jVar2.csA = 3;
                    jVar2.by(true);
                    jVar2.username = bcv.hbL;
                    jVar2.dHR = bcv.rqZ;
                    jVar2.dHQ = bcv.rra;
                    arrayList3.add(jVar2);
                    i4 = i5 + 1;
                }
                HashMap hashMap = new HashMap();
                ap apVar = (ap) ((com.tencent.mm.plugin.account.a.a.a) g.n(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg();
                i4 = agu.rKb;
                x.d("MicroMsg.QQListStorage", "getByGroupID: GroupID:" + i4);
                Cursor b = apVar.dCZ.b("select qqlist.qq,qqlist.wexinstatus,qqlist.groupid,qqlist.username,qqlist.nickname,qqlist.pyinitial,qqlist.quanpin,qqlist.qqnickname,qqlist.qqpyinitial,qqlist.qqquanpin,qqlist.qqremark,qqlist.qqremarkpyinitial,qqlist.qqremarkquanpin,qqlist.reserved1,qqlist.reserved2,qqlist.reserved3,qqlist.reserved4 from qqlist  where qqlist.groupid = \"" + i4 + "\"", null, 0);
                while (b.moveToNext()) {
                    aoVar = new ao();
                    aoVar.d(b);
                    hashMap.put(Long.valueOf(aoVar.eLw), aoVar);
                }
                b.close();
                for (ao aoVar3 : arrayList) {
                    if (hashMap.containsKey(Long.valueOf(aoVar3.eLw))) {
                        ao aoVar4 = (ao) hashMap.get(Long.valueOf(aoVar3.eLw));
                        Object obj3 = !bi.t(Long.valueOf(aoVar4.eLw), Long.valueOf(aoVar3.eLw)) ? null : !bi.t(Integer.valueOf(aoVar4.eLx), Integer.valueOf(aoVar3.eLx)) ? null : !bi.t(Integer.valueOf(aoVar4.eLy), Integer.valueOf(aoVar3.eLy)) ? null : !bi.t(aoVar4.username, aoVar3.username) ? null : !bi.t(aoVar4.nickname, aoVar3.nickname) ? null : !bi.t(aoVar4.eLz, aoVar3.eLz) ? null : !bi.t(aoVar4.eLA, aoVar3.eLA) ? null : !bi.t(aoVar4.eLB, aoVar3.eLB) ? null : !bi.t(aoVar4.eLC, aoVar3.eLC) ? null : !bi.t(aoVar4.eLD, aoVar3.eLD) ? null : !bi.t(aoVar4.eLE, aoVar3.eLE) ? null : !bi.t(aoVar4.eLF, aoVar3.eLF) ? null : !bi.t(aoVar4.eLG, aoVar3.eLG) ? null : !bi.t(aoVar4.dHL, aoVar3.dHL) ? null : !bi.t(aoVar4.dHM, aoVar3.dHM) ? null : !bi.t(Integer.valueOf(aoVar4.dHN), Integer.valueOf(aoVar3.dHN)) ? null : !bi.t(Integer.valueOf(aoVar4.dHO), Integer.valueOf(aoVar3.dHO)) ? null : 1;
                        if (obj3 == null) {
                            ((ap) ((com.tencent.mm.plugin.account.a.a.a) g.n(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).a(aoVar3.eLw, aoVar3);
                            hashMap.remove(Long.valueOf(aoVar3.eLw));
                        }
                    } else {
                        ((ap) ((com.tencent.mm.plugin.account.a.a.a) g.n(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).a(aoVar3);
                    }
                }
                for (Long longValue : hashMap.keySet()) {
                    long longValue2 = longValue.longValue();
                    apVar = (ap) ((com.tencent.mm.plugin.account.a.a.a) g.n(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg();
                    x.d("MicroMsg.QQListStorage", "delete: QQ:" + longValue2);
                    if (apVar.dCZ.delete("qqlist", "qq= ?", new String[]{String.valueOf(longValue2)}) > 0) {
                        apVar.b(5, apVar, String.valueOf(longValue2));
                    }
                }
                ((k) ((com.tencent.mm.plugin.account.a.a.a) g.n(com.tencent.mm.plugin.account.a.a.a.class)).getFrdExtStg()).L(arrayList2);
                com.tencent.mm.aa.q.KH().L(arrayList3);
                am amVar = new am();
                amVar.eLo = agu.rKb;
                amVar.eLt = 0;
                amVar.eLs = (int) bi.VE();
                amVar.bWA = 48;
                ((an) ((com.tencent.mm.plugin.account.a.a.a) g.n(com.tencent.mm.plugin.account.a.a.a.class)).getQQGroupStg()).a(amVar);
            }
            this.diJ.a(i2, i3, str, this);
            return;
        }
        x.e("MicroMsg.NetSceneGetQQGroup", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        this.diJ.a(i2, i3, str, this);
    }

    private static void a(bcy bcy) {
        Map map;
        am amVar;
        an anVar;
        boolean z;
        Cursor b = ((an) ((com.tencent.mm.plugin.account.a.a.a) g.n(com.tencent.mm.plugin.account.a.a.a.class)).getQQGroupStg()).dCZ.b("select qqgroup.grouopid,qqgroup.membernum,qqgroup.weixinnum,qqgroup.insert_time,qqgroup.lastupdate_time,qqgroup.needupdate,qqgroup.updatekey,qqgroup.groupname from qqgroup ", null, 0);
        if (b == null) {
            map = null;
        } else if (b.getCount() <= 0) {
            b.close();
            map = null;
        } else {
            map = new HashMap();
            for (int i = 0; i < b.getCount(); i++) {
                b.moveToPosition(i);
                amVar = new am();
                amVar.d(b);
                map.put(Integer.valueOf(amVar.eLo), amVar);
            }
            b.close();
        }
        for (int i2 = 0; i2 < bcy.hbF; i2++) {
            bcx bcx = (bcx) bcy.sfe.get(i2);
            x.d("MicroMsg.NetSceneGetQQGroup", "id:" + bcx.rKb + " name:" + bcx.rDt + " mem:" + bcx.rxJ + " wei:" + bcx.sfd + " md5:" + bcx.rwt);
            if (bcx.rKb < 0) {
                amVar = null;
            } else {
                amVar = new am();
                amVar.eLo = bcx.rKb;
                amVar.eLv = bcx.rDt;
                amVar.eLp = bcx.rxJ;
                amVar.eLq = bcx.sfd;
                amVar.eLu = bcx.rwt;
            }
            if (amVar == null) {
                x.e("MicroMsg.NetSceneGetQQGroup", "Error Resp Group Info index:" + i2);
            } else if (amVar.eLp != 0) {
                am amVar2;
                if (map != null) {
                    amVar2 = (am) map.get(Integer.valueOf(amVar.eLo));
                } else {
                    amVar2 = null;
                }
                if (amVar2 == null) {
                    amVar.eLr = (int) bi.VE();
                    amVar.eLs = (int) bi.VE();
                    amVar.eLt = 1;
                    anVar = (an) ((com.tencent.mm.plugin.account.a.a.a) g.n(com.tencent.mm.plugin.account.a.a.a.class)).getQQGroupStg();
                    if (amVar != null) {
                        x.d("MicroMsg.QQGroupStorage", "insert: name:" + amVar.XU());
                        amVar.bWA = -1;
                        if (((int) anVar.dCZ.insert("qqgroup", "grouopid", amVar.XS())) >= 0) {
                            anVar.doNotify();
                            z = true;
                            x.d("MicroMsg.NetSceneGetQQGroup", "Insert name:" + amVar.XU() + " ret:" + z);
                        }
                    }
                    z = false;
                    x.d("MicroMsg.NetSceneGetQQGroup", "Insert name:" + amVar.XU() + " ret:" + z);
                } else {
                    amVar2.eLt = -1;
                    x.d("MicroMsg.NetSceneGetQQGroup", amVar.XT() + " " + amVar2.XT() + " " + amVar.eLo);
                    if (!amVar2.XT().equals(amVar.XT())) {
                        amVar.eLs = (int) bi.VE();
                        amVar.eLt = 1;
                        amVar.bWA = -1;
                        x.d("MicroMsg.NetSceneGetQQGroup", "Update name:" + amVar.XU() + " ret:" + ((an) ((com.tencent.mm.plugin.account.a.a.a) g.n(com.tencent.mm.plugin.account.a.a.a.class)).getQQGroupStg()).a(amVar));
                    }
                }
            }
        }
        if (map != null) {
            for (Object obj : map.keySet()) {
                am amVar3 = (am) map.get(obj);
                if (amVar3.eLt == 0) {
                    anVar = (an) ((com.tencent.mm.plugin.account.a.a.a) g.n(com.tencent.mm.plugin.account.a.a.a.class)).getQQGroupStg();
                    x.d("MicroMsg.QQGroupStorage", "delete: id:" + amVar3.eLo);
                    if (anVar.dCZ.delete("qqgroup", "grouopid= ?", new String[]{String.valueOf(r6)}) > 0) {
                        anVar.doNotify();
                        z = true;
                    } else {
                        z = false;
                    }
                    x.d("MicroMsg.NetSceneGetQQGroup", "delete name:" + amVar3.XU() + " ret:" + z);
                    ap apVar = (ap) ((com.tencent.mm.plugin.account.a.a.a) g.n(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg();
                    x.d("MicroMsg.QQListStorage", "delete: GroupID:" + amVar3.eLo);
                    if (apVar.dCZ.delete("qqlist", "groupid= ?", new String[]{String.valueOf(r6)}) > 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    x.d("MicroMsg.NetSceneGetQQGroup", "delete QQList name:" + amVar3.XU() + " ret:" + z);
                }
            }
        }
    }
}
