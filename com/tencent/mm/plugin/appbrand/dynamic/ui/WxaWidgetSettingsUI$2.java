package com.tencent.mm.plugin.appbrand.dynamic.ui;

import com.tencent.mm.plugin.appbrand.dynamic.debugger.DebuggerInfo;
import com.tencent.mm.plugin.appbrand.dynamic.debugger.b;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;

class WxaWidgetSettingsUI$2 implements a {
    final /* synthetic */ WxaWidgetSettingsUI fyb;

    WxaWidgetSettingsUI$2(WxaWidgetSettingsUI wxaWidgetSettingsUI) {
        this.fyb = wxaWidgetSettingsUI;
    }

    public final void cf(boolean z) {
        DebuggerInfo sD = b.sD(this.fyb.appId);
        if (sD == null) {
            sD = new DebuggerInfo();
            b.a(this.fyb.appId, sD);
        }
        sD.fvF = z;
    }
}
