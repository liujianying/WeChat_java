package com.tencent.mm.plugin.freewifi.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.freewifi.model.d;

class FreeWifiActivateStateUI$5 implements OnClickListener {
    final /* synthetic */ FreeWifiActivateStateUI jmf;

    FreeWifiActivateStateUI$5(FreeWifiActivateStateUI freeWifiActivateStateUI) {
        this.jmf = freeWifiActivateStateUI;
    }

    public final void onClick(View view) {
        if (this.jmf.aPq() == 2) {
            this.jmf.finish();
            return;
        }
        d.a(this.jmf.ssid, 1, this.jmf.getIntent());
        this.jmf.jma = false;
        this.jmf.aPw();
    }
}
