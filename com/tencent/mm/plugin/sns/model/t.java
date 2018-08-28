package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.qm;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.c.ate;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.protocal.c.boy;
import com.tencent.mm.protocal.c.bpz;
import com.tencent.mm.protocal.c.bqa;
import com.tencent.mm.protocal.c.cg;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.av;
import com.tencent.mm.storage.z;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class t extends l implements k {
    public int Ma = 0;
    final int bJt;
    private b diG;
    public e diJ;
    private long nnT = 0;
    public int nnV = 0;
    public int nnW = 0;
    private long nos = 0;
    private String not = "";

    public t() {
        int i;
        a aVar = new a();
        aVar.dIG = new bpz();
        aVar.dIH = new bqa();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnspreloadingtimeline";
        aVar.dIF = 718;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        if (ao.isWifi(ad.getContext())) {
            i = 1;
        } else if (ao.is3G(ad.getContext())) {
            i = 3;
        } else if (ao.is4G(ad.getContext())) {
            i = 4;
        } else if (ao.is2G(ad.getContext())) {
            i = 2;
        } else {
            i = 0;
        }
        this.bJt = 2;
        bpz bpz = (bpz) this.diG.dID.dIL;
        bpz.snU = i;
        bpz.smv = 0;
        int byM = af.bye().byM();
        this.nnT = af.byo().e(0, byM, true);
        bpz.snR = this.nnT;
        bpz.snS = c.a(this.nnT, 0, "@__weixintimtline");
        this.nos = af.byo().e(0, 1, true);
        x.i("MicroMsg.NetSceneSnsPreTimeLine", "newerid " + this.nos);
        bpz.snT = this.nos;
        com.tencent.mm.plugin.sns.storage.l Np = af.bys().Np("@__weixintimtline");
        this.not = Np == null ? "" : Np.field_md5;
        if (this.not == null) {
            this.not = "";
        }
        bpz.smu = this.not;
        if (Np == null || Np.field_adsession == null) {
            bpz.slZ = new bhy().bq(new byte[0]);
        } else {
            x.d("MicroMsg.NetSceneSnsPreTimeLine", "request adsession %s", new Object[]{Np.field_adsession});
            bpz.slZ = new bhy().bq(Np.field_adsession);
        }
        x.i("MicroMsg.NetSceneSnsPreTimeLine", " This req nextCount: " + byM + " min:" + this.nnT + " ReqTime:" + bpz.snS + " nettype: " + i);
        x.d("MicroMsg.NetSceneSnsPreTimeLine", "minId: %s lastReqTime: %s", new Object[]{i.eF(this.nnT), Integer.valueOf(r7)});
    }

    private void a(bqa bqa, String str) {
        aj.a("@__weixintimtline", this.bJt, bqa.rgH, str);
        this.nnT = ((boy) bqa.rgH.getLast()).rlK;
        c.d("@__weixintimtline", ((boy) bqa.rgH.getFirst()).rlK, this.nnT, bqa.snV);
        Iterator it = bqa.rgH.iterator();
        while (it.hasNext()) {
            boy boy = (boy) it.next();
            if (boy.smS == 0) {
                n fi = af.byo().fi(boy.rlK);
                if (!(fi == null || fi.bAJ() == null)) {
                    List<ate> list = fi.bAJ().sqc.ruA;
                    for (ate ate : list) {
                        Object obj = list.size() <= 1 ? 1 : null;
                        if (ate != null) {
                            String e = i.e(ate);
                            int i = obj != null ? 1 : 0;
                            String s = an.s(af.getAccSnsPath(), ate.ksA);
                            if (FileOp.cn(s + e) || FileOp.cn(s + i.l(ate)) || FileOp.cn(s + i.m(ate))) {
                                x.i("MicroMsg.NetSceneSnsPreTimeLine", "dealwithMedia exist:%s", new Object[]{ate.ksA});
                            } else {
                                x.i("MicroMsg.NetSceneSnsPreTimeLine", "dealwithMedia ready to download:%s", new Object[]{ate.ksA});
                                com.tencent.mm.plugin.sns.data.e eVar = new com.tencent.mm.plugin.sns.data.e(ate);
                                eVar.nkQ = i;
                                eVar.kJG = ate.ksA;
                                af.byj().a(ate, ate.hcE == 6 ? 5 : 1, eVar, av.tbm);
                            }
                        }
                    }
                    if (fi.field_type == 15) {
                        ar bym = af.bym();
                        if (fi != null) {
                            x.i("MicroMsg.SnsVideoService", "%d add preload video[%s]", new Object[]{Integer.valueOf(bym.hashCode()), fi.bBe()});
                            synchronized (bym.nrM) {
                                bym.nrM.addFirst(fi);
                            }
                        }
                        try {
                            String str2 = ((ate) fi.bAJ().sqc.ruA.get(0)).jPK;
                            h.mEJ.h(14388, new Object[]{Long.valueOf(boy.rlK), Integer.valueOf(4), str2, Integer.valueOf(0)});
                        } catch (Exception e2) {
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        af.bym().byR();
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneSnsPreTimeLine", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        bqa bqa = (bqa) ((b) qVar).dIE.dIL;
        if (qVar.Id().qWB == 207 || qVar.Id().qWB == 0) {
            int i4;
            if (bqa.smA != null) {
                x.d("MicroMsg.NetSceneSnsPreTimeLine", "serverConfig  " + bqa.smA.snN + " " + bqa.smA.snM);
                i4 = bqa.smA.snN;
                com.tencent.mm.plugin.sns.c.a.nkE = i4;
                if (i4 <= 0) {
                    com.tencent.mm.plugin.sns.c.a.nkE = Integer.MAX_VALUE;
                }
                z.sOr = bqa.smA.snM;
            }
            this.nnV = bqa.smy;
            this.nnW = bqa.smz;
            x.i("MicroMsg.NetSceneSnsPreTimeLine", "for same md5 count: " + bqa.smy + " , objCount:  " + bqa.rXE + " cflag : " + bqa.smz);
            this.Ma = bqa.rXE;
            String eG = i.eG(0);
            if (bqa.rgH.isEmpty()) {
                x.i("MicroMsg.NetSceneSnsPreTimeLine", " respone is Empty");
            } else {
                x.i("MicroMsg.NetSceneSnsPreTimeLine", "respone size " + bqa.rgH.size() + " Max " + ((boy) bqa.rgH.getFirst()).rlK + " " + i.eF(((boy) bqa.rgH.getFirst()).rlK) + "  respone min  " + ((boy) bqa.rgH.getLast()).rlK + " " + i.eF(((boy) bqa.rgH.getLast()).rlK));
            }
            this.Ma = bqa.rXE;
            if (this.not.equals(bqa.smu)) {
                this.nnT = af.byo().e(0, this.nnV, true);
                x.i("MicroMsg.NetSceneSnsPreTimeLine", "md5 is no change!! the new minid %s", new Object[]{Long.valueOf(this.nnT)});
                y.Mc("@__weixintimtline");
                this.diJ.a(i2, i3, str, this);
                return;
            }
            x.d("MicroMsg.NetSceneSnsPreTimeLine", "fp resp list size " + bqa.rgH.size() + " adsize : " + bqa.snW);
            af.bys().f("@__weixintimtline", bqa.smu, ab.a(bqa.slZ));
            i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 >= bqa.snX.size()) {
                    break;
                }
                cg cgVar = (cg) bqa.snX.get(i5);
                String a = ab.a(cgVar.rcC);
                String a2 = ab.a(cgVar.rcB.slY);
                String b = ab.b(cgVar.rcB.slX.smH);
                x.i("MicroMsg.NetSceneSnsPreTimeLine", "skXml " + a);
                x.i("MicroMsg.NetSceneSnsPreTimeLine", "adXml " + a2);
                x.i("MicroMsg.NetSceneSnsPreTimeLine", "snsXml " + b + "\r\n");
                i4 = i5 + 1;
            }
            a.e(bqa.snX, bqa.rgH);
            a.ad(bqa.snX);
            if (bqa.snW == 0) {
                x.i("MicroMsg.NetSceneSnsPreTimeLine", "recv %d recommend", new Object[]{Integer.valueOf(bqa.snY)});
                a.d(bqa.snZ, bqa.rgH);
                a.ac(bqa.snZ);
            }
            LinkedList linkedList = new LinkedList();
            Iterator it = bqa.rgH.iterator();
            while (it.hasNext()) {
                linkedList.add(Long.valueOf(((boy) it.next()).rlK));
            }
            qm qmVar = new qm();
            qmVar.cba.cbb = linkedList;
            com.tencent.mm.sdk.b.a.sFg.m(qmVar);
            if (qVar.Id().qWB == 207) {
                if (bqa.rgH.isEmpty()) {
                    af.byo().bBv();
                } else {
                    af.byo().Nr(i.eG(((boy) bqa.rgH.getFirst()).rlK));
                    af.byo().Nq(i.eG(((boy) bqa.rgH.getLast()).rlK));
                    a(bqa, eG);
                    a.ae(bqa.rgH);
                }
                y.Mc("@__weixintimtline");
                this.diJ.a(i2, i3, str, this);
                return;
            }
            if (bqa.rgH.isEmpty()) {
                af.byo().bBv();
            } else {
                a(bqa, eG);
                a.ae(bqa.rgH);
            }
            y.Mc("@__weixintimtline");
            this.diJ.a(i2, i3, str, this);
            return;
        }
        y.Mc("@__weixintimtline");
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return 718;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }
}
