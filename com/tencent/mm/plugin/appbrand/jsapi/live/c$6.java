package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.os.Bundle;
import com.tencent.mm.plugin.appbrand.jsapi.live.a.a;
import com.tencent.mm.sdk.platformtools.x;

class c$6 implements a {
    final /* synthetic */ AppBrandLivePusherView fRN;
    final /* synthetic */ c fRO;

    c$6(c cVar, AppBrandLivePusherView appBrandLivePusherView) {
        this.fRO = cVar;
        this.fRN = appBrandLivePusherView;
    }

    public final void tA(String str) {
        x.i("MicroMsg.JsApiInsertLivePusher", "convertBackgroundImageToLocalPath onDownload localPath:%s", new Object[]{str});
        Bundle bundle = new Bundle();
        bundle.putString("backgroundImage", str);
        this.fRN.u(bundle);
    }
}
