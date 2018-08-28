package com.tencent.mm.plugin.remittance.ui;

import com.tencent.mm.plugin.remittance.model.c;
import com.tencent.mm.protocal.c.xc;
import java.util.List;

class RemittanceBusiUI$4 implements c {
    final /* synthetic */ RemittanceBusiUI mBt;

    RemittanceBusiUI$4(RemittanceBusiUI remittanceBusiUI) {
        this.mBt = remittanceBusiUI;
    }

    public final void bW(List<xc> list) {
        if (list.size() > 0) {
            RemittanceBusiUI.a(this.mBt, list);
        }
    }
}
