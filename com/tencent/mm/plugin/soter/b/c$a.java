package com.tencent.mm.plugin.soter.b;

import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.protocal.c.bvf;
import com.tencent.mm.protocal.k;
import com.tencent.mm.protocal.k.b;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.y;
import com.tencent.mm.sdk.platformtools.bi;

public class c$a extends d implements b {
    public bvf onv = new bvf();

    public final byte[] Ie() {
        this.qWA = y.cgr();
        this.onv.rhB = new bhy().bq(bi.ciV());
        this.onv.shX = k.a(this);
        this.qWz = this.onv.rhB.siK.toByteArray();
        return this.onv.toByteArray();
    }

    public final int If() {
        return 627;
    }

    public final int getCmdId() {
        return 0;
    }
}
