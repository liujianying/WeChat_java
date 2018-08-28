package com.tencent.mm.plugin.appbrand.wxawidget.console;

import com.tencent.mm.plugin.appbrand.wxawidget.console.SettingsPanel.3;
import com.tencent.mm.ui.widget.picker.b;
import com.tencent.mm.ui.widget.picker.b.a;

class SettingsPanel$3$1 implements a {
    final /* synthetic */ b gQT;
    final /* synthetic */ 3 gQU;

    SettingsPanel$3$1(3 3, b bVar) {
        this.gQU = 3;
        this.gQT = bVar;
    }

    public final void h(boolean z, Object obj) {
        this.gQT.hide();
        if (z) {
            this.gQU.gQR.gQN.setText((CharSequence) obj);
        }
        this.gQU.gQR.mt(this.gQT.cAP());
    }
}
