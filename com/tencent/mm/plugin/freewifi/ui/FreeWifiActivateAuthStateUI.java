package com.tencent.mm.plugin.freewifi.ui;

import android.net.NetworkInfo.State;
import android.os.Bundle;
import android.widget.Button;
import com.tencent.mm.R;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.sdk.platformtools.x;

@Deprecated
public class FreeWifiActivateAuthStateUI extends FreeWifiActivateStateUI {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.source != 2) {
            d.a(this.ssid, 1, getIntent());
        }
        x.i("MicroMsg.FreeWifi.FreeWifiActivateAuthStateUI", "now it is from qrcode, try to auth");
    }

    protected final void initView() {
        super.initView();
        this.jlX = (Button) findViewById(R.h.help_btn);
        this.jlX.setOnClickListener(new 1(this));
        setMMTitle(R.l.free_wifi_title);
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    public final void a(State state) {
        x.i("MicroMsg.FreeWifi.FreeWifiActivateAuthStateUI", "now network state : %s", new Object[]{state.toString()});
        if (state == State.CONNECTED && d.BY(this.ssid)) {
            aPu();
            aPw();
        }
    }

    protected final void Yz() {
        j.aOP().a(this.ssid, new 2(this), this.bxk, getIntent());
    }

    protected final void aPp() {
        aPt();
        d.BZ(this.ssid);
    }

    protected final int aPq() {
        j.aOJ();
        return d.BX(this.ssid);
    }
}
