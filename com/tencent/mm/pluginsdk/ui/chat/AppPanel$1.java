package com.tencent.mm.pluginsdk.ui.chat;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMFlipper.a;

class AppPanel$1 implements a {
    final /* synthetic */ AppPanel qKH;

    AppPanel$1(AppPanel appPanel) {
        this.qKH = appPanel;
    }

    public final void dp(int i, int i2) {
        x.i("MicroMsg.AppPanel", "onMeasure width:" + i + " height:" + i2 + " isMeasured:" + AppPanel.a(this.qKH));
        if (!AppPanel.a(this.qKH) && i2 != 0 && i != 0) {
            if (AppPanel.b(this.qKH) == 2) {
                x.d("MicroMsg.AppPanel", "landspace");
            } else {
                x.d("MicroMsg.AppPanel", "portrait");
            }
            AppPanel.c(this.qKH);
            AppPanel.a(this.qKH, i2);
            AppPanel.b(this.qKH, i);
            AppPanel.d(this.qKH);
        } else if (i2 == 0 || i == 0) {
            x.d("MicroMsg.AppPanel", "onMeasure, width or height is 0");
        }
    }
}
