package com.tencent.mm.plugin.mall.ui;

import com.tencent.mm.g.a.tw;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class MallIndexOSUI$1 extends c<tw> {
    final /* synthetic */ MallIndexOSUI kZI;

    MallIndexOSUI$1(MallIndexOSUI mallIndexOSUI) {
        this.kZI = mallIndexOSUI;
        this.sFo = tw.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        x.i("MicroMsg.MallIndexOSUI", "WebViewCloseWindowEventListener %s", new Object[]{((tw) bVar).cfC.cfD});
        if (MallIndexOSUI.a(this.kZI) != null && MallIndexOSUI.a(this.kZI).equals(r6.cfC.cfD)) {
            MallIndexOSUI.b(this.kZI);
        }
        return false;
    }
}
