package com.tencent.mm.ui;

import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.storage.x;

class HomeUI$13 implements Runnable {
    final /* synthetic */ HomeUI tjS;

    HomeUI$13(HomeUI homeUI) {
        this.tjS = homeUI;
    }

    public final void run() {
        if (au.HX()) {
            au.HU();
            x DT = c.DT();
            if (DT != null) {
                DT.lm(true);
            }
        }
    }
}
