package com.tencent.mm.plugin.game.ui;

import com.tencent.mm.sdk.platformtools.al.a;

class d$1 implements a {
    final /* synthetic */ d jUi;

    d$1(d dVar) {
        this.jUi = dVar;
    }

    public final boolean vD() {
        if (d.a(this.jUi) != null) {
            d.a(this.jUi).cancel();
        }
        return true;
    }
}
