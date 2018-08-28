package com.tencent.mm.plugin.freewifi.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.freewifi.l;
import com.tencent.mm.plugin.freewifi.model.d;

class FreeWifiStateUI$5 implements OnClickListener {
    final /* synthetic */ FreeWifiStateUI jnZ;

    FreeWifiStateUI$5(FreeWifiStateUI freeWifiStateUI) {
        this.jnZ = freeWifiStateUI;
    }

    public final void onClick(View view) {
        l.t(d.aOB(), this.jnZ.getIntent().getStringExtra("free_wifi_ap_key"), this.jnZ.getIntent().getIntExtra("free_wifi_protocol_type", 0));
        if (this.jnZ.aPq() == 2) {
            this.jnZ.finish();
            return;
        }
        d.a(this.jnZ.ssid, 1, this.jnZ.getIntent());
        this.jnZ.jma = false;
        this.jnZ.aPw();
    }
}
