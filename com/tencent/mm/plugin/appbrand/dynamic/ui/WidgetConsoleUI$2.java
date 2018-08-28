package com.tencent.mm.plugin.appbrand.dynamic.ui;

import android.widget.Toast;
import com.tencent.mm.plugin.appbrand.wxawidget.b.e;

class WidgetConsoleUI$2 implements Runnable {
    final /* synthetic */ WidgetConsoleUI fxP;
    final /* synthetic */ String fxQ;

    WidgetConsoleUI$2(WidgetConsoleUI widgetConsoleUI, String str) {
        this.fxP = widgetConsoleUI;
        this.fxQ = str;
    }

    public final void run() {
        this.fxP.setMMTitle(String.format("%s%s", new Object[]{this.fxP.getString(e.wxa_widget_console), this.fxQ}));
        Toast.makeText(this.fxP.mController.tml, String.format("%s%s", new Object[]{this.fxP.id, this.fxQ}), 1).show();
    }
}
