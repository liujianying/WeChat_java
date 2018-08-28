package com.tencent.mm.plugin.bottle.a;

import com.tencent.mm.a.g;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.modelvoice.a;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.modelvoice.u;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.protocal.c.axk;
import com.tencent.mm.protocal.c.axl;
import com.tencent.mm.protocal.c.qb;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;

public final class e extends l implements k {
    private b diG;
    private com.tencent.mm.ab.e diJ;
    private String fileName = "";
    private String hjV = "";
    private int hjW = 0;
    private a hjX = null;
    private int msgType = 0;

    public e(String str, int i) {
        b.a aVar = new b.a();
        aVar.dIG = new axk();
        aVar.dIH = new axl();
        aVar.uri = "/cgi-bin/micromsg-bin/openbottle";
        aVar.dIF = 156;
        aVar.dII = 55;
        aVar.dIJ = 1000000055;
        this.diG = aVar.KT();
        this.hjV = str;
        this.msgType = i;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ab.e eVar2) {
        this.diJ = eVar2;
        axk axk = (axk) this.diG.dID.dIL;
        axk.jQd = this.msgType;
        axk.say = this.hjV;
        if (axk.saz == null) {
            axk.saz = new qb();
        }
        if (axk.saA == null) {
            axk.saA = new qb();
        }
        if (this.msgType == 1) {
            axk.saz.rdW = 0;
            axk.saz.rux = 0;
        } else if (this.msgType != 3) {
            x.e("MicroMsg.NetSceneOpenBottle", "doScene Error Msg type" + this.msgType);
            return -1;
        }
        return a(eVar, this.diG, this);
    }

    protected final int a(q qVar) {
        axk axk = (axk) ((b) qVar).dID.dIL;
        if (axk.jQd == 1) {
            return l.b.dJm;
        }
        if (axk.jQd != 3) {
            return l.b.dJn;
        }
        if (axk.saz == null) {
            x.d("MicroMsg.NetSceneOpenBottle", "ERR: securityVerificationChecked errtype: rImpl.getBigContentInfo() == null");
            return l.b.dJn;
        } else if (axk.saz.rux == 0 && axk.saz.rdW == 0) {
            return l.b.dJm;
        } else {
            if (axk.saz.rux <= axk.saz.rdW) {
                return l.b.dJn;
            }
            return l.b.dJm;
        }
    }

    protected final int Cc() {
        return 10;
    }

    private int aug() {
        axk axk = (axk) this.diG.dID.dIL;
        axl axl = (axl) this.diG.dIE.dIL;
        a aVar = new a();
        aVar.msgType = axk.jQd;
        aVar.hjO = 0;
        aVar.hjQ = 2;
        aVar.hjP = c.wU(axk.say);
        aVar.hjS = bi.VF();
        aVar.hjN = g.u(axk.say.getBytes());
        if (this.msgType == 3) {
            aVar.content = this.fileName;
            aVar.hjR = axl.rvX;
        } else {
            aVar.content = new String(axl.saC.ruy.siK.lR);
        }
        i.auk().a(aVar);
        return 0;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneOpenBottle", "onGYNetEnd errtype:" + i2 + " errCode:" + i3);
        if (i2 == 0 && i3 == 0) {
            axk axk = (axk) this.diG.dID.dIL;
            axl axl = (axl) this.diG.dIE.dIL;
            bd bdVar;
            if (this.msgType == 1) {
                aug();
                bdVar = new bd();
                bdVar.ep(axk.say);
                bdVar.setContent(ab.b(axl.saC.ruy));
                bdVar.ay(bi.VF());
                bdVar.eX(0);
                bdVar.setStatus(3);
                bdVar.setType(c.ni(axk.jQd));
                au.HU();
                c.FT().T(bdVar);
                x.d("MicroMsg.NetSceneOpenBottle", "onGYNetEnd :" + bdVar.field_content);
                this.diJ.a(i2, i3, str, this);
                return;
            }
            if (bi.oW(this.fileName)) {
                this.fileName = u.ov(this.hjV);
                this.hjX = new a(com.tencent.mm.modelvoice.q.getFullPath(this.fileName));
                this.hjW = 0;
            }
            if (axl.saC.rux < axl.saC.rdW + axl.saC.ruy.siI) {
                x.e("MicroMsg.NetSceneOpenBottle", "onGYNetEnd tot:" + axl.saC.rux + " start:" + axl.saC.rdW + " len:" + axl.saC.ruy.siI);
                this.diJ.a(3, -1, str, this);
                return;
            } else if (axl.saC.rdW != this.hjW) {
                x.e("MicroMsg.NetSceneOpenBottle", "onGYNetEnd start:" + axl.saC.rdW + " off:" + this.hjW);
                this.diJ.a(3, -1, str, this);
                return;
            } else {
                int write = this.hjX.write(axl.saC.ruy.siK.lR, axl.saC.ruy.siI, axl.saC.rdW);
                if (write != axl.saC.ruy.siI + axl.saC.rdW) {
                    x.e("MicroMsg.NetSceneOpenBottle", "onGYNetEnd start:" + axl.saC.rdW + " len:" + axl.saC.ruy.siI + " writeRet:" + write);
                    this.diJ.a(3, -1, str, this);
                    return;
                }
                this.hjW = write;
                if (axl.saC.rux <= this.hjW) {
                    aug();
                    bdVar = new bd();
                    bdVar.ep(axk.say);
                    bdVar.setContent(n.b("bottle", (long) axl.rvX, false));
                    bdVar.eq(this.fileName);
                    bdVar.ay(bi.VF());
                    bdVar.eX(0);
                    bdVar.setStatus(3);
                    bdVar.setType(c.ni(axk.jQd));
                    au.HU();
                    c.FT().T(bdVar);
                    x.d("MicroMsg.NetSceneOpenBottle", "voice :" + axl.rvX + " file:" + this.fileName);
                    this.diJ.a(i2, i3, str, this);
                    return;
                } else if (a(this.dIX, this.diJ) == -1) {
                    this.diJ.a(3, -1, "doScene failed", this);
                    return;
                } else {
                    return;
                }
            }
        }
        x.d("MicroMsg.NetSceneOpenBottle", "ERR: onGYNetEnd errtype:" + i2 + " errCode:" + i3);
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return 156;
    }
}
