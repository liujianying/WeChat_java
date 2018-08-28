package com.tencent.mm.ui;

import com.tencent.mm.blink.FirstScreenFrameLayout.a;
import com.tencent.mm.blink.b;
import com.tencent.mm.vending.g.g;

class HomeUI$1 implements a {
    final /* synthetic */ HomeUI tjS;

    HomeUI$1(HomeUI homeUI) {
        this.tjS = homeUI;
    }

    public final void xs() {
        if (com.tencent.mm.blink.a.xf()) {
            com.tencent.mm.blink.a.fm(6);
            com.tencent.mm.blink.a.xg();
            com.tencent.mm.blink.a.ey("First Screen");
            g.cBK().gR(500).d(new 1(this));
        }
        b.xi().xm();
    }
}
