package com.tencent.mm.plugin.appbrand;

import com.tencent.mm.plugin.appbrand.g.15;
import com.tencent.mm.plugin.appbrand.jsapi.version.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import java.util.HashMap;
import java.util.Map;

class g$15$4 implements Runnable {
    final /* synthetic */ 15 fdj;
    final /* synthetic */ a fdl;

    g$15$4(15 15, a aVar) {
        this.fdj = 15;
        this.fdl = aVar;
    }

    public final void run() {
        a aVar = this.fdl;
        l lVar = this.fdj.fdd.fcy;
        x.i("MicroMsg.AppBrand.Version.UpdateState[appversion]", "dispatch(%s), service %s", new Object[]{aVar.fZP, lVar});
        if (lVar != null) {
            Map hashMap = new HashMap(1);
            hashMap.put(OpenSDKTool4Assistant.EXTRA_STATE, aVar.fZP);
            new a.a((byte) 0).a(lVar).x(hashMap).ahM();
        }
    }
}
