package com.tencent.mm.plugin.collect.b;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bih;
import com.tencent.mm.protocal.c.bii;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.h;

public final class k extends h {
    public bii hUk;

    public k(String str, int i) {
        a aVar = new a();
        aVar.dIG = new bih();
        aVar.dIH = new bii();
        aVar.dIF = 1800;
        aVar.uri = "/cgi-bin/mmpay-bin/scanf2fmaterialcode";
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        bih bih = (bih) this.diG.dID.dIL;
        bih.siX = str;
        bih.scene = i;
        x.i("MicroMsg.NetSceneF2fMaterial", "req url: %s, %s", new Object[]{str, Integer.valueOf(i)});
    }

    protected final void b(int i, int i2, String str, q qVar) {
        this.hUk = (bii) ((b) qVar).dIE.dIL;
        x.i("MicroMsg.NetSceneF2fMaterial", "retcode: %s, retmsg: %s", new Object[]{Integer.valueOf(this.hUk.hUm), this.hUk.hUn});
        if (this.diJ != null) {
            this.diJ.a(i, i2, str, this);
        }
    }

    protected final void f(q qVar) {
        bii bii = (bii) ((b) qVar).dIE.dIL;
        this.uXe = bii.hUm;
        this.uXf = bii.hUn;
    }

    public final int getType() {
        return 1800;
    }
}
