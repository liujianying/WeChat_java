package com.tencent.mm.aq;

import com.tencent.mm.plugin.messenger.foundation.a.a.h.b;
import com.tencent.mm.protocal.c.bhz;
import com.tencent.mm.protocal.c.rj;
import com.tencent.mm.sdk.platformtools.bi;

@Deprecated
public final class e extends b {
    private rj ece = new rj();

    public e(String str, long j) {
        super(9);
        this.ece.rvi = new bhz().VO(bi.oV(str));
        this.ece.rvp.add(Integer.valueOf((int) j));
        this.ece.hbF = 1;
        this.lcH = this.ece;
    }
}
