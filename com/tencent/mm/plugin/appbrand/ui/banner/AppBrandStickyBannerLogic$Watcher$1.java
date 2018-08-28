package com.tencent.mm.plugin.appbrand.ui.banner;

import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.Watcher;

class AppBrandStickyBannerLogic$Watcher$1 implements f {
    final /* synthetic */ Watcher gyn;

    AppBrandStickyBannerLogic$Watcher$1(Watcher watcher) {
        this.gyn = watcher;
    }

    public final void an(String str, int i) {
        this.gyn.gyk = str;
        this.gyn.gyl = i;
        Watcher.a(this.gyn);
    }
}
