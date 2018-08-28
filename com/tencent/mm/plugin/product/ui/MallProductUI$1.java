package com.tencent.mm.plugin.product.ui;

import com.tencent.mm.plugin.product.ui.f.a;

class MallProductUI$1 implements a {
    final /* synthetic */ MallProductUI lUa;

    MallProductUI$1(MallProductUI mallProductUI) {
        this.lUa = mallProductUI;
    }

    public final void m(int i, int i2, String str) {
        if (i == 0 && i2 == 0) {
            this.lUa.aL();
            if (MallProductUI.a(this.lUa) != null) {
                MallProductUI.a(this.lUa).postDelayed(new 1(this), 200);
            }
        } else if (i2 == -10010003) {
            this.lUa.ux(0);
            MallProductUI.b(this.lUa).setVisibility(8);
            MallProductUI.c(this.lUa).setVisibility(0);
            MallProductUI.d(this.lUa);
        } else {
            this.lUa.JB(str);
        }
    }
}
