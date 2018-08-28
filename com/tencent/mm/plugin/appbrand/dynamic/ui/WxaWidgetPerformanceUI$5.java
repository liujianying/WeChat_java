package com.tencent.mm.plugin.appbrand.dynamic.ui;

import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.plugin.appbrand.collector.c;
import com.tencent.mm.plugin.appbrand.dynamic.ui.WxaWidgetPerformanceUI.b;
import com.tencent.mm.ui.widget.MMSwitchBtn$a;

class WxaWidgetPerformanceUI$5 implements MMSwitchBtn$a {
    final /* synthetic */ WxaWidgetPerformanceUI fxY;

    WxaWidgetPerformanceUI$5(WxaWidgetPerformanceUI wxaWidgetPerformanceUI) {
        this.fxY = wxaWidgetPerformanceUI;
    }

    public final void cf(boolean z) {
        f.a("com.tencent.mm:support", new IPCBoolean(z), b.class, null);
        if (z) {
            c.ry("jsapi_draw_canvas");
        } else {
            c.rz("jsapi_draw_canvas");
        }
    }
}
