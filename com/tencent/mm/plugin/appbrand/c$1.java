package com.tencent.mm.plugin.appbrand;

import com.tencent.mm.plugin.appbrand.r.i.a;
import com.tencent.mm.sdk.platformtools.x;

class c$1 implements a {
    final /* synthetic */ String fbS;
    final /* synthetic */ c fbT;

    c$1(c cVar, String str) {
        this.fbT = cVar;
        this.fbS = str;
    }

    public final void qe(String str) {
        x.i("MicroMsg.AppBrandJSContextInterface[multicontext]", "create with appID(%s), scriptPath(%s), sdkScript inject succeed", new Object[]{this.fbT.fbP.mAppId, this.fbS});
        this.fbT.cq(true);
    }

    public final void fM(String str) {
        x.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "create with appID(%s), scriptPath(%s), sdkScript inject failed", new Object[]{this.fbT.fbP.mAppId, this.fbS});
        this.fbT.cq(false);
    }
}
