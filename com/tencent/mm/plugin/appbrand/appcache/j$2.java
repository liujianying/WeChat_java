package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.c.cgl;
import com.tencent.mm.sdk.d.c;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Locale;

class j$2 extends c {
    final /* synthetic */ j ffE;

    j$2(j jVar) {
        this.ffE = jVar;
    }

    public final void enter() {
        super.enter();
        x.i("MicroMsg.LibIncrementalTestCase[incremental]", "DownloadMockLibInfo enter");
        cgl cgl = new cgl();
        cgl.url = String.format(Locale.US, "https://res.servicewechat.com/weapp/public/commlib/%d.wxapkg", new Object[]{Integer.valueOf(j.a(this.ffE))});
        cgl.version = j.a(this.ffE);
        cgl.bKg = j.c(this.ffE);
        cgl.seJ = 1;
        e.abi().a(cgl, new PInt());
        aq.a(cgl.url, cgl.version, new 1(this));
    }
}
