package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class AppBrandPrepareTask$4 implements Runnable {
    final /* synthetic */ AppBrandPrepareTask geW;
    final /* synthetic */ WxaPkgWrappingInfo geX;

    AppBrandPrepareTask$4(AppBrandPrepareTask appBrandPrepareTask, WxaPkgWrappingInfo wxaPkgWrappingInfo) {
        this.geW = appBrandPrepareTask;
        this.geX = wxaPkgWrappingInfo;
    }

    public final void run() {
        x.i("MicroMsg.AppBrandPrepareTask", "runInClientProcess, prepare done, appPkg [%d | %s]", new Object[]{Integer.valueOf(this.geX.fii), bi.gb(this.geX.fij)});
    }
}
