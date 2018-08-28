package com.tencent.mm.plugin.appbrand;

import com.tencent.mm.plugin.appbrand.r.i.a;
import com.tencent.mm.sdk.platformtools.x;

class c$3 implements a {
    final /* synthetic */ String fbS;
    final /* synthetic */ c fbT;
    final /* synthetic */ com.tencent.mm.plugin.appbrand.g.a fbU;

    c$3(c cVar, com.tencent.mm.plugin.appbrand.g.a aVar, String str) {
        this.fbT = cVar;
        this.fbU = aVar;
        this.fbS = str;
    }

    public final void qe(String str) {
        x.i("MicroMsg.AppBrandJSContextInterface[multicontext]", "evaluateScriptFile with appID(%s), contextId(%d), appScriptPath(%s), appScript inject succeed", new Object[]{this.fbT.fbP.mAppId, Integer.valueOf(this.fbU.afW()), this.fbS});
        this.fbT.cr(true);
    }

    public final void fM(String str) {
        x.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "evaluateScriptFile with appID(%s), contextId(%d), appScriptPath(%s), appScript inject failed", new Object[]{this.fbT.fbP.mAppId, Integer.valueOf(this.fbU.afW()), this.fbS});
        this.fbT.cr(false);
    }
}
