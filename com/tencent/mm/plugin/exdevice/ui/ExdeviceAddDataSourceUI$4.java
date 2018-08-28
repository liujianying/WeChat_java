package com.tencent.mm.plugin.exdevice.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.map.geolocation.internal.TencentExtraKeys;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.exdevice.model.e;
import com.tencent.mm.plugin.h.a.e.a;
import com.tencent.mm.sdk.platformtools.x;

class ExdeviceAddDataSourceUI$4 extends BroadcastReceiver {
    final /* synthetic */ ExdeviceAddDataSourceUI iAm;

    ExdeviceAddDataSourceUI$4(ExdeviceAddDataSourceUI exdeviceAddDataSourceUI) {
        this.iAm = exdeviceAddDataSourceUI;
    }

    public final void onReceive(Context context, Intent intent) {
        if (intent == null) {
            x.i("MicroMsg.ExdeviceAddDataSourceUI", "Receive action broadcast failed...");
            return;
        }
        String action = intent.getAction();
        if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(action)) {
            if (intent.getIntExtra("android.bluetooth.adapter.extra.STATE", Integer.MIN_VALUE) == 12) {
                if (a.atY()) {
                    this.iAm.runOnUiThread(new Runnable() {
                        public final void run() {
                            if (!ExdeviceAddDataSourceUI.a(ExdeviceAddDataSourceUI$4.this.iAm) || ExdeviceAddDataSourceUI.b(ExdeviceAddDataSourceUI$4.this.iAm).isProviderEnabled(TencentExtraKeys.LOCATION_SOURCE_GPS)) {
                                ExdeviceAddDataSourceUI.a(ExdeviceAddDataSourceUI$4.this.iAm, 3);
                                x.i("MicroMsg.ExdeviceAddDataSourceUI", "Start scan...");
                                return;
                            }
                            ExdeviceAddDataSourceUI.a(ExdeviceAddDataSourceUI$4.this.iAm, 4);
                        }
                    });
                    if (!ExdeviceAddDataSourceUI.a(this.iAm) || ExdeviceAddDataSourceUI.b(this.iAm).isProviderEnabled(TencentExtraKeys.LOCATION_SOURCE_GPS)) {
                        ad.aHp();
                        e.aGR();
                    }
                }
            } else if (intent.getIntExtra("android.bluetooth.adapter.extra.STATE", Integer.MIN_VALUE) == 10 && !a.atY()) {
                this.iAm.runOnUiThread(new 2(this));
                ad.aHq().atI();
            }
        }
        if (!ExdeviceAddDataSourceUI.a(this.iAm) || !"android.location.MODE_CHANGED".equals(action)) {
            return;
        }
        if (ExdeviceAddDataSourceUI.b(this.iAm).isProviderEnabled(TencentExtraKeys.LOCATION_SOURCE_GPS)) {
            this.iAm.runOnUiThread(new Runnable() {
                public final void run() {
                    if (a.atY()) {
                        ExdeviceAddDataSourceUI.a(ExdeviceAddDataSourceUI$4.this.iAm, 3);
                        x.i("MicroMsg.ExdeviceAddDataSourceUI", "Start scan...");
                        return;
                    }
                    ExdeviceAddDataSourceUI.a(ExdeviceAddDataSourceUI$4.this.iAm, 1);
                }
            });
            if (a.atY()) {
                ad.aHp();
                e.aGR();
                return;
            }
            return;
        }
        this.iAm.runOnUiThread(new 4(this));
        ad.aHq().atI();
    }
}
