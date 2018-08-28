package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.mm.R;
import com.tencent.mm.plugin.exdevice.ui.ExdeviceConnectWifiUI.9;
import com.tencent.mm.ui.base.h;

class ExdeviceConnectWifiUI$9$2 implements Runnable {
    final /* synthetic */ 9 iCp;

    ExdeviceConnectWifiUI$9$2(9 9) {
        this.iCp = 9;
    }

    public final void run() {
        ExdeviceConnectWifiUI.g(this.iCp.iCh).dismiss();
        h.a(this.iCp.iCh.mController.tml, this.iCp.iCh.mController.tml.getString(R.l.exdeivce_config_airkiss_timeout), "", this.iCp.iCh.mController.tml.getString(R.l.exdevice_connect_failed_confirm), "", false, new 1(this), null).show();
    }
}
