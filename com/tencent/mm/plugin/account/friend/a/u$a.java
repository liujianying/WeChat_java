package com.tencent.mm.plugin.account.friend.a;

import com.tencent.mm.protocal.c.ajk;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.protocal.k;
import com.tencent.mm.protocal.k.b;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.y;
import com.tencent.mm.sdk.platformtools.bi;

public class u$a extends d implements b {
    public ajk eKE = new ajk();

    public final byte[] Ie() {
        this.qWA = y.cgt();
        this.eKE.rhB = new bhy().bq(bi.ciV());
        this.eKE.shX = k.a(this);
        return this.eKE.toByteArray();
    }

    public final int If() {
        return 107;
    }

    public final int getCmdId() {
        return 48;
    }
}
