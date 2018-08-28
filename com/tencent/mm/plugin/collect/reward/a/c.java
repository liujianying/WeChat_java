package com.tencent.mm.plugin.collect.reward.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bik;
import com.tencent.mm.protocal.c.bil;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.h;

public final class c extends h {
    public bil hUZ;

    public c(String str, int i) {
        a aVar = new a();
        aVar.dIG = new bik();
        aVar.dIH = new bil();
        aVar.uri = "/cgi-bin/mmpay-bin/scanrewardmaterialcode";
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        bik bik = (bik) this.diG.dID.dIL;
        bik.siX = str;
        bik.scene = i;
        x.i("MicroMsg.NetSceneQrRewardMaterial", "req url: %s, %s", str, Integer.valueOf(i));
    }

    protected final void b(int i, int i2, String str, q qVar) {
        this.hUZ = (bil) ((b) qVar).dIE.dIL;
        x.i("MicroMsg.NetSceneQrRewardMaterial", "retcode: %s, retmsg: %s", Integer.valueOf(this.hUZ.hUm), this.hUZ.hUn);
        if (this.diJ != null) {
            this.diJ.a(i, i2, str, this);
        }
    }

    protected final void f(q qVar) {
        bil bil = (bil) ((b) qVar).dIE.dIL;
        this.uXe = bil.hUm;
        this.uXf = bil.hUn;
    }

    public final int getType() {
        return 2811;
    }

    public final boolean aBQ() {
        return true;
    }
}
