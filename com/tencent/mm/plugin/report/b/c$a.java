package com.tencent.mm.plugin.report.b;

import com.tencent.mm.protocal.c.apw;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.protocal.k;
import com.tencent.mm.protocal.k.b;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.y;
import com.tencent.mm.sdk.platformtools.bi;

public class c$a extends d implements b {
    public apw mDL = new apw();

    public final byte[] Ie() {
        this.qWA = y.cgs();
        this.mDL.rhB = new bhy().bq(bi.ciV());
        this.mDL.shX = k.a(this);
        return this.mDL.toByteArray();
    }

    public final int If() {
        return 499;
    }

    public final int getCmdId() {
        return 0;
    }
}
