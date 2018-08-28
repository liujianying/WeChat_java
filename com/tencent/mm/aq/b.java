package com.tencent.mm.aq;

import com.tencent.mm.protocal.c.bhz;
import com.tencent.mm.protocal.c.qx;
import com.tencent.mm.sdk.platformtools.bi;

@Deprecated
public final class b extends com.tencent.mm.plugin.messenger.foundation.a.a.h.b {
    private qx ecb = new qx();

    public b(String str) {
        super(7);
        this.ecb.rvi = new bhz().VO(bi.oV(str));
        this.lcH = this.ecb;
    }
}
