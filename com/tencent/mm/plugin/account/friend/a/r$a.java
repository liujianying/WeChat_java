package com.tencent.mm.plugin.account.friend.a;

import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.protocal.c.sy;
import com.tencent.mm.protocal.k;
import com.tencent.mm.protocal.k.b;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.y;
import com.tencent.mm.sdk.platformtools.bi;

public class r$a extends d implements b {
    public sy eKz = new sy();

    public final byte[] Ie() {
        this.qWA = y.cgt();
        this.eKz.rhB = new bhy().bq(bi.ciV());
        this.eKz.shX = k.a(this);
        return this.eKz.toByteArray();
    }

    public final int If() {
        return 481;
    }
}
