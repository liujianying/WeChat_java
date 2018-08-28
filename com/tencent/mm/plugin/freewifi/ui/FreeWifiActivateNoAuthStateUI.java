package com.tencent.mm.plugin.freewifi.ui;

import android.net.NetworkInfo.State;
import android.os.Bundle;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.x;

@Deprecated
public abstract class FreeWifiActivateNoAuthStateUI extends FreeWifiActivateStateUI {
    private String eSH;
    private int jlR;
    private boolean jlS;

    protected abstract String aPr();

    public void onCreate(Bundle bundle) {
        this.jlR = getIntent().getIntExtra("free_wifi_encrypt_type", 0);
        this.eSH = getIntent().getStringExtra("free_wifi_passowrd");
        this.jlS = getIntent().getBooleanExtra("free_wifi_hide_ssid", false);
        super.onCreate(bundle);
        d.a(this.ssid, 1, getIntent());
        x.i("MicroMsg.FreeWifi.FreeWifiActivateNoAuthStateUI", "Comes from webview, do auth");
    }

    protected final void initView() {
        super.initView();
        this.jlX.setVisibility(0);
        setMMTitle(aPr());
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    public void a(State state) {
        x.i("MicroMsg.FreeWifi.FreeWifiActivateNoAuthStateUI", "now network state : %s", new Object[]{state.toString()});
        if (state == State.CONNECTED && d.BY(this.ssid)) {
            aPu();
            this.jma = false;
            d.a(this.ssid, 2, getIntent());
        }
    }

    protected final void Yz() {
        aPp();
    }

    protected final void aPp() {
        if (this.jma) {
            x.i("MicroMsg.FreeWifi.FreeWifiActivateNoAuthStateUI", "it is authing now");
            return;
        }
        this.jma = true;
        aPt();
        d.d(this.ssid, this.eSH, this.jlR, this.jlS);
    }

    protected int aPq() {
        if (!d.BY(this.ssid)) {
            return 1;
        }
        d.a(this.ssid, 2, getIntent());
        return 2;
    }
}
