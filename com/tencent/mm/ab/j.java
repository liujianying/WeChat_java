package com.tencent.mm.ab;

import com.tencent.mm.network.q;
import com.tencent.mm.protocal.i.c.a;
import com.tencent.mm.protocal.k.d;

public abstract class j implements q {
    private d dIT;
    public boolean dIU = false;

    public abstract d Ic();

    public final d KV() {
        if (this.dIT == null) {
            this.dIT = Ic();
            d dVar = this.dIT;
            dVar.qWv = com.tencent.mm.compatible.e.q.zz();
            dVar.qWu = com.tencent.mm.protocal.d.DEVICE_TYPE;
            dVar.qWt = com.tencent.mm.protocal.d.qVN;
            dVar.eK(a.qWj.Ia());
        }
        return this.dIT;
    }

    public int KP() {
        return 0;
    }

    public final boolean KW() {
        return this.dIU;
    }
}
