package com.tencent.mm.plugin.appbrand.ipc;

import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;

class AppBrandProcessProxyUI$4 implements Runnable {
    final /* synthetic */ AppBrandProcessProxyUI fEc;
    final /* synthetic */ ProcessResult fEd;

    AppBrandProcessProxyUI$4(AppBrandProcessProxyUI appBrandProcessProxyUI, ProcessResult processResult) {
        this.fEc = appBrandProcessProxyUI;
        this.fEd = processResult;
    }

    public final void run() {
        this.fEc.b(this.fEd);
        this.fEc.finish();
    }
}
