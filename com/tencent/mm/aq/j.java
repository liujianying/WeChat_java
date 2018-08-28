package com.tencent.mm.aq;

import com.tencent.mm.plugin.messenger.foundation.a.a.h.b;
import com.tencent.mm.protocal.c.auc;
import com.tencent.mm.protocal.c.bhz;
import com.tencent.mm.sdk.platformtools.bi;

@Deprecated
public final class j extends b {
    private auc ecj = new auc();

    public j(String str, int i) {
        super(20);
        this.ecj.rbR = new bhz().VO(bi.oV(str));
        this.ecj.hcd = i;
        this.lcH = this.ecj;
    }
}
