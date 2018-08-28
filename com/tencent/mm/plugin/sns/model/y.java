package com.tencent.mm.plugin.sns.model;

import android.database.Cursor;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.qm;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.protocal.c.ate;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.protocal.c.boy;
import com.tencent.mm.protocal.c.bpz;
import com.tencent.mm.protocal.c.bqa;
import com.tencent.mm.protocal.c.cg;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.z;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;

public final class y extends l implements k, d {
    private static Vector<String> nnU = new Vector();
    public int Ma = 0;
    final int bJt;
    private b diG;
    public e diJ;
    private boolean eet = false;
    public boolean nnR;
    private long nnS = 0;
    long nnT = 0;
    public int nnV = 0;
    public int nnW = 0;
    private long noK = 0;
    private boolean noL = false;
    private boolean noM = false;
    private long nos = 0;
    private String not = "";

    public static synchronized boolean Mb(String str) {
        boolean z;
        synchronized (y.class) {
            if (nnU.contains(str)) {
                z = false;
            } else {
                nnU.add(str);
                z = true;
            }
        }
        return z;
    }

    public static synchronized boolean Mc(String str) {
        synchronized (y.class) {
            nnU.remove(str);
        }
        return true;
    }

    public y(long j) {
        int i;
        long j2;
        long currentTimeMillis = System.currentTimeMillis();
        a aVar = new a();
        aVar.dIG = new bpz();
        aVar.dIH = new bqa();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnstimeline";
        aVar.dIF = 211;
        aVar.dII = 98;
        aVar.dIJ = 1000000098;
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
        this.nnS = j;
        this.nnR = j == 0;
        this.bJt = 2;
        bpz bpz = (bpz) this.diG.dID.dIL;
        bpz.snU = i;
        bpz.smv = j;
        int byM = af.bye().byM();
        o byo = af.byo();
        if (this.nnR) {
            j2 = 0;
        } else {
            j2 = j;
        }
        this.nnT = byo.e(j2, byM, true);
        bpz.snR = this.nnT;
        bpz.snS = c.a(this.nnT, j, "@__weixintimtline");
        if (this.nnR) {
            this.nos = af.byo().e(0, 1, true);
            x.i("MicroMsg.NetSceneSnsTimeLine", "newerid " + this.nos);
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
                x.d("MicroMsg.NetSceneSnsTimeLine", "request adsession %s", new Object[]{Np.field_adsession});
                bpz.slZ = new bhy().bq(Np.field_adsession);
            }
        }
        this.noK = j;
        x.i("MicroMsg.NetSceneSnsTimeLine", " This req nextCount: " + byM + " max:" + j + " min:" + this.nnT + " ReqTime:" + bpz.snS + " nettype: " + i);
        x.d("MicroMsg.NetSceneSnsTimeLine", "maxId: %s minId: %s lastReqTime: %s", new Object[]{i.eF(j), i.eF(this.nnT), Integer.valueOf(r3)});
        x.d("MicroMsg.NetSceneSnsTimeLine", "NetSceneSnsTimeLine %s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
    }

    private void bxL() {
        o byo = af.byo();
        Cursor b = byo.diF.b(o.bBz(), null, 2);
        int i = 0;
        while (b.moveToNext()) {
            i++;
        }
        b.close();
        if (i < 3 && i > 0) {
            this.noM = true;
        } else if (i == 0) {
            this.noL = true;
        }
    }

