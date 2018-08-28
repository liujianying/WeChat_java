package com.tencent.mm.plugin.appbrand.wxawidget.console;

import com.tencent.mm.plugin.appbrand.wxawidget.console.SettingsPanel.4;
import com.tencent.mm.ui.widget.picker.b;
import com.tencent.mm.ui.widget.picker.b.a;

class SettingsPanel$4$1 implements a {
    final /* synthetic */ b gQT;
    final /* synthetic */ 4 gQV;

    SettingsPanel$4$1(4 4, b bVar) {
        this.gQV = 4;
        this.gQT = bVar;
    }

    public final void h(boolean z, Object obj) {
        this.gQT.hide();
        if (z) {
            SettingsPanel.c(this.gQV.gQR).setText((CharSequence) obj);
        }
        SettingsPanel.b(this.gQV.gQR, this.gQT.cAP());
    }
}
