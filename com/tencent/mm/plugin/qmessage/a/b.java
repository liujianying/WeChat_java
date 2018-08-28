package com.tencent.mm.plugin.qmessage.a;

import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.g.a.rk;
import com.tencent.mm.g.c.ai;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.protocal.c.fy;
import com.tencent.mm.protocal.c.fz;
import com.tencent.mm.protocal.c.pz;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import junit.framework.Assert;

public final class b extends l implements k {
    private e diJ;
    private Set<String> mbt;

    public b(Set<String> set) {
        Assert.assertTrue(true);
        this.mbt = set;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        List<String> linkedList = new LinkedList();
        for (String add : this.mbt) {
            linkedList.add(add);
        }
        if (linkedList.size() == 0) {
            x.e("MicroMsg.NetSceneBatchGetContactProfile", g.Ac() + "doScene reqSize ==0");
            return -1;
        }
        a aVar = new a();
        aVar.dIG = new fy();
        aVar.dIH = new fz();
        aVar.uri = "/cgi-bin/micromsg-bin/batchgetcontactprofile";
        aVar.dIF = 140;
        aVar.dII = 28;
        aVar.dIJ = 1000000028;
        q KT = aVar.KT();
        LinkedList linkedList2 = new LinkedList();
        for (String add2 : linkedList) {
            linkedList2.add(ab.oT(add2));
        }
        ((fy) KT.dID.dIL).rgF = linkedList2;
        ((fy) KT.dID.dIL).rgE = 1;
        ((fy) KT.dID.dIL).hbF = linkedList2.size();
        return a(eVar, KT, this);
    }

    protected final int a(q qVar) {
        return b.dJm;
    }

    public final int getType() {
        return 140;
    }

    protected final int Cc() {
        return 50;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        if (i2 == 0 && i3 == 0) {
            if (h(qVar) && this.mbt.size() > 0) {
                a(this.dIX, this.diJ);
            }
            x.d("MicroMsg.NetSceneBatchGetContactProfile", "left cnt = " + this.mbt.size());
            this.diJ.a(i2, i3, str, this);
            return;
        }
        this.diJ.a(i2, i3, str, this);
    }

    private boolean h(q qVar) {
        fz fzVar = (fz) ((com.tencent.mm.ab.b) qVar).dIE.dIL;
        if (fzVar == null) {
            x.e("MicroMsg.NetSceneBatchGetContactProfile", "dealResp: resp is null");
            return false;
        } else if (qVar.Id().qWB == 1) {
            x.e("MicroMsg.NetSceneBatchGetContactProfile", "dealResp : endless loop, should stop");
            return false;
        } else if (qVar.Id().qWB == -1) {
            x.e("MicroMsg.NetSceneBatchGetContactProfile", "dealResp : server err, can try again");
            return true;
        } else {
            List list = fzVar.rgG;
            if (list == null) {
                return false;
            }
            for (int i = 0; i < list.size(); i++) {
                pz pzVar;
                boolean z;
                try {
                    pzVar = (pz) new pz().aG(ab.a((bhy) list.get(i)));
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.NetSceneBatchGetContactProfile", e, "", new Object[0]);
                    x.e("MicroMsg.NetSceneBatchGetContactProfile", "ContactProfile.parseFrom fail");
                    pzVar = null;
                }
                if (pzVar == null || pzVar.hbL == null) {
                    x.e("MicroMsg.NetSceneBatchGetContactProfile", "processContactProfile: profile name is null");
                    z = false;
                } else if (this.mbt.contains(pzVar.hbL)) {
                    this.mbt.remove(pzVar.hbL);
                    au.HU();
                    ai Yg = c.FR().Yg(pzVar.hbL);
                    if (Yg == null || ((int) Yg.dhP) == 0) {
                        x.e("MicroMsg.NetSceneBatchGetContactProfile", "processContactProfile: did not find this contact");
                        z = false;
                    } else {
                        Yg.setUsername(pzVar.hbL);
                        Yg.du(pzVar.eJM);
                        Yg.setType(pzVar.ruj & pzVar.ruk);
                        Yg.dx(pzVar.hcS);
                        Yg.dy(pzVar.ruh);
                        Yg.dz(pzVar.rui);
                        Yg.eJ(pzVar.eJH);
                        Yg.dv(pzVar.rul);
                        Yg.dB(pzVar.ruo);
                        Yg.dC(pzVar.run);
                        Yg.eM(pzVar.rup);
                        Yg.dw(pzVar.rus);
                        Yg.eN(pzVar.rut);
                        au.HU();
                        if (c.FR().a(Yg.field_username, Yg) == -1) {
                            x.e("MicroMsg.NetSceneBatchGetContactProfile", "processContactProfile:update contact failed");
                        }
                        if (com.tencent.mm.storage.ab.XQ(pzVar.hbL)) {
                            d JM = g.boc().JM(pzVar.hbL);
                            if (JM == null || bi.oV(JM.getUsername()).length() <= 0) {
                                x.e("MicroMsg.NetSceneBatchGetContactProfile", "processContactProfile: did not find qcontact");
                                z = false;
                            } else {
                                JM.extInfo = pzVar.jTB;
                                JM.mbw = (long) pzVar.ruv;
                                JM.mbx = (long) pzVar.ruw;
                                JM.bWA = 52;
                                if (!g.boc().a(pzVar.hbL, JM)) {
                                    x.e("MicroMsg.NetSceneBatchGetContactProfile", "processContactProfile:update qcontact failed");
                                }
                            }
                        }
                        if (com.tencent.mm.storage.ab.XO(pzVar.hbL)) {
                            rk rkVar = new rk();
                            rkVar.ccg.opType = 0;
                            rkVar.ccg.bWJ = pzVar.hbL;
                            rkVar.ccg.bWK = pzVar.ruv;
                            rkVar.ccg.bWL = pzVar.rum;
                            com.tencent.mm.sdk.b.a.sFg.m(rkVar);
                        }
                        z = true;
                    }
                } else {
                    x.e("MicroMsg.NetSceneBatchGetContactProfile", "processContactProfile: resp data not in req");
                    z = false;
                }
                if (!z) {
                    return false;
                }
            }
            return true;
        }
    }
}
