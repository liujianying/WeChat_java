package com.tencent.mm.plugin.luckymoney.appbrand.a;

import com.tencent.mm.protocal.c.bfn;
import com.tencent.mm.protocal.c.bfo;
import com.tencent.mm.protocal.c.bhp;

public final class d extends a<bfn, bfo> {
    protected final /* synthetic */ bhp bax() {
        return new bfo();
    }

    public d(String str, String str2) {
        bfn bfn = new bfn();
        bfn.bPS = str;
        bfn.sbb = str2;
        this.kKM = bfn;
    }

    public final String getUri() {
        return "/cgi-bin/mmbiz-bin/wxahb/receivewxaapphb";
    }

    public final int If() {
        return 1828;
    }
}
