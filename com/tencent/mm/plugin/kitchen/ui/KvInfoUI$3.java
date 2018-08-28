package com.tencent.mm.plugin.kitchen.ui;

import com.tencent.mm.plugin.report.a;
import com.tencent.mm.plugin.report.service.e;
import com.tencent.mm.plugin.report.service.j;
import com.tencent.mm.ui.widget.MMSwitchBtn$a;

class KvInfoUI$3 implements MMSwitchBtn$a {
    final /* synthetic */ KvInfoUI kAs;

    KvInfoUI$3(KvInfoUI kvInfoUI) {
        this.kAs = kvInfoUI;
    }

    public final void cf(boolean z) {
        j brV = j.brV();
        brV.mDt = z;
        e.hr(brV.mDt);
        a.hr(brV.mDt);
    }
}
