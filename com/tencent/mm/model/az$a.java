package com.tencent.mm.model;

import com.tencent.mm.protocal.c.ajr;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.protocal.k;
import com.tencent.mm.protocal.k.b;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.y;
import com.tencent.mm.sdk.platformtools.bi;

public class az$a extends d implements b {
    public ajr dBU = new ajr();

    public final byte[] Ie() {
        this.qWA = y.cgr();
        this.dBU.rhB = new bhy().bq(bi.ciV());
        this.dBU.shX = k.a(this);
        return this.dBU.toByteArray();
    }

    public final int If() {
        return 618;
    }

    public final int getCmdId() {
        return 0;
    }
}
