package com.tencent.mm.plugin.account.friend.a;

import com.tencent.mm.protocal.c.aie;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.protocal.k;
import com.tencent.mm.protocal.k.b;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.y;
import com.tencent.mm.sdk.platformtools.bi;

public class t$a extends d implements b {
    public aie eKC = new aie();

    public final byte[] Ie() {
        this.qWA = y.cgr();
        this.eKC.rhB = new bhy().bq(bi.ciV());
        this.eKC.shX = k.a(this);
        return this.eKC.toByteArray();
    }

    public final int If() {
        return 429;
    }
}
