package com.tencent.mm.plugin.exdevice.ui;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mm.sdk.platformtools.x;

class ExdeviceConnectWifiUI$14 implements OnEditorActionListener {
    final /* synthetic */ ExdeviceConnectWifiUI iCh;

    ExdeviceConnectWifiUI$14(ExdeviceConnectWifiUI exdeviceConnectWifiUI) {
        this.iCh = exdeviceConnectWifiUI;
    }

    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6 && i != 5) {
            return false;
        }
        x.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "on next Key down.");
        ExdeviceConnectWifiUI.a(this.iCh, ExdeviceConnectWifiUI.k(this.iCh));
        return true;
    }
}
