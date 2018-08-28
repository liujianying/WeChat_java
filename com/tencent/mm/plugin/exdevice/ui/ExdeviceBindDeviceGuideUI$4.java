package com.tencent.mm.plugin.exdevice.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.plugin.h.a.e.a;
import com.tencent.mm.sdk.platformtools.x;

class ExdeviceBindDeviceGuideUI$4 extends BroadcastReceiver {
    final /* synthetic */ ExdeviceBindDeviceGuideUI iAN;

    ExdeviceBindDeviceGuideUI$4(ExdeviceBindDeviceGuideUI exdeviceBindDeviceGuideUI) {
        this.iAN = exdeviceBindDeviceGuideUI;
    }

    public final void onReceive(Context context, Intent intent) {
        x.i("MicroMsg.ExdeviceBindDeviceGuideUI", "Action broadcast receive...");
        if (intent != null) {
            String action = intent.getAction();
            x.d("MicroMsg.ExdeviceBindDeviceGuideUI", "Receiver action(%s)", new Object[]{action});
            int intExtra;
            if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(action) && ExdeviceBindDeviceGuideUI.m(this.iAN)) {
                intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", -1);
                if (intExtra == 12) {
                    if (!ExdeviceBindDeviceGuideUI.o(this.iAN) || ExdeviceBindDeviceGuideUI.p(this.iAN).isProviderEnabled("gps")) {
                        ExdeviceBindDeviceGuideUI.a(this.iAN, 2);
                        return;
                    }
                } else if (intExtra == 10) {
                    ExdeviceBindDeviceGuideUI.a(this.iAN, 3);
                    return;
                } else {
                    return;
                }
            } else if ("android.net.wifi.WIFI_STATE_CHANGED".equals(action) && ExdeviceBindDeviceGuideUI.n(this.iAN)) {
                intExtra = intent.getIntExtra("wifi_state", -1);
                x.i("MicroMsg.ExdeviceBindDeviceGuideUI", "Wifi state changed action: wifiState(%d)", new Object[]{Integer.valueOf(intExtra)});
                if (intExtra == 3) {
                    ExdeviceBindDeviceGuideUI.a(this.iAN, 1);
                    return;
                } else if (intExtra == 1) {
                    ExdeviceBindDeviceGuideUI.a(this.iAN, 5);
                    return;
                } else {
                    return;
                }
            } else if (!ExdeviceBindDeviceGuideUI.o(this.iAN) || !"android.location.MODE_CHANGED".equals(action)) {
                return;
            } else {
                if (ExdeviceBindDeviceGuideUI.p(this.iAN).isProviderEnabled("gps")) {
                    if (a.atY()) {
                        ExdeviceBindDeviceGuideUI.a(this.iAN, 2);
                        return;
                    } else {
                        ExdeviceBindDeviceGuideUI.a(this.iAN, 3);
                        return;
                    }
                }
            }
            ExdeviceBindDeviceGuideUI.a(this.iAN, 6);
        }
    }
}
