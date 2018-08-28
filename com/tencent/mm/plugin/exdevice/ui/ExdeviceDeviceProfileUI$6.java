package com.tencent.mm.plugin.exdevice.ui;

import android.widget.Toast;
import com.tencent.mm.R;

class ExdeviceDeviceProfileUI$6 implements Runnable {
    final /* synthetic */ ExdeviceDeviceProfileUI iCP;

    ExdeviceDeviceProfileUI$6(ExdeviceDeviceProfileUI exdeviceDeviceProfileUI) {
        this.iCP = exdeviceDeviceProfileUI;
    }

    public final void run() {
        Toast.makeText(this.iCP.mController.tml, R.l.exdevice_unbind_failed, 1).show();
    }
}
