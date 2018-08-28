package com.tencent.mm.modelfriend;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.ab.l.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.av;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bnp;
import com.tencent.mm.protocal.c.brj;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.m;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;

public final class a extends l implements k {
    public static a dRB;
    public final q dJM;
    private int dJp;
    e diJ;

    public a(String str, String str2, String str3, String str4, String str5, String str6) {
        this(str, 11, str2, str3, str4);
        com.tencent.mm.protocal.m.a aVar = (com.tencent.mm.protocal.m.a) this.dJM.KV();
        aVar.qWG.rhz = str5;
        aVar.qWG.rhA = str6;
    }

    public a(String str, int i, String str2, String str3, String str4) {
        this(str, i, str2, 0, str3);
        ((com.tencent.mm.protocal.m.a) this.dJM.KV()).qWG.reE = str4;
    }

    public a(String str, int i, String str2, int i2, String str3) {
        this.diJ = null;
        this.dJp = 2;
        this.dJM = new b();
        com.tencent.mm.protocal.m.a aVar = (com.tencent.mm.protocal.m.a) this.dJM.KV();
        aVar.qWG.rfe = i;
        x.d("MicroMsg.NetSceneBindMobileForReg", "Get mobile:" + str + " opcode:" + i + " verifyCode:" + str2);
        aVar.qWG.rhu = str;
        aVar.qWG.rhv = str2;
        aVar.qWG.rhw = i2;
        aVar.qWG.rhx = str3;
        aVar.qWG.iwP = w.chP();
        aVar.qWG.reS = com.tencent.mm.kernel.a.DA();
        if (bi.oW(aVar.qWG.rhz) && bi.oW(aVar.qWG.rhA)) {
            aVar.qWG.rhz = dRB != null ? dRB.Ox() : "";
            aVar.qWG.rhA = d.DEVICE_NAME;
        }
    }

    public final void hG(int i) {
        ((com.tencent.mm.protocal.m.a) this.dJM.KV()).qWG.rhC = i;
    }

    public final void hH(int i) {
        ((com.tencent.mm.protocal.m.a) this.dJM.KV()).qWG.rhD = i;
    }

    public final int Oh() {
        return ((com.tencent.mm.protocal.m.a) this.dJM.KV()).qWG.rfe;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        com.tencent.mm.protocal.m.a aVar = (com.tencent.mm.protocal.m.a) this.dJM.KV();
        if (aVar.qWG.rhu == null || aVar.qWG.rhu.length() <= 0) {
            x.e("MicroMsg.NetSceneBindMobileForReg", "doScene getMobile Error: " + aVar.qWG.rhu);
            return -1;
        } else if ((aVar.qWG.rfe != 6 && aVar.qWG.rfe != 9) || (aVar.qWG.rhv != null && aVar.qWG.rhv.length() > 0)) {
            return a(eVar, this.dJM, this);
        } else {
            x.e("MicroMsg.NetSceneBindMobileForReg", "doScene getVerifyCode Error: " + aVar.qWG.rhu);
            return -1;
        }
    }

    public final int getType() {
        return 145;
    }

    protected final int Cc() {
        return 3;
    }

    protected final int a(q qVar) {
        return b.dJm;
    }

