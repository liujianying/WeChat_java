package com.tencent.mm.plugin.appbrand.wxawidget.console;

import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.plugin.appbrand.wxawidget.console.PerformancePanel.c;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;

class PerformancePanel$5 implements a {
    final /* synthetic */ PerformancePanel gQM;

    PerformancePanel$5(PerformancePanel performancePanel) {
        this.gQM = performancePanel;
    }

    public final void cf(boolean z) {
        f.a("com.tencent.mm:support", new IPCBoolean(z), c.class, null);
        if (z) {
            com.tencent.mm.plugin.appbrand.collector.c.ry("widget_launch");
        } else {
            com.tencent.mm.plugin.appbrand.collector.c.rz("widget_launch");
        }
    }
}