    private void a(bqa bqa, String str) {
        aj.a("@__weixintimtline", this.bJt, bqa.rgH, str);
        this.nnT = ((boy) bqa.rgH.getLast()).rlK;
        if (this.nnS == 0) {
            this.nnS = ((boy) bqa.rgH.getFirst()).rlK;
        } else {
            this.nnS = c.eJ(this.nnS);
        }
        c.d("@__weixintimtline", this.nnS, this.nnT, bqa.snV);
        try {
            Iterator it = bqa.rgH.iterator();
            while (it.hasNext()) {
                boy boy = (boy) it.next();
                if (boy.smS == 0) {
                    n fi = af.byo().fi(boy.rlK);
                    if (!(fi == null || fi.bAJ() == null || fi.field_type != 15)) {
                        try {
                            String str2 = ((ate) fi.bAJ().sqc.ruA.get(0)).jPK;
                            h.mEJ.h(14388, new Object[]{Long.valueOf(boy.rlK), Integer.valueOf(4), str2, Integer.valueOf(0)});
                        } catch (Exception e) {
                        }
                    }
                }
            }
        } catch (Exception e2) {
        }
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneSnsTimeLine", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        bqa bqa = (bqa) ((b) qVar).dIE.dIL;
        if (qVar.Id().qWB == 207 || qVar.Id().qWB == 0) {
            int i4;
            if (bqa.smA != null) {
                x.d("MicroMsg.NetSceneSnsTimeLine", "serverConfig  " + bqa.smA.snN + " " + bqa.smA.snM);
                i4 = bqa.smA.snN;
                com.tencent.mm.plugin.sns.c.a.nkE = i4;
                if (i4 <= 0) {
                    com.tencent.mm.plugin.sns.c.a.nkE = Integer.MAX_VALUE;
                }
                z.sOr = bqa.smA.snM;
            }
            this.nnV = bqa.smy;
            this.nnW = bqa.smz;
            x.i("MicroMsg.NetSceneSnsTimeLine", "for same md5 count: " + bqa.smy + " , objCount:  " + bqa.rXE + " cflag : " + bqa.smz);
            this.Ma = bqa.rXE;
            String eG = i.eG(this.nnS);
            if (bqa.rgH.isEmpty()) {
                x.i("MicroMsg.NetSceneSnsTimeLine", " respone is Empty");
            } else {
                x.i("MicroMsg.NetSceneSnsTimeLine", "respone size " + bqa.rgH.size() + " Max " + ((boy) bqa.rgH.getFirst()).rlK + " " + i.eF(((boy) bqa.rgH.getFirst()).rlK) + "  respone min  " + ((boy) bqa.rgH.getLast()).rlK + " " + i.eF(((boy) bqa.rgH.getLast()).rlK));
            }
            if (this.nnR) {
                this.Ma = bqa.rXE;
                if (this.not.equals(bqa.smu)) {
                    this.nnT = af.byo().e(this.nnR ? 0 : this.noK, this.nnV, true);
                    x.i("MicroMsg.NetSceneSnsTimeLine", "md5 is no change!! the new minid %s", new Object[]{Long.valueOf(this.nnT)});
                    bxL();
                    Mc("@__weixintimtline");
                    this.diJ.a(i2, i3, str, this);
                    return;
                }
                cg cgVar;
                String str2;
                String a;
                x.d("MicroMsg.NetSceneSnsTimeLine", "fp resp list size " + bqa.rgH.size() + " adsize : " + bqa.snW);
                af.bys().f("@__weixintimtline", bqa.smu, ab.a(bqa.slZ));
                i4 = 0;
                while (true) {
                    int i5 = i4;
                    if (i5 >= bqa.snX.size()) {
                        break;
                    }
                    cgVar = (cg) bqa.snX.get(i5);
                    if (this.eet) {
                        str2 = af.Gq() + "ad.proto";
                        try {
                            byte[] toByteArray = cgVar.toByteArray();
                            com.tencent.mm.a.e.b(str2, toByteArray, toByteArray.length);
                        } catch (Exception e) {
                            x.e("MicroMsg.NetSceneSnsTimeLine", "save error " + e.getMessage());
                        }
                    }
                    str2 = ab.a(cgVar.rcC);
                    a = ab.a(cgVar.rcB.slY);
                    String b = ab.b(cgVar.rcB.slX.smH);
                    x.i("MicroMsg.NetSceneSnsTimeLine", "skXml " + str2);
                    x.i("MicroMsg.NetSceneSnsTimeLine", "adXml " + a);
                    x.i("MicroMsg.NetSceneSnsTimeLine", "snsXml " + b + "\r\n");
                    i4 = i5 + 1;
                }
                if (this.eet && bqa.snX.size() == 0) {
                    try {
                        byte[] f = com.tencent.mm.a.e.f(af.Gq() + "ad.proto", 0, -1);
                        cg cgVar2 = new cg();
                        cgVar2.aG(f);
                        bqa.snX.add(cgVar2);
                        bqa.snW = bqa.snX.size();
                        x.d("MicroMsg.NetSceneSnsTimeLine", "read from path " + bqa.snW);
                        if (bqa.snX.size() > 0) {
                            cgVar = (cg) bqa.snX.get(0);
                            String a2 = ab.a(cgVar.rcC);
                            str2 = ab.a(cgVar.rcB.slY);
                            a = ab.b(cgVar.rcB.slX.smH);
                            x.i("MicroMsg.NetSceneSnsTimeLine", "skXml " + a2);
                            x.i("MicroMsg.NetSceneSnsTimeLine", "adXml " + str2);
                            x.i("MicroMsg.NetSceneSnsTimeLine", "snsXml " + a + "\r\n");
                            b(cgVar);
                        }
                    } catch (Exception e2) {
                        x.e("MicroMsg.NetSceneSnsTimeLine", "read error " + e2.getMessage());
                    }
                }
                a.e(bqa.snX, bqa.rgH);
                a.ad(bqa.snX);
                if (bqa.snW == 0) {
                    x.i("MicroMsg.NetSceneSnsTimeLine", "recv %d recommend", new Object[]{Integer.valueOf(bqa.snY)});
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
                        this.nnT = this.nnS;
                    } else {
                        af.byo().Nr(i.eG(((boy) bqa.rgH.getFirst()).rlK));
                        af.byo().Nq(i.eG(((boy) bqa.rgH.getLast()).rlK));
                        a(bqa, eG);
                        a.ae(bqa.rgH);
                    }
                    this.noL = true;
                    Mc("@__weixintimtline");
                    this.diJ.a(i2, i3, str, this);
                    return;
                }
                if (bqa.rgH.isEmpty()) {
                    af.byo().bBv();
                    this.nnT = this.nnS;
                    this.noL = true;
                } else {
                    a(bqa, eG);
                    a.ae(bqa.rgH);
                }
                Mc("@__weixintimtline");
                this.diJ.a(i2, i3, str, this);
                return;
            }
            x.d("MicroMsg.NetSceneSnsTimeLine", "np resp list size " + bqa.rgH.size());
            if (bqa.rgH.isEmpty()) {
                af.byo().Nq(eG);
                this.noL = true;
                this.nnT = this.nnS;
            } else {
                a(bqa, eG);
            }
            Mc("@__weixintimtline");
            this.diJ.a(i2, i3, str, this);
            return;
        }
        Mc("@__weixintimtline");
        this.diJ.a(i2, i3, str, this);
    }

    private static boolean b(cg cgVar) {
        if (!ao.isWifi(ad.getContext())) {
            return false;
        }
        try {
            com.tencent.mm.modelsns.e.ng(ab.b(cgVar.rcB.slX.smH));
            af.byj();
            b.bxs();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public final int getType() {
        return 211;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final String getUserName() {
        return "@__weixintimtline";
    }

    public final boolean bxu() {
        return this.nnR;
    }

    public final boolean bxv() {
        return this.noL;
    }

    public final boolean bxw() {
        return this.noM;
    }

    public final boolean bxx() {
        return false;
    }

    public final long bxy() {
        return this.nnT;
    }

    public final boolean bxz() {
        return false;
    }

    public final long bxA() {
        return 0;
    }
}
