package com.tencent.mm.plugin.mmsight.ui;

import com.tencent.mm.plugin.mmsight.ui.SightSettingsUI.b;
import com.tencent.mm.ui.base.h.d;

class SightSettingsUI$b$1 implements d {
    final /* synthetic */ b lqJ;

    SightSettingsUI$b$1(b bVar) {
        this.lqJ = bVar;
    }

    public final void bx(int i, int i2) {
        this.lqJ.lqC.leE.set(this.lqJ.lqI, Integer.valueOf(this.lqJ.lqH[i]));
        this.lqJ.lqC.lqA.notifyDataSetChanged();
    }
}
