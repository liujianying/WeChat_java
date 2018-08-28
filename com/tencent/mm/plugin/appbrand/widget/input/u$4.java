package com.tencent.mm.plugin.appbrand.widget.input;

import com.tencent.mm.plugin.appbrand.widget.input.panel.AppBrandSmileyPanelBase.a;

class u$4 implements a {
    final /* synthetic */ u gIs;

    u$4(u uVar) {
        this.gIs = uVar;
    }

    public final void append(String str) {
        if (u.c(this.gIs) != null) {
            u.c(this.gIs).wi(str);
        }
    }

    public final void apK() {
        if (u.c(this.gIs) != null) {
            u.c(this.gIs).wi("[DELETE_EMOTION]");
        }
    }
}
