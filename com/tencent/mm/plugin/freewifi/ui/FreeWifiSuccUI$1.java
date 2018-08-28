package com.tencent.mm.plugin.freewifi.ui;

import android.view.View;
import android.view.View.OnClickListener;

class FreeWifiSuccUI$1 implements OnClickListener {
    final /* synthetic */ FreeWifiSuccUI jol;

    FreeWifiSuccUI$1(FreeWifiSuccUI freeWifiSuccUI) {
        this.jol = freeWifiSuccUI;
    }

    public final void onClick(View view) {
        this.jol.finish();
        FreeWifiSuccUI.a(this.jol);
    }
}
