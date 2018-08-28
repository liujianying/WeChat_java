package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyTransparentUIProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiLaunchApplication.LaunchApplicationTask;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiLaunchApplication.a.a;
import com.tencent.mm.sdk.platformtools.x;

class JsApiLaunchApplication$LaunchApplicationTask$1 implements a {
    final /* synthetic */ AppBrandProxyTransparentUIProcessTask.a fGf;
    final /* synthetic */ LaunchApplicationTask fGg;

    JsApiLaunchApplication$LaunchApplicationTask$1(LaunchApplicationTask launchApplicationTask, AppBrandProxyTransparentUIProcessTask.a aVar) {
        this.fGg = launchApplicationTask;
        this.fGf = aVar;
    }

    public final void r(boolean z, boolean z2) {
        x.i("MicroMsg.JsApiLaunchApplication", "onLaunchAppCallback(launchRet : %s, launchSuccess : %s)", new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)});
        if (z) {
            this.fGg.success = true;
            this.fGf.ahz();
            return;
        }
        this.fGg.success = false;
        this.fGf.ahz();
    }
}
