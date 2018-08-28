package com.tencent.mm.protocal;

import com.tencent.mm.plugin.appbrand.jsapi.contact.c;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.protocal.c.hg;
import com.tencent.mm.protocal.k.b;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.sdk.platformtools.bi;

public class m$a extends d implements b {
    public hg qWG = new hg();

    public final byte[] Ie() {
        this.qWA = y.cgr();
        this.qWG.rhB = new bhy().bq(bi.ciV());
        this.qWG.shX = k.a(this);
        return this.qWG.toByteArray();
    }

    public final int If() {
        return c.CTRL_INDEX;
    }
}
