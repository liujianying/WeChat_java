package com.tencent.mm.plugin.freewifi.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.freewifi.model.d;

class FreeWifiStateUI$9 implements OnCancelListener {
    final /* synthetic */ FreeWifiStateUI jnZ;

    FreeWifiStateUI$9(FreeWifiStateUI freeWifiStateUI) {
        this.jnZ = freeWifiStateUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        d.a(this.jnZ.ssid, 4, this.jnZ.getIntent());
    }
}
