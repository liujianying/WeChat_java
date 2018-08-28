package com.tencent.mm.plugin.appbrand.ipc;

class AppBrandProxyUIProcessTask$1 implements Runnable {
    final /* synthetic */ AppBrandProxyUIProcessTask$ProcessResult fEd;
    final /* synthetic */ AppBrandProxyUIProcessTask fEo;

    AppBrandProxyUIProcessTask$1(AppBrandProxyUIProcessTask appBrandProxyUIProcessTask, AppBrandProxyUIProcessTask$ProcessResult appBrandProxyUIProcessTask$ProcessResult) {
        this.fEo = appBrandProxyUIProcessTask;
        this.fEd = appBrandProxyUIProcessTask$ProcessResult;
    }

    public final void run() {
        if (this.fEo.fEn != null) {
            this.fEo.fEn.a(this.fEd);
        }
    }
}
