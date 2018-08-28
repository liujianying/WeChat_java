package com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare;

import com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.WxaLuckyMoneyPrepareUI.16;
import com.tencent.mm.ui.widget.picker.b;
import com.tencent.mm.ui.widget.picker.b.a;

class WxaLuckyMoneyPrepareUI$16$1 implements a {
    final /* synthetic */ b gQT;
    final /* synthetic */ 16 kMx;

    WxaLuckyMoneyPrepareUI$16$1(16 16, b bVar) {
        this.kMx = 16;
        this.gQT = bVar;
    }

    public final void h(boolean z, Object obj) {
        this.gQT.hide();
        if (z) {
            WxaLuckyMoneyPrepareUI.h(this.kMx.kMq).setText((CharSequence) obj);
        }
        WxaLuckyMoneyPrepareUI.a(this.kMx.kMq, this.gQT.cAP());
    }
}
