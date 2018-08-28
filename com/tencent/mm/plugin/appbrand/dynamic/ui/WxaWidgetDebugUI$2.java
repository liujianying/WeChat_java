package com.tencent.mm.plugin.appbrand.dynamic.ui;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.widget.l;
import com.tencent.mm.plugin.appbrand.widget.m;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;

class WxaWidgetDebugUI$2 implements a {
    final /* synthetic */ WxaWidgetDebugUI fxT;

    WxaWidgetDebugUI$2(WxaWidgetDebugUI wxaWidgetDebugUI) {
        this.fxT = wxaWidgetDebugUI;
    }

    public final void cf(boolean z) {
        this.fxT.fxS.field_openDebug = z;
        m abd = ((com.tencent.mm.plugin.appbrand.widget.a.a) g.l(com.tencent.mm.plugin.appbrand.widget.a.a.class)).abd();
        l lVar = this.fxT.fxS;
        if (lVar != null && !bi.oW(lVar.field_appId)) {
            lVar.field_appIdHash = lVar.field_appId.hashCode();
            abd.a(lVar);
        }
    }
}
