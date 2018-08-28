package com.tencent.mm.plugin.luckymoney.appbrand.a;

import com.tencent.mm.protocal.c.bhg;
import com.tencent.mm.protocal.c.bhh;
import com.tencent.mm.protocal.c.bhp;
import com.tencent.mm.sdk.platformtools.x;

public final class e extends a<bhg, bhh> {
    protected final /* synthetic */ bhp bax() {
        return new bhh();
    }

    public e(bhg bhg) {
        this.kKM = bhg;
    }

    protected final void bay() {
        x.i("MicroMsg.CgiRequestWxaHB", "CgiRequestWxaHB.onCgiStart ");
    }

    protected final void baz() {
        x.i("MicroMsg.CgiRequestWxaHB", "CgiRequestWxaHB.onCgiEnd ");
    }

    public final String getUri() {
        return "/cgi-bin/mmbiz-bin/wxahb/requestwxaapphb";
    }

    public final int If() {
        return 2857;
    }
}
