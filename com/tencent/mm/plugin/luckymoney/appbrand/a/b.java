package com.tencent.mm.plugin.luckymoney.appbrand.a;

import com.tencent.mm.protocal.c.ayj;
import com.tencent.mm.protocal.c.ayk;
import com.tencent.mm.protocal.c.bhp;
import com.tencent.mm.sdk.platformtools.x;

public final class b extends a<ayj, ayk> {
    protected final /* synthetic */ bhp bax() {
        return new ayk();
    }

    public b(String str, String str2, byte[] bArr) {
        ayj ayj = new ayj();
        ayj.bPS = str;
        ayj.sbb = str2;
        ayj.sbc = com.tencent.mm.bk.b.bi(bArr);
        this.kKM = ayj;
    }

    protected final void bay() {
        x.i("MicroMsg.CgiOpenWxaHB", "CgiOpenWxaHB.onCgiStart ");
    }

    protected final void baz() {
        x.i("MicroMsg.CgiOpenWxaHB", "CgiOpenWxaHB.onCgiEnd ");
    }

    public final String getUri() {
        return "/cgi-bin/mmbiz-bin/wxahb/openwxaapphb";
    }

    public final int If() {
        return 2701;
    }
}
