package com.tencent.mm.aq;

import com.tencent.mm.plugin.messenger.foundation.a.a.h.b;
import com.tencent.mm.protocal.c.bhz;
import com.tencent.mm.protocal.c.ra;
import com.tencent.mm.sdk.platformtools.bi;

@Deprecated
public final class c extends b {
    private ra ecc;
    public String username;

    public c(String str) {
        this(str, 0);
        this.username = str;
    }

    public c(String str, int i) {
        super(4);
        this.ecc = new ra();
        this.ecc.rvi = new bhz().VO(bi.oV(str));
        this.ecc.rvk = i;
        this.lcH = this.ecc;
    }
}
