package com.tencent.mm.protocal;

import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.protocal.c.oi;
import com.tencent.mm.protocal.c.tt;
import com.tencent.mm.protocal.c.tu;
import com.tencent.mm.protocal.c.tv;
import com.tencent.mm.protocal.k.b;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.sdk.platformtools.bi;

public class p$a extends d implements b {
    public final tu qWO = new tu();

    public p$a() {
        eK(0);
        this.qWO.rxE = new tt();
        this.qWO.rxE.rxC = new oi();
        this.qWO.rxD = new tv();
    }

    public final byte[] Ie() {
        this.qWA = y.cgr();
        this.qWO.rxE.shX = k.a(this);
        this.qWO.rxD.rhB = new bhy().bq(bi.ciV());
        this.qWz = this.qWO.rxD.rhB.siK.toByteArray();
        this.qWy = new 1(this, this);
        return this.qWO.toByteArray();
    }

    public final int If() {
        return 722;
    }
}
