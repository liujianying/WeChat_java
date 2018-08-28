package com.tencent.mm.plugin.account.friend.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.sf;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.protocal.c.hg;
import com.tencent.mm.protocal.c.hh;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;

public final class x extends l implements k {
    private String bQX;
    private String bQZ;
    private int dJp;
    public final b diG;
    private e diJ;

    public x(String str, int i, String str2, String str3, String str4, String str5) {
        this(str, i, str2, 0, str3);
        this.bQX = str4;
        this.bQZ = str5;
        hg hgVar = (hg) this.diG.dID.dIL;
        hgVar.rhz = str4;
        hgVar.rhA = str5;
    }

    public x(String str, int i, String str2, int i2, String str3) {
        this.diJ = null;
        this.dJp = 2;
        this.bQX = null;
        this.bQZ = null;
        a aVar = new a();
        aVar.dIG = new hg();
        aVar.dIH = new hh();
        aVar.uri = "/cgi-bin/micromsg-bin/bindopmobile";
        aVar.dIF = 132;
        aVar.dII = 45;
        aVar.dIJ = 1000000045;
        this.diG = aVar.KT();
        hg hgVar = (hg) this.diG.dID.dIL;
        hgVar.rfe = i;
        hgVar.rhw = i2;
        hgVar.rhx = str3;
        if (bi.oW(this.bQX) && bi.oW(this.bQZ)) {
            hgVar.rhz = com.tencent.mm.sdk.platformtools.e.sFF ? ad.getContext().getString(j.safe_device_android_device_nm) : ad.getContext().getString(j.safe_device_android_device);
            hgVar.rhA = d.DEVICE_NAME;
        }
        if (str != null && str.length() > 0 && (i == 1 || i == 4 || i == 18)) {
            g.Ei().DT().set(4097, str);
        } else if (i == 2 || i == 19) {
            str = (String) g.Ei().DT().get(4097, null);
        } else if (i == 3) {
            str = (String) g.Ei().DT().get(6, null);
        }
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.NetSceneBindOpMobile", "Get mobile:" + str + " opcode:" + i + " verifyCode:" + str2);
        hgVar.rhu = str;
        hgVar.rhv = str2;
        hgVar.iwP = w.chP();
    }

    public final int Oh() {
        return ((hg) this.diG.dID.dIL).rfe;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        hg hgVar = (hg) this.diG.dID.dIL;
        if (hgVar.rhu == null || hgVar.rhu.length() <= 0) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.NetSceneBindOpMobile", "doScene getMobile Error: " + hgVar.rhu);
            return -1;
        } else if ((hgVar.rfe != 2 && hgVar.rfe != 19) || (hgVar.rhv != null && hgVar.rhv.length() > 0)) {
            return a(eVar, this.diG, this);
        } else {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.NetSceneBindOpMobile", "doScene getVerifyCode Error: " + hgVar.rhu);
            return -1;
        }
    }

    public final int getType() {
        return 132;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        hg hgVar = (hg) this.diG.dID.dIL;
        hh hhVar = (hh) this.diG.dIE.dIL;
        if (hhVar != null) {
            int i4 = hhVar.reI;
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.NetSceneBindOpMobile", "summerauth mmtls bindop:%s", new Object[]{Integer.valueOf(i4)});
            g.Ek();
            g.Ei().dqk.set(47, Integer.valueOf(i4));
            com.tencent.mm.network.e eVar = g.Eh().dpP.dJs;
            if (eVar != null) {
                eVar.bF((i4 & 1) == 0);
            }
        } else {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.NetSceneBindOpMobile", "summerauth mmtls bindop not set as ret:%s", new Object[]{hhVar});
        }
        if (i2 == 0 && i3 == 0) {
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.NetSceneBindOpMobile", "onGYNetEnd  errType:" + i2 + " errCode:" + i3 + " sms:" + hhVar.rhG + "safedevice status = " + hhVar.raE);
            if (hgVar.rfe == 2 || hgVar.rfe == 4 || hgVar.rfe == 11 || hgVar.rfe == 19) {
                g.Ei().DT().set(4097, "");
                g.Ei().DT().set(6, hgVar.rhu);
                if (bi.oW(this.bQX) || bi.oW(this.bQZ)) {
                    l.Xz();
                }
                if (hgVar.rfe == 19) {
                    g.Ei().DT().set(12322, null);
                }
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.NetSceneBindOpMobile", "onGYNetEnd  mobile binded");
            } else if (hgVar.rfe == 3) {
                g.Ei().DT().set(4097, "");
                g.Ei().DT().set(6, "");
                g.Ei().DT().set(12322, null);
                g.Ei().DT().set(64, Integer.valueOf(hhVar.raE));
                sf sfVar = new sf();
                sfVar.ccY.ccZ = false;
                sfVar.ccY.cda = true;
                com.tencent.mm.sdk.b.a.sFg.m(sfVar);
                l.XG();
                l.XH();
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.NetSceneBindOpMobile", "onGYNetEnd  mobile unbinded");
            }
            this.diJ.a(i2, i3, str, this);
            return;
        }
        com.tencent.mm.sdk.platformtools.x.e("MicroMsg.NetSceneBindOpMobile", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        if (i2 == 4 && i3 == -240) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.NetSceneBindOpMobile", "summerauth bindop MM_ERR_AUTO_RETRY_REQUEST redirectCount:%s", new Object[]{Integer.valueOf(this.dJp)});
            this.dJp--;
            if (this.dJp <= 0) {
                this.diJ.a(3, -1, "", this);
                return;
            } else {
                a(this.dIX, this.diJ);
                return;
            }
        }
        this.diJ.a(i2, i3, str, this);
    }

    public final String Oj() {
        return ((hh) this.diG.dIE.dIL).bLe;
    }
}
