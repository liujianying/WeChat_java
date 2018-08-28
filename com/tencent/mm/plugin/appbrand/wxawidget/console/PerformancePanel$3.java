package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.view.View;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.plugin.appbrand.collector.c;
import com.tencent.mm.plugin.appbrand.wxawidget.console.PerformancePanel.d;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;

class PerformancePanel$3 implements a {
    final /* synthetic */ View fya;
    final /* synthetic */ PerformancePanel gQM;

    PerformancePanel$3(PerformancePanel performancePanel, View view) {
        this.gQM = performancePanel;
        this.fya = view;
    }

    public final void cf(boolean z) {
        f.a("com.tencent.mm:support", new IPCBoolean(z), d.class, null);
        c.cx(z);
        this.fya.setEnabled(z);
        this.gQM.fxV.setEnabled(z);
        this.gQM.fxW.setEnabled(z);
        this.gQM.fxX.setEnabled(z);
    }
}
