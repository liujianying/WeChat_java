package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.widget.Toast;
import com.tencent.mm.plugin.appbrand.wxawidget.b.e;
import com.tencent.mm.plugin.appbrand.wxawidget.console.SettingsPanel.1;

class SettingsPanel$1$1 implements Runnable {
    final /* synthetic */ 1 gQS;

    SettingsPanel$1$1(1 1) {
        this.gQS = 1;
    }

    public final void run() {
        Toast.makeText(this.gQS.gQR.getContext(), e.wxa_widget_restart_support_process_succ, 1).show();
        if (SettingsPanel.a(this.gQS.gQR) != null) {
            SettingsPanel.a(this.gQS.gQR).run();
        }
    }
}
