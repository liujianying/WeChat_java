package com.tencent.mm.plugin.ipcall.ui;

import com.tencent.mm.plugin.ipcall.ui.IPCallFuncButton.a;
import com.tencent.mm.plugin.report.service.h;

class j$11 implements a {
    final /* synthetic */ j kzY;

    j$11(j jVar) {
        this.kzY = jVar;
    }

    public final void ga(boolean z) {
        j jVar;
        if (z) {
            jVar = this.kzY;
            if (jVar.kzs == null) {
                jVar.eBM.setVisibility(8);
            } else {
                jVar.eBM.setVisibility(4);
            }
            jVar.eBM.setVisibility(8);
            jVar.kzD.setVisibility(8);
            jVar.kzB.setText("");
            jVar.kzC.setText("");
            jVar.ksT.setVisibility(0);
        } else {
            jVar = this.kzY;
            if (jVar.kzs != null) {
                jVar.eBM.setVisibility(0);
                jVar.kzD.setVisibility(8);
            } else {
                jVar.kzD.setVisibility(0);
                jVar.eBM.setVisibility(8);
            }
            jVar.Fj(jVar.kzM);
            jVar.ksT.setVisibility(4);
        }
        h.mEJ.h(12057, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0)});
    }
}
