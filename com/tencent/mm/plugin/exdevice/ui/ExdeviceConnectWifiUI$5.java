package com.tencent.mm.plugin.exdevice.ui;

import android.support.v7.app.ActionBarActivity;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.h;

class ExdeviceConnectWifiUI$5 implements Runnable {
    final /* synthetic */ ExdeviceConnectWifiUI iCh;

    ExdeviceConnectWifiUI$5(ExdeviceConnectWifiUI exdeviceConnectWifiUI) {
        this.iCh = exdeviceConnectWifiUI;
    }

    public final void run() {
        ExdeviceConnectWifiUI exdeviceConnectWifiUI = this.iCh;
        ActionBarActivity actionBarActivity = this.iCh.mController.tml;
        this.iCh.getString(R.l.app_tip);
        ExdeviceConnectWifiUI.a(exdeviceConnectWifiUI, h.a(actionBarActivity, this.iCh.getString(R.l.exdevice_setting_status), true, new 1(this)));
    }
}
