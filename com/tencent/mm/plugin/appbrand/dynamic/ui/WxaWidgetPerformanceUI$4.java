package com.tencent.mm.plugin.appbrand.dynamic.ui;

import android.view.View;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.plugin.appbrand.collector.c;
import com.tencent.mm.plugin.appbrand.dynamic.ui.WxaWidgetPerformanceUI.d;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;

class WxaWidgetPerformanceUI$4 implements a {
    final /* synthetic */ WxaWidgetPerformanceUI fxY;
    final /* synthetic */ View fya;

    WxaWidgetPerformanceUI$4(WxaWidgetPerformanceUI wxaWidgetPerformanceUI, View view) {
        this.fxY = wxaWidgetPerformanceUI;
        this.fya = view;
    }

    public final void cf(boolean z) {
        f.a("com.tencent.mm:support", new IPCBoolean(z), d.class, null);
        c.cx(z);
        this.fya.setEnabled(z);
        this.fxY.fxV.setEnabled(z);
        this.fxY.fxW.setEnabled(z);
        this.fxY.fxX.setEnabled(z);
    }
}
