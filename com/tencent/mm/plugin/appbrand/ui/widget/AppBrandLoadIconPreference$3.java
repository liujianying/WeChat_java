package com.tencent.mm.plugin.appbrand.ui.widget;

class AppBrandLoadIconPreference$3 implements Runnable {
    final /* synthetic */ AppBrandLoadIconPreference gBj;
    final /* synthetic */ boolean gBk;

    AppBrandLoadIconPreference$3(AppBrandLoadIconPreference appBrandLoadIconPreference, boolean z) {
        this.gBj = appBrandLoadIconPreference;
        this.gBk = z;
    }

    public final void run() {
        if (this.gBk && AppBrandLoadIconPreference.c(this.gBj) != null) {
            AppBrandLoadIconPreference.c(this.gBj).aoU();
        }
    }
}
