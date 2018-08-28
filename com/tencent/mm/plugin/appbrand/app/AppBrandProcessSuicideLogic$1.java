package com.tencent.mm.plugin.appbrand.app;

class AppBrandProcessSuicideLogic$1 implements Runnable {
    final /* synthetic */ Class fev;
    final /* synthetic */ AppBrandProcessSuicideLogic few;

    AppBrandProcessSuicideLogic$1(AppBrandProcessSuicideLogic appBrandProcessSuicideLogic, Class cls) {
        this.few = appBrandProcessSuicideLogic;
        this.fev = cls;
    }

    public final void run() {
        AppBrandProcessSuicideLogic.a(this.few, this.fev);
    }
}
