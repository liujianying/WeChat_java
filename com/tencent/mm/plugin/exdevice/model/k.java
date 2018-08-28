package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.ac.d;
import com.tencent.mm.ac.z;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.protocal.c.aue;
import com.tencent.mm.protocal.c.bqd;
import com.tencent.mm.protocal.c.gg;
import com.tencent.mm.protocal.c.gh;
import com.tencent.mm.protocal.c.gi;
import com.tencent.mm.protocal.c.gj;
import com.tencent.mm.protocal.c.gk;
import com.tencent.mm.protocal.c.qt;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.RegionCodeDecoder;
import java.util.Iterator;
import java.util.LinkedList;

public final class k extends l implements com.tencent.mm.network.k {
    private e doG = null;
    private b ivx = null;
    private String[] ivy;

    public k(String[] strArr, String str) {
        this.ivy = strArr;
        x.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "NetSceneBatchSearchHardDevice, %s, list = %d", new Object[]{str, Integer.valueOf(1)});
        a aVar = new a();
        aVar.dIG = new gi();
        aVar.dIH = new gj();
        aVar.dIF = 542;
        aVar.uri = "/cgi-bin/micromsg-bin/batchsearchharddevice";
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.ivx = aVar.KT();
        gi giVar = (gi) this.ivx.dID.dIL;
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i <= 0; i++) {
            String str2 = strArr[0];
            if (str2 != null) {
                gh ghVar = new gh();
                ghVar.rgL = str2;
                linkedList.add(ghVar);
                x.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "NetSceneBatchSearchHardDevice, item = %s", new Object[]{str2});
            }
        }
        giVar.rgM = linkedList;
        if (!bi.oW(str)) {
            gg ggVar = new gg();
            ggVar.rgK = str;
            giVar.rgN = ggVar;
        }
        giVar.rgO = 3;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "onGYNetEnd, netId = %d, errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (this.ivy != null && this.ivy.length == 1) {
            x.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "device mac is  = %s", new Object[]{this.ivy[0]});
        }
        if (qVar == null) {
            x.e("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "null == rr");
        } else if (this.ivx.dIF != qVar.getType()) {
            x.e("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "mReqResp.getType(%d) != rr.getType(%d)", new Object[]{Integer.valueOf(this.ivx.dIF), Integer.valueOf(qVar.getType())});
        } else {
            if (i2 == 0 && i3 == 0) {
                Iterator it = aGW().rgP.iterator();
                while (it.hasNext()) {
                    gk gkVar = (gk) it.next();
                    x.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "BatchSearchHardDeviceResp, ret = %d, bind ticket = %s, mac = %s, device name = %s", new Object[]{Integer.valueOf(gkVar.rfn), gkVar.rgQ, gkVar.rgL, gkVar.hbP});
                    if (gkVar.rgR == null) {
                        x.e("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "null == item.Contact");
                    } else {
                        aue aue = gkVar.rgR;
                        if (aue == null) {
                            x.e("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "unable to parse mod contact");
                        } else {
                            String a = ab.a(aue.rvi);
                            String oV = bi.oV(aue.rXj);
                            if (bi.oW(a) && bi.oW(oV)) {
                                x.e("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "processModContact user is null user:%s enuser:%s", new Object[]{a, oV});
                            } else {
                                x.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "processModContact : %s", new Object[]{a});
                                au.HU();
                                com.tencent.mm.storage.ab Yg = c.FR().Yg(a);
                                if (Yg == null || !a.equals(Yg.field_encryptUsername)) {
                                    com.tencent.mm.storage.ab abVar = new com.tencent.mm.storage.ab(a);
                                    abVar.du(aue.eJM);
                                    abVar.setType(aue.ruj & aue.ruk);
                                    if (!bi.oW(oV)) {
                                        abVar.dD(oV);
                                    } else if (Yg != null && ((int) Yg.dhP) > 0) {
                                        abVar.dD(Yg.field_encryptUsername);
                                    }
                                    abVar.dhP = Yg == null ? 0 : (long) ((int) Yg.dhP);
                                    abVar.dx(ab.a(aue.rQz));
                                    abVar.dy(ab.a(aue.ruT));
                                    abVar.dz(ab.a(aue.ruU));
                                    abVar.eJ(aue.eJH);
                                    abVar.eM(aue.rup);
                                    abVar.dw(ab.a(aue.rXd));
                                    abVar.eN(aue.rut);
                                    abVar.eO(aue.eJL);
                                    abVar.dS(RegionCodeDecoder.aq(aue.eJQ, aue.eJI, aue.eJJ));
                                    abVar.dM(aue.eJK);
                                    abVar.eF(aue.rTe);
                                    abVar.dR(aue.rTf);
                                    abVar.setSource(aue.rdq);
                                    abVar.eE(aue.rTi);
                                    abVar.dA(aue.rTh);
                                    if (s.hU(aue.rTg)) {
                                        abVar.dQ(aue.rTg);
                                    }
                                    abVar.eQ((int) bi.VE());
                                    abVar.dv(ab.a(aue.rWH));
                                    abVar.dB(ab.a(aue.rWJ));
                                    abVar.dC(ab.a(aue.rWI));
                                    abVar.dT(aue.rej);
                                    abVar.dU(aue.rXt);
                                    if (!(Yg == null || bi.oV(Yg.csU).equals(bi.oV(aue.rXt)))) {
                                        com.tencent.mm.at.c.Qt();
                                        com.tencent.mm.at.c.mA(a);
                                    }
                                    au.HU();
                                    c.FR().Yl(a);
                                    if (bi.oW(abVar.field_username)) {
                                        x.e("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "dkinit dealModContactExtInfo failed invalid contact");
                                    } else {
                                        String str2 = abVar.field_username;
                                        com.tencent.mm.aa.q.KH().a(com.tencent.mm.aa.c.a(str2, aue));
                                        bqd bqd = aue.rTk;
                                        if (!(abVar.field_username.endsWith("@chatroom") || bqd == null)) {
                                            x.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "SnsFlag modcontact " + bqd.eJS + " " + aue.rvi);
                                            x.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "SnsBg modcontact " + bqd.eJT);
                                            x.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "SnsBgId modcontact " + bqd.eJU);
                                            x.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "SnsBgId modcontact " + bqd.sod);
                                            if (n.nky != null) {
                                                n.nky.a(abVar.field_username, bqd);
                                            }
                                        }
                                        String GF = com.tencent.mm.model.q.GF();
                                        if (!(GF == null || GF.equals(str2))) {
                                            d kA = z.MY().kA(str2);
                                            kA.field_username = str2;
                                            kA.field_brandList = aue.eJR;
                                            qt qtVar = aue.rTl;
                                            if (qtVar != null) {
                                                kA.field_brandFlag = qtVar.eJV;
                                                kA.field_brandInfo = qtVar.eJX;
                                                kA.field_brandIconURL = qtVar.eJY;
                                                kA.field_extInfo = qtVar.eJW;
                                                kA.field_attrSyncVersion = null;
                                                kA.field_incrementUpdateTime = 0;
                                            }
                                            if (!z.MY().e(kA)) {
                                                z.MY().d(kA);
                                            }
                                            abVar.eR(kA.field_type);
                                        }
                                    }
                                    abVar.eH(aue.rXs);
                                    if (!(aue.rXo == null || aue.rXo.rcy == null)) {
                                        abVar.dV(aue.rXo.rcy.rhn);
                                        abVar.dW(aue.rXo.rcy.rho);
                                        abVar.dX(aue.rXo.rcy.rhp);
                                    }
                                    if (s.hO(a)) {
                                        abVar.Bk();
                                    }
                                    if (abVar.ckW()) {
                                        abVar.Bn();
                                    }
                                    if (bi.oW(oV)) {
                                        au.HU();
                                        c.FR().S(abVar);
                                    } else {
                                        au.HU();
                                        c.FR().b(oV, abVar);
                                    }
                                    if (!(Yg == null || (Yg.field_type & 2048) == (abVar.field_type & 2048))) {
                                        if ((abVar.field_type & 2048) != 0) {
                                            au.HU();
                                            c.FW().Yv(abVar.field_username);
                                        } else {
                                            au.HU();
                                            c.FW().Yw(abVar.field_username);
                                        }
                                    }
                                } else {
                                    x.w("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "cat's replace user with stranger");
                                }
                            }
                        }
                    }
                }
            }
            this.doG.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 542;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.doG = eVar2;
        return a(eVar, this.ivx, this);
    }

    public final gj aGW() {
        if (this.ivx == null || this.ivx.dIE.dIL == null) {
            return null;
        }
        return (gj) this.ivx.dIE.dIL;
    }
}
