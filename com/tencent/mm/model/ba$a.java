package com.tencent.mm.model;

import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.protocal.c.byi;
import com.tencent.mm.protocal.k;
import com.tencent.mm.protocal.k.b;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.y;
import com.tencent.mm.sdk.platformtools.bi;

public class ba$a extends d implements b {
    public byi dBW = new byi();

    public final byte[] Ie() {
        this.qWA = y.cgr();
        this.dBW.rhB = new bhy().bq(bi.ciV());
        this.dBW.shX = k.a(this);
        return this.dBW.toByteArray();
    }

    public final int If() {
        return 617;
    }

    public final int getCmdId() {
        return 0;
    }
}