    protected final void a(com.tencent.mm.ab.l.a aVar) {
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneBindMobileForReg", "dkidc onGYNetEnd  errType:%d errCode:%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        m.b bVar = (m.b) qVar.Id();
        if (bVar == null || bVar.qWH == null) {
            x.i("MicroMsg.NetSceneBindMobileForReg", "summerauth mmtls bindopreg not set as ret:%s", new Object[]{bVar});
        } else {
            int i4 = bVar.qWH.reI;
            x.i("MicroMsg.NetSceneBindMobileForReg", "summerauth mmtls bindopreg:%s", new Object[]{Integer.valueOf(i4)});
            g.Ek();
            g.Ei().dqk.set(47, Integer.valueOf(i4));
            com.tencent.mm.network.e eVar = g.Eh().dpP.dJs;
            if (eVar != null) {
                eVar.bF((i4 & 1) == 0);
            }
        }
        if (i2 == 4 && i3 == -301) {
            av.a(true, bVar.qWH.rhK, bVar.qWH.rhL, bVar.qWH.rhJ);
            this.dJp--;
            if (this.dJp <= 0) {
                this.diJ.a(3, -1, "", this);
            } else {
                a(this.dIX, this.diJ);
            }
        } else if (i2 == 4 && i3 == -240) {
            x.i("MicroMsg.NetSceneBindMobileForReg", "summerauth bindopreg MM_ERR_AUTO_RETRY_REQUEST redirectCount:%s", new Object[]{Integer.valueOf(this.dJp)});
            this.dJp--;
            if (this.dJp <= 0) {
                this.diJ.a(3, -1, "", this);
            } else {
                a(this.dIX, this.diJ);
            }
        } else if (i2 == 4 && i3 == -102) {
            x.d("MicroMsg.NetSceneBindMobileForReg", "summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", new Object[]{Integer.valueOf(qVar.KV().qWA.ver)});
            g.Em().H(new 1(this, r0));
        } else if (i2 == 0 && i3 == 0) {
            av.a(false, bVar.qWH.rhK, bVar.qWH.rhL, bVar.qWH.rhJ);
            this.diJ.a(i2, i3, str, this);
        } else {
            x.e("MicroMsg.NetSceneBindMobileForReg", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
            this.diJ.a(i2, i3, str, this);
        }
    }

    public final String Oi() {
        return ((m.b) this.dJM.Id()).qWH.rhI;
    }

    public final String getUsername() {
        return ((m.b) this.dJM.Id()).qWH.rdS;
    }

    public final String Oj() {
        return ((m.b) this.dJM.Id()).qWH.bLe;
    }

    public final String Ok() {
        return ((m.b) this.dJM.Id()).qWH.reE;
    }

    public final String Ol() {
        return ((m.b) this.dJM.Id()).qWH.rhP;
    }

    public final int Om() {
        return ((m.b) this.dJM.Id()).qWH.rhE;
    }

    public final String On() {
        return ((m.b) this.dJM.Id()).qWH.rhR;
    }

    public final String Oo() {
        return ((m.b) this.dJM.Id()).qWH.rhS;
    }

    public final int Op() {
        bnp bnp = ((m.b) this.dJM.Id()).qWH.reD;
        if (!(bnp == null || bnp.slI == null || bnp.slI.size() <= 0)) {
            Iterator it = bnp.slI.iterator();
            while (it.hasNext()) {
                brj brj = (brj) it.next();
                if (brj.mEb == 6) {
                    return bi.getInt(brj.spx, 3);
                }
            }
        }
        return 3;
    }

    public final int Oq() {
        bnp bnp = ((m.b) this.dJM.Id()).qWH.reD;
        if (!(bnp == null || bnp.slI == null || bnp.slI.size() <= 0)) {
            Iterator it = bnp.slI.iterator();
            while (it.hasNext()) {
                brj brj = (brj) it.next();
                if (brj.mEb == 4) {
                    return bi.getInt(brj.spx, 30);
                }
            }
        }
        return 30;
    }

    public final int Or() {
        bnp bnp = ((m.b) this.dJM.Id()).qWH.reD;
        if (!(bnp == null || bnp.slI == null || bnp.slI.size() <= 0)) {
            Iterator it = bnp.slI.iterator();
            while (it.hasNext()) {
                brj brj = (brj) it.next();
                if (brj.mEb == 5) {
                    return bi.getInt(brj.spx, 0);
                }
            }
        }
        return 0;
    }

    public final boolean Os() {
        int i;
        bnp bnp = ((m.b) this.dJM.Id()).qWH.reD;
        if (!(bnp == null || bnp.slI == null || bnp.slI.size() <= 0)) {
            Iterator it = bnp.slI.iterator();
            while (it.hasNext()) {
                brj brj = (brj) it.next();
                if (brj.mEb == 7) {
                    i = bi.getInt(brj.spx, 0);
                    break;
                }
            }
        }
        i = 0;
        return i > 0;
    }

    public final boolean Ot() {
        int i;
        bnp bnp = ((m.b) this.dJM.Id()).qWH.reD;
        if (!(bnp == null || bnp.slI == null || bnp.slI.size() <= 0)) {
            Iterator it = bnp.slI.iterator();
            while (it.hasNext()) {
                brj brj = (brj) it.next();
                if (brj.mEb == 10) {
                    i = bi.getInt(brj.spx, 0);
                    break;
                }
            }
        }
        i = 0;
        return i > 0;
    }

    public final String Ou() {
        bnp bnp = ((m.b) this.dJM.Id()).qWH.reD;
        if (!(bnp == null || bnp.slI == null || bnp.slI.size() <= 0)) {
            Iterator it = bnp.slI.iterator();
            while (it.hasNext()) {
                brj brj = (brj) it.next();
                if (brj.mEb == 14) {
                    return brj.spx;
                }
            }
        }
        return null;
    }

    public final String Ov() {
        bnp bnp = ((m.b) this.dJM.Id()).qWH.reD;
        if (!(bnp == null || bnp.slI == null || bnp.slI.size() <= 0)) {
            Iterator it = bnp.slI.iterator();
            while (it.hasNext()) {
                brj brj = (brj) it.next();
                if (brj.mEb == 15) {
                    return brj.spx;
                }
            }
        }
        return null;
    }

    public final String Ow() {
        return ((m.b) this.dJM.Id()).qWH.rhF;
    }

    public final void lD(String str) {
        ((com.tencent.mm.protocal.m.a) this.dJM.KV()).qWG.rhF = str;
    }
}
