package com.tencent.mm.plugin.ipcall.ui;

import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.ipcall.ui.IPCallFuncButton.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;

class j$9 implements a {
    final /* synthetic */ j kzY;

    j$9(j jVar) {
        this.kzY = jVar;
    }

    public final void ga(boolean z) {
        x.d("MicroMsg.TalkUIController", "switch speaker, isChecked: %b", new Object[]{Boolean.valueOf(z)});
        if (i.aXt().aXk()) {
            this.kzY.kzS = z;
            this.kzY.kzT = z;
            i.aXs().fT(z);
            h.mEJ.h(12057, new Object[]{Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0)});
        } else if (!i.aXz().alf() && !i.aXt().aXm()) {
            i.aXz().iX(z);
        }
    }
}
