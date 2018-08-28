package com.tencent.mm.aq;

import com.tencent.mm.plugin.messenger.foundation.a.a.h.b;
import com.tencent.mm.protocal.c.bei;
import com.tencent.mm.protocal.c.bhz;
import com.tencent.mm.sdk.platformtools.bi;

@Deprecated
public final class n extends b {
    private bei ecn = new bei();

    public n(String str, String str2) {
        super(16);
        this.ecn.rvi = new bhz().VO(bi.oV(str));
        this.ecn.rbR = new bhz().VO(bi.oV(str2));
        this.lcH = this.ecn;
    }
}
