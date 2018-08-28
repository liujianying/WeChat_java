package com.tencent.mm.plugin.appbrand.ui.banner;

import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.a;
import com.tencent.mm.sdk.platformtools.bi;

class AppBrandStickyBannerLogic$a$1 implements f {
    final /* synthetic */ String bAj;

    AppBrandStickyBannerLogic$a$1(String str) {
        this.bAj = str;
    }

    public final void an(String str, int i) {
        if (bi.oW(str)) {
            if (Boolean.TRUE.equals(a.anU().get(this.bAj))) {
                a.anV().ab(this.bAj, false);
            }
            a.anU().put(this.bAj, Boolean.valueOf(false));
        } else if (this.bAj.equals(str)) {
            a.anU().put(this.bAj, Boolean.valueOf(true));
            a.anV().ab(this.bAj, true);
        } else {
            a.anU().put(this.bAj, Boolean.valueOf(false));
            a.anV().ab(this.bAj, false);
        }
    }
}
