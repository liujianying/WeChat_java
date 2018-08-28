package com.tencent.mm.plugin.facedetect.b;

import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.protocal.c.bxo;
import com.tencent.mm.protocal.k;
import com.tencent.mm.protocal.k.b;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.y;
import com.tencent.mm.sdk.platformtools.bi;

public class k$a extends d implements b {
    public bxo iMt = new bxo();

    public final byte[] Ie() {
        this.qWA = y.cgr();
        this.iMt.rhB = new bhy().bq(bi.ciV());
        this.iMt.shX = k.a(this);
        this.qWz = this.iMt.rhB.siK.toByteArray();
        return this.iMt.toByteArray();
    }

    public final int If() {
        return 930;
    }

    public final int getCmdId() {
        return 0;
    }
}
