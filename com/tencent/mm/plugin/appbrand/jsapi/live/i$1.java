package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.os.Bundle;
import com.tencent.mm.plugin.appbrand.jsapi.live.a.a;
import com.tencent.mm.sdk.platformtools.x;

class i$1 implements a {
    final /* synthetic */ AppBrandLivePusherView fRN;
    final /* synthetic */ i fRS;

    i$1(i iVar, AppBrandLivePusherView appBrandLivePusherView) {
        this.fRS = iVar;
        this.fRN = appBrandLivePusherView;
    }

    public final void tA(String str) {
        x.i("MicroMsg.JsApiUpdateLivePusher", "convertBackgroundImageToLocalPath onDownload localPath:%s", new Object[]{str});
        Bundle bundle = new Bundle();
        bundle.putString("backgroundImage", str);
        this.fRN.u(bundle);
    }
}
