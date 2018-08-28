package com.tencent.mm.plugin.appbrand.widget.actionbar;

class AppBrandOptionButton$1 implements Runnable {
    final /* synthetic */ AppBrandOptionButton gFB;

    AppBrandOptionButton$1(AppBrandOptionButton appBrandOptionButton) {
        this.gFB = appBrandOptionButton;
    }

    public final void run() {
        this.gFB.gFA.setVisibility(0);
        AppBrandOptionButton.a(this.gFB).end();
        AppBrandOptionButton.a(this.gFB).start();
    }
}
