package com.tencent.mm.plugin.exdevice.ui;

import android.text.Selection;
import android.text.Spannable;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class ExdeviceConnectWifiUI$1 implements Runnable {
    final /* synthetic */ ExdeviceConnectWifiUI iCh;

    ExdeviceConnectWifiUI$1(ExdeviceConnectWifiUI exdeviceConnectWifiUI) {
        this.iCh = exdeviceConnectWifiUI;
    }

    public final void run() {
        if (bi.oW(ExdeviceConnectWifiUI.a(this.iCh))) {
            ExdeviceConnectWifiUI.c(this.iCh).setText(ExdeviceConnectWifiUI.b(this.iCh).iwG);
            Spannable text = ExdeviceConnectWifiUI.c(this.iCh).getText();
            if (text != null) {
                Selection.setSelection(text, text.length());
                return;
            }
            return;
        }
        x.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "User has input password.");
    }
}
