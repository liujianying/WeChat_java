package com.tencent.mm.plugin.exdevice.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class ExdeviceConnectWifiUI$10 implements OnMenuItemClickListener {
    final /* synthetic */ ExdeviceConnectWifiUI iCh;

    ExdeviceConnectWifiUI$10(ExdeviceConnectWifiUI exdeviceConnectWifiUI) {
        this.iCh = exdeviceConnectWifiUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        if (!ExdeviceConnectWifiUI.h(this.iCh)) {
            boolean z;
            Intent intent = new Intent();
            String str = "is_wifi_connected";
            if (ExdeviceConnectWifiUI.d(this.iCh) != ExdeviceConnectWifiUI$b.iCs) {
                z = true;
            } else {
                z = false;
            }
            intent.putExtra(str, z);
            this.iCh.setResult(0, intent);
            this.iCh.finish();
        }
        return false;
    }
}
