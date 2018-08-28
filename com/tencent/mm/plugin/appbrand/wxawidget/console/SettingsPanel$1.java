package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bu.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.e;

class SettingsPanel$1 implements OnClickListener {
    final /* synthetic */ SettingsPanel gQR;

    SettingsPanel$1(SettingsPanel settingsPanel) {
        this.gQR = settingsPanel;
    }

    public final void onClick(View view) {
        ((e) g.l(e.class)).JM().restart();
        a.j(new 1(this), 2000);
    }
}
