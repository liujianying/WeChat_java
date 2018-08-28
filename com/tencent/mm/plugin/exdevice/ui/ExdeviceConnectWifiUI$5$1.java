package com.tencent.mm.plugin.exdevice.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.exdevice.ui.ExdeviceConnectWifiUI.5;
import com.tencent.mm.sdk.platformtools.x;

class ExdeviceConnectWifiUI$5$1 implements OnCancelListener {
    final /* synthetic */ 5 iCm;

    ExdeviceConnectWifiUI$5$1(5 5) {
        this.iCm = 5;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        x.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "On progress cancel, stop airkiss");
        if (ExdeviceConnectWifiUI.d(this.iCm.iCh) != ExdeviceConnectWifiUI$b.iCu) {
            ExdeviceConnectWifiUI.r(this.iCm.iCh);
        }
    }
}
