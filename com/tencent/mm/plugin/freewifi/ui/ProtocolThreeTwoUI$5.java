package com.tencent.mm.plugin.freewifi.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.freewifi.l;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.x;

class ProtocolThreeTwoUI$5 implements OnClickListener {
    final /* synthetic */ ProtocolThreeTwoUI joB;

    ProtocolThreeTwoUI$5(ProtocolThreeTwoUI protocolThreeTwoUI) {
        this.joB = protocolThreeTwoUI;
    }

    public final void onClick(View view) {
        l.t(d.aOB(), this.joB.getIntent().getStringExtra("free_wifi_ap_key"), this.joB.getIntent().getIntExtra("free_wifi_protocol_type", 0));
        x.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.connectWifiBtn.setOnClickListener, desc=User click the connect button and starts the connect wifi process. state=%s", new Object[]{m.E(this.joB.getIntent()), Integer.valueOf(m.F(this.joB.getIntent())), d.pZ(this.joB.aPq())});
        if (this.joB.aPq() == 2) {
            this.joB.finish();
            return;
        }
        d.a(this.joB.ssid, 1, this.joB.getIntent());
        this.joB.connect();
    }
}
