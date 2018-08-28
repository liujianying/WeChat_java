package com.tencent.mm.aq;

import com.tencent.mm.plugin.messenger.foundation.a.a.h.b;
import com.tencent.mm.protocal.c.bhz;
import com.tencent.mm.protocal.c.rd;
import com.tencent.mm.sdk.platformtools.bi;

@Deprecated
public final class d extends b {
    private rd ecd = new rd();

    public d(String str, long j) {
        super(8);
        this.ecd.rvi = new bhz().VO(bi.oV(str));
        this.ecd.rcq = j;
        this.lcH = this.ecd;
    }
}
