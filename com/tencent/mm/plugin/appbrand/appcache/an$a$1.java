package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.plugin.appbrand.appcache.an.a;
import com.tencent.mm.plugin.appbrand.config.m.c;
import com.tencent.mm.plugin.appbrand.ipc.d;
import com.tencent.mm.sdk.platformtools.x;

class an$a$1 implements c {
    final /* synthetic */ String bAj;
    final /* synthetic */ int bpX;
    final /* synthetic */ a fhO;

    an$a$1(a aVar, String str, int i) {
        this.fhO = aVar;
        this.bAj = str;
        this.bpX = i;
    }

    public final void qR(String str) {
        x.i("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "CommonConfigManager.getConfig config:%s", new Object[]{str});
        d.k(this.bAj, this.bpX, str);
    }
}
