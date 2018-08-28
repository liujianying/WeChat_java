package com.tencent.mm.plugin.mall.ui;

import com.tencent.mm.g.a.tz;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;

class MallIndexOSUI$2 extends c<tz> {
    final /* synthetic */ MallIndexOSUI kZI;

    MallIndexOSUI$2(MallIndexOSUI mallIndexOSUI) {
        this.kZI = mallIndexOSUI;
        this.sFo = tz.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        x.i("MicroMsg.MallIndexOSUI", "WebViewUIDestroyEvent %s isCloseWindow %s", new Object[]{((tz) bVar).cfG.cfD, Boolean.valueOf(MallIndexOSUI.c(this.kZI))});
        if (MallIndexOSUI.a(this.kZI) != null && MallIndexOSUI.a(this.kZI).equals(r7.cfG.cfD)) {
            MallIndexOSUI.d(this.kZI);
            ah.i(new 1(this), 500);
        }
        return false;
    }
}
