package com.tencent.mm.plugin.account.friend.a;

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
import com.tencent.mm.protocal.c.afh;
import com.tencent.mm.protocal.c.afi;
import com.tencent.mm.protocal.c.arr;
import com.tencent.mm.protocal.c.ars;
import com.tencent.mm.protocal.c.atu;
import com.tencent.mm.protocal.c.bqd;
import com.tencent.mm.protocal.c.qt;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class ab extends l implements k {
    public b diG;
    private e diJ = null;
    private List<String> eHv;
    private List<String> eKV;

    public ab() {
        XN();
        afh afh = (afh) this.diG.dID.dIL;
        afh.rwt = "";
        afh.rJq = null;
        afh.rJp = 0;
        afh.rJo = null;
        afh.rJn = 0;
        afh.jRb = 0;
        afh.otY = 1;
    }

    public ab(List<String> list, List<String> list2) {
        XN();
        if ((list != null && list.size() != 0) || (list2 != null && list2.size() != 0)) {
            this.eHv = list;
            this.eKV = list2;
            afh afh = (afh) this.diG.dID.dIL;
            afh.rwt = "";
            afh.jRb = 2;
            afh.otY = 1;
        }
    }

    private void XN() {
        a aVar = new a();
        aVar.dIG = new afh();
        aVar.dIH = new afi();
        aVar.uri = "/cgi-bin/micromsg-bin/getmfriend";
        aVar.dIF = 142;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
    }

    public final void XO() {
        afh afh = (afh) this.diG.dID.dIL;
        afh.rwt = (String) g.Ei().DT().get(65828, null);
        afh.jRb = 1;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        afh afh = (afh) this.diG.dID.dIL;
        if (afh.jRb == 2) {
            if ((this.eHv == null || this.eHv.size() == 0) && (this.eKV == null || this.eKV.size() == 0)) {
                x.e("MicroMsg.NetSceneGetMFriend", "doScene failed, mobile list and email list empty.");
                return -1;
            }
            LinkedList linkedList;
            if (this.eHv != null && this.eHv.size() > 0) {
                x.d("MicroMsg.NetSceneGetMFriend", "doScene get mobile list size:%d", Integer.valueOf(this.eHv.size()));
                linkedList = new LinkedList();
                for (String str : this.eHv) {
                    atu atu = new atu();
                    atu.v = str;
                    linkedList.add(atu);
                }
                afh.rJo = linkedList;
                afh.rJn = linkedList.size();
            }
            if (this.eKV != null && this.eKV.size() > 0) {
                x.d("MicroMsg.NetSceneGetMFriend", "doScene get email list size:%d", Integer.valueOf(this.eKV.size()));
                linkedList = new LinkedList();
                for (String str2 : this.eKV) {
                    arr arr = new arr();
                    arr.v = str2;
                    linkedList.add(arr);
                }
                afh.rJq = linkedList;
                afh.rJp = linkedList.size();
            }
        }
        return a(eVar, this.diG, this);
    }

    public final int getType() {
        return 32;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        afi afi = (afi) this.diG.dIE.dIL;
        afh afh = (afh) this.diG.dID.dIL;
        if (i2 == 4 && i3 == -68) {
            this.diJ.a(i2, i3, afi.six.rgv.siM, this);
        } else if (i2 == 0 && i3 == 0) {
            x.d("MicroMsg.NetSceneGetMFriend", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
            String oV = bi.oV((String) g.Ei().DT().get(65828, null));
            if (!(afh.jRb != 1 || bi.oW(afi.rwt) || afi.rwt.equals(oV))) {
                g.Ei().DT().set(65828, afi.rwt);
                ((h) ((com.tencent.mm.plugin.account.a.a.a) g.n(com.tencent.mm.plugin.account.a.a.a.class)).getFacebookFrdStg()).Xw();
            }
            if (afi.jTa == null) {
                x.e("MicroMsg.NetSceneGetMFriend", "onGYNetEnd  friendlist null");
                return;
            }
            x.i("MicroMsg.NetSceneGetMFriend", "onGYNetEnd friend list size:%d", Integer.valueOf(afi.jTa.size()));
            long dO = g.Ei().dqq.dO(Thread.currentThread().getId());
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 < afi.jTa.size()) {
                    ars ars = (ars) afi.jTa.get(i5);
                    if (ars == null) {
                        x.e("MicroMsg.NetSceneGetMFriend", "Err getFriendList null");
                    } else {
                        a pq = ((b) ((com.tencent.mm.plugin.account.a.a.a) g.n(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).pq(ars.eJG);
                        if (pq != null || afh.jRb == 1) {
                            com.tencent.mm.plugin.d.a.ZN().Gw().fX(ars.rdS, ars.rEJ);
                            g gVar = new g();
                            if (afh.jRb == 1) {
                                if (ars.rTX == null) {
                                    x.e("MicroMsg.NetSceneGetMFriend", "ERR: facebook friend return null info");
                                } else {
                                    gVar.csC = ars.rTX.mFa;
                                    gVar.eKb = ars.rTX.ryv;
                                    c.jH(ars.rTX.mFa);
                                    gVar.eKa = ars.rTX.jPe;
                                    gVar.cCR = ars.eJM;
                                    gVar.csL = ars.eJJ;
                                    gVar.csK = ars.eJI;
                                    gVar.signature = ars.eJK;
                                    gVar.csJ = ars.eJL;
                                    gVar.sex = ars.eJH;
                                    gVar.bgn = ars.rTW;
                                    gVar.eJA = h.oJ(ars.rTX.jPe);
                                    gVar.eJB = h.oI(ars.rTX.jPe);
                                    gVar.username = ars.rdS;
                                }
                            } else if (bi.oW(ars.rdS)) {
                                x.w("MicroMsg.NetSceneGetMFriend", "username null for mobile");
                            }
                            j jVar = new j();
                            jVar.username = ars.rdS;
                            jVar.csK = ars.eJI;
                            jVar.csL = ars.eJJ;
                            jVar.signature = ars.eJK;
                            jVar.sex = ars.eJH;
                            jVar.csJ = ars.eJL;
                            ai aiVar = null;
                            if (!bi.oW(ars.rdS)) {
                                ai Yg = ((i) g.l(i.class)).FR().Yg(ars.rdS);
                                if (Yg == null || !ars.rdS.equals(Yg.field_username)) {
                                    aiVar = null;
                                } else if (bi.oW(ars.eJM) || ars.eJM.equals(Yg.wM())) {
                                    aiVar = Yg;
                                } else {
                                    Yg.du(ars.eJM);
                                    ((i) g.l(i.class)).FR().a(Yg.field_username, Yg);
                                    aiVar = Yg;
                                }
                            }
                            if (bi.oW(ars.rdS)) {
                                Assert.assertTrue("mobile friend never go here", afh.jRb == 1);
                                gVar.status = 102;
                            } else if (aiVar == null || !com.tencent.mm.l.a.gd(aiVar.field_type)) {
                                gVar.status = 100;
                                if (pq != null) {
                                    x.v("MicroMsg.NetSceneGetMFriend", "onGYNetEnd update status on, nick:" + ars.rTW + " realName:" + pq.Xj() + "  MFriend:" + ars.toString());
                                    pq.status = 1;
                                    pq.username = ars.rdS;
                                    pq.bgn = ars.rTW;
                                    pq.eJA = h.oJ(ars.rTX.jPe);
                                    pq.eJB = h.oI(ars.rTX.jPe);
                                    pq.eJF = pq.AY();
                                    a(pq, ars);
                                    pq.bWA = -1;
                                    ((b) ((com.tencent.mm.plugin.account.a.a.a) g.n(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).a(pq.Xh(), pq);
                                    j jVar2 = new j();
                                    jVar2.username = ars.rdS;
                                    jVar2.dHR = ars.rqZ;
                                    jVar2.dHQ = ars.rra;
                                    jVar2.by(true);
                                    jVar2.csA = 3;
                                    com.tencent.mm.aa.q.KH().a(jVar2);
                                }
                            } else {
                                gVar.status = 101;
                                if (pq != null) {
                                    x.v("MicroMsg.NetSceneGetMFriend", "onGYNetEnd update status friend, nick:" + ars.rTW + "  md5:" + ars.eJG);
                                    pq.status = 2;
                                    pq.username = ars.rdS;
                                    pq.bgn = ars.rTW;
                                    pq.eJF = pq.AY();
                                    a(pq, ars);
                                    pq.bWA = -1;
                                    ((b) ((com.tencent.mm.plugin.account.a.a.a) g.n(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).a(pq.Xh(), pq);
                                    c.J(ars.rdS, 3);
                                }
                            }
                            if (afh.jRb == 1) {
                                ((h) ((com.tencent.mm.plugin.account.a.a.a) g.n(com.tencent.mm.plugin.account.a.a.a.class)).getFacebookFrdStg()).a(gVar);
                            }
                            ((k) ((com.tencent.mm.plugin.account.a.a.a) g.n(com.tencent.mm.plugin.account.a.a.a.class)).getFrdExtStg()).a(jVar);
                        } else {
                            x.e("MicroMsg.NetSceneGetMFriend", "Err MD5 not found is AddrUploadStg, nickName: " + ars.rTW + " md5: " + ars.eJG);
                        }
                    }
                    i4 = i5 + 1;
                } else {
                    g.Ei().dqq.gp(dO);
                    this.diJ.a(i2, i3, str, this);
                    return;
                }
            }
        } else {
            x.e("MicroMsg.NetSceneGetMFriend", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
            this.diJ.a(i2, i3, str, this);
        }
    }

    private static void a(a aVar, ars ars) {
        aVar.eJG = ars.eJG;
        aVar.eJH = ars.eJH;
        aVar.eJI = ars.eJI;
        aVar.eJJ = ars.eJJ;
        aVar.eJK = ars.eJK;
        aVar.eJL = ars.eJL;
        aVar.eJM = ars.eJM;
        aVar.eJN = ars.eJN;
        aVar.eJP = ars.eJP;
        aVar.eJO = ars.eJO;
        aVar.eJQ = ars.eJQ;
        aVar.eJR = ars.eJR;
        bqd bqd = ars.rTk;
        if (bqd != null) {
            aVar.eJS = bqd.eJS;
            aVar.eJT = bqd.eJT;
            aVar.eJU = bqd.eJU;
        }
        qt qtVar = ars.rTl;
        if (qtVar != null) {
            aVar.eJV = qtVar.eJV;
            aVar.eJW = qtVar.eJW;
            aVar.eJX = qtVar.eJX;
            aVar.eJY = qtVar.eJY;
        }
    }
}
