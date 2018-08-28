package com.tencent.mm.plugin.facedetect.b;

import com.tencent.mm.protocal.c.aah;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.protocal.k;
import com.tencent.mm.protocal.k.b;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.y;
import com.tencent.mm.sdk.platformtools.bi;

public class i$a extends d implements b {
    public aah iMp = new aah();

    public final byte[] Ie() {
        this.qWA = y.cgr();
        this.iMp.rhB = new bhy().bq(bi.ciV());
        this.iMp.shX = k.a(this);
        this.qWz = this.iMp.rhB.siK.toByteArray();
        return this.iMp.toByteArray();
    }

    public final int If() {
        return 733;
    }

    public final int getCmdId() {
        return 0;
    }
}
