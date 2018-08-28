package com.tencent.mm.plugin.appbrand.ui.widget;

import android.view.View;

class AppBrandLoadIconPreference$4 implements Runnable {
    final /* synthetic */ AppBrandLoadIconPreference gBj;
    final /* synthetic */ View val$view;

    AppBrandLoadIconPreference$4(AppBrandLoadIconPreference appBrandLoadIconPreference, View view) {
        this.gBj = appBrandLoadIconPreference;
        this.val$view = view;
    }

    public final void run() {
        this.val$view.setVisibility(8);
    }
}
