package com.tencent.mm.plugin.account.friend.a;

import com.tencent.mm.protocal.c.ahe;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.protocal.k;
import com.tencent.mm.protocal.k.b;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.y;
import com.tencent.mm.sdk.platformtools.bi;

public class s$a extends d implements b {
    public ahe eKB = new ahe();

    public final byte[] Ie() {
        this.qWA = y.cgt();
        this.eKB.rhB = new bhy().bq(bi.ciV());
        this.eKB.shX = k.a(this);
        return this.eKB.toByteArray();
    }

    public final int If() {
        return 572;
    }
}
