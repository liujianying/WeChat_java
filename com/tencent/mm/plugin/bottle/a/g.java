package com.tencent.mm.plugin.bottle.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.modelvoice.o;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.network.k;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.protocal.c.bhz;
import com.tencent.mm.protocal.c.bss;
import com.tencent.mm.protocal.c.bst;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class g extends l implements k {
    private b diG;
    private e diJ;
    int hjW = 0;
    private com.tencent.mm.modelvoice.b hjZ;
    int msgType = -1;

    public g(String str) {
        a aVar = new a();
        aVar.dIG = new bss();
        aVar.dIH = new bst();
        aVar.uri = "/cgi-bin/micromsg-bin/throwbottle";
        aVar.dIF = 154;
        aVar.dII = 53;
        aVar.dIJ = 1000000053;
        this.diG = aVar.KT();
        if (!bi.oW(str)) {
            this.msgType = 1;
            bss bss = (bss) this.diG.dID.dIL;
            bss.sde = 0;
            bss.jQd = this.msgType;
            bss.rdW = 0;
            bss.rdV = str.getBytes().length;
            bss.rvX = 0;
            bss.ruy = ab.O(str.getBytes());
            bss.rVk = com.tencent.mm.a.g.u((str + bi.VF()).getBytes());
        }
    }

    public g(String str, int i) {
        a aVar = new a();
        aVar.dIG = new bss();
        aVar.dIH = new bst();
        aVar.uri = "/cgi-bin/micromsg-bin/throwbottle";
        aVar.dIF = 154;
        aVar.dII = 53;
        aVar.dIJ = 1000000053;
        this.diG = aVar.KT();
        if (!bi.oW(str) && i > 0) {
            this.msgType = 3;
            bss bss = (bss) this.diG.dID.dIL;
            bss.rvX = i;
            bss.rVk = str;
            bss.sde = 0;
            bss.jQd = this.msgType;
        }
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        if (this.msgType == 1) {
            this.msgType = 0 - this.msgType;
        } else if (this.msgType == 3) {
            bss bss = (bss) this.diG.dID.dIL;
            bss.jQd = 3;
            bss.sde = 0;
            if (this.hjZ == null) {
                this.hjZ = q.ok(bss.rVk);
                this.hjW = 0;
                bss.rdV = o.nM(bss.rVk);
            }
            com.tencent.mm.modelvoice.g br = this.hjZ.br(this.hjW, 6000);
            x.d("MicroMsg.NetSceneThrowBottle", "doScene READ file[" + bss.rVk + "] read ret:" + br.ret + " readlen:" + br.bEG + " newOff:" + br.eon + " netOff:" + this.hjW + " line:" + com.tencent.mm.compatible.util.g.getLine());
            if (br.ret < 0 || br.bEG == 0) {
                x.e("MicroMsg.NetSceneThrowBottle", "Err doScene READ file[" + bss.rVk + "] read ret:" + br.ret + " readlen:" + br.bEG + " newOff:" + br.eon + " netOff:" + this.hjW);
                q.ol(bss.rVk);
                return -1;
            }
            Object obj = new byte[br.bEG];
            System.arraycopy(br.buf, 0, obj, 0, br.bEG);
            bss.ruy = ab.O(obj);
            bss.rdW = this.hjW;
        } else {
            x.e("MicroMsg.NetSceneThrowBottle", "doScene Error Msg type: " + this.msgType);
            return -1;
        }
        return a(eVar, this.diG, this);
    }

    protected final int a(com.tencent.mm.network.q qVar) {
        bss bss = (bss) ((b) qVar).dID.dIL;
        if (bss.jQd == 1) {
            return l.b.dJm;
        }
        if (bss.jQd != 3) {
            return l.b.dJn;
        }
        if (bss.rdV == 0 || bss.rdV <= bss.rdW || bi.oW(bss.rVk) || bi.bC(ab.a(bss.ruy))) {
            return l.b.dJn;
        }
        return l.b.dJm;
    }

    protected final int Cc() {
        return 10;
    }

    protected final void a(l.a aVar) {
        x.e("MicroMsg.NetSceneThrowBottle", "setSecurityCheckError:" + aVar + " type:" + this.msgType);
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneThrowBottle", "onGYNetEnd errtype:" + i2 + " errCode:" + i3);
        bss bss = (bss) this.diG.dID.dIL;
        bst bst = (bst) this.diG.dIE.dIL;
        if (i2 == 4) {
            switch (i3) {
                case -56:
                    break;
                default:
                    c.nh(bst.rGd);
                    c.ng(bst.rGc);
                    break;
            }
        }
        if (i2 == 0 && i3 == 0) {
            x.d("MicroMsg.NetSceneThrowBottle", "getStartPos " + bst.rdW);
            x.d("MicroMsg.NetSceneThrowBottle", "getTotalLen " + bst.rdV);
            x.d("MicroMsg.NetSceneThrowBottle", "getThrowCount " + bst.rGc);
            x.d("MicroMsg.NetSceneThrowBottle", "getPickCount " + bst.rGd);
            x.d("MicroMsg.NetSceneThrowBottle", "getDistance " + bst.sdg);
            x.d("MicroMsg.NetSceneThrowBottle", "getBottleList " + bst.spY.size());
            for (int i4 = 0; i4 < bst.spY.size(); i4++) {
                x.d("MicroMsg.NetSceneThrowBottle", "bott id:" + bst.spY.get(i4));
            }
            if (bss.jQd == 1) {
                this.diJ.a(i2, i3, str, this);
                nj(1);
                return;
            }
            this.hjW += bss.ruy.siI;
            if (this.hjW >= bss.rdV) {
                c.nh(bst.rGd);
                c.ng(bst.rGc);
                nj(3);
                q.ol(bss.rVk);
                this.diJ.a(i2, i3, str, this);
                return;
            } else if (a(this.dIX, this.diJ) == -1) {
                this.diJ.a(3, -1, "doScene failed", this);
                return;
            } else {
                return;
            }
        }
        x.d("MicroMsg.NetSceneThrowBottle", "ERR: onGYNetEnd errtype:" + i2 + " errCode:" + i3);
        q.ol(bss.rVk);
        this.diJ.a(i2, i3, str, this);
    }

    public final int aui() {
        return ((bst) this.diG.dIE.dIL).sdg;
    }

    private int nj(int i) {
        a aVar = new a();
        aVar.msgType = i;
        bss bss = (bss) this.diG.dID.dIL;
        bst bst = (bst) this.diG.dIE.dIL;
        aVar.hjO = bst.spY.size();
        aVar.hjQ = 1;
        if (i == 3) {
            aVar.content = bss.rVk;
            aVar.hjR = bss.rvX;
        } else {
            aVar.content = new String(ab.a(bss.ruy));
        }
        String str = "";
        for (int i2 = 0; i2 < bst.spY.size(); i2++) {
            str = str + bst.spY.get(i2);
        }
        aVar.hjN = com.tencent.mm.a.g.u(str.getBytes());
        aVar.hjS = bi.VF();
        for (int i3 = 0; i3 < bst.spY.size(); i3++) {
            String wU = c.wU(ab.a((bhz) bst.spY.get(i3)));
            if (!bi.oW(wU)) {
                aVar.hjP = wU;
                i.auk().a(aVar);
            }
        }
        return 0;
    }

    public final int getType() {
        return 154;
    }
}
