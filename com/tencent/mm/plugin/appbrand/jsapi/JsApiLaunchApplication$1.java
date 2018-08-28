package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Bundle;
import com.tencent.mm.ab.b;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.x;

class JsApiLaunchApplication$1 implements a {
    final /* synthetic */ int doP;
    final /* synthetic */ l fCl;
    final /* synthetic */ String fFT;
    final /* synthetic */ Bundle fFU;
    final /* synthetic */ String fFV;
    final /* synthetic */ String fFW;
    final /* synthetic */ String fFX;
    final /* synthetic */ JsApiLaunchApplication fFY;

    JsApiLaunchApplication$1(JsApiLaunchApplication jsApiLaunchApplication, l lVar, int i, String str, Bundle bundle, String str2, String str3, String str4) {
        this.fFY = jsApiLaunchApplication;
        this.fCl = lVar;
        this.doP = i;
        this.fFT = str;
        this.fFU = bundle;
        this.fFV = str2;
        this.fFW = str3;
        this.fFX = str4;
    }

    public final void a(int i, int i2, String str, b bVar) {
        x.i("MicroMsg.JsApiLaunchApplication", "on RunCgi callback errType:%d errCode:%d msg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        com.tencent.mm.bu.a.post(new 1(this, i, i2, bVar));
    }
}
