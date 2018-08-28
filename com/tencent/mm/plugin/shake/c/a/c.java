package com.tencent.mm.plugin.shake.c.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.protocal.c.bmi;
import com.tencent.mm.protocal.c.bmj;
import com.tencent.mm.sdk.platformtools.x;

public final class c extends l implements k {
    private final b diG;
    private e diJ;
    e mXj;

    public c(float f, float f2, int i, String str) {
        a aVar = new a();
        aVar.dIG = new bmi();
        aVar.dIH = new bmj();
        aVar.uri = "/cgi-bin/mmbiz-bin/card/shakecard";
        aVar.dIF = 1250;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        bmi bmi = (bmi) this.diG.dID.dIL;
        bmi.bSx = f2;
        bmi.bUg = f;
        bmi.scene = i;
        bmi.skB = str;
    }

    public final int getType() {
        return 1250;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneShakeCard", "onGYNetEnd, getType = 1250 errType = " + i2 + " errCode = " + i3);
        if (i2 == 0 && i3 == 0) {
            bmj bmj = (bmj) this.diG.dIE.dIL;
            if (bmj != null) {
                this.mXj = new e();
                this.mXj.hwF = bmj.hwF;
                this.mXj.huU = bmj.huU;
                this.mXj.cad = bmj.cad;
                this.mXj.title = bmj.title;
                this.mXj.huX = bmj.huX;
                this.mXj.huY = bmj.huY;
                this.mXj.hwh = bmj.hwh;
                this.mXj.huW = bmj.huW;
                this.mXj.dxh = bmj.dxh;
                this.mXj.mXk = bmj.mXk;
                this.mXj.mXn = bmj.mXn;
                this.mXj.mXo = bmj.mXo;
                this.mXj.mXp = bmj.mXp;
                this.mXj.mXq = bmj.mXq;
                this.mXj.mXr = bmj.mXr;
                this.mXj.end_time = bmj.end_time;
                this.mXj.mXs = bmj.mXs;
                this.mXj.mXt = bmj.mXt;
                m.buI().mXm = this.mXj.mXr;
            } else {
                this.mXj = new e();
                this.mXj.hwF = 3;
                this.mXj.mXr = m.buI().mXm;
            }
        } else {
            this.mXj = new e();
            this.mXj.hwF = 3;
            this.mXj.mXr = m.buI().mXm;
        }
        this.diJ.a(i2, i3, str, this);
    }
}
