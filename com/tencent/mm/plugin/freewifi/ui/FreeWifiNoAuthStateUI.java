package com.tencent.mm.plugin.freewifi.ui;

import android.net.NetworkInfo.State;
import android.os.Bundle;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k$b;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.x;

@Deprecated
public abstract class FreeWifiNoAuthStateUI extends FreeWifiStateUI {
    private String eSH;
    private int jlR;
    private boolean jlS;

    protected abstract String aPr();

    public void onCreate(Bundle bundle) {
        this.jlR = getIntent().getIntExtra("free_wifi_encrypt_type", 0);
        this.eSH = getIntent().getStringExtra("free_wifi_passowrd");
        this.jlS = getIntent().getBooleanExtra("free_wifi_hide_ssid", false);
        super.onCreate(bundle);
        d.a(this.ssid, 4, getIntent());
        x.i("MicroMsg.FreeWifi.FreeWifiNoAuthStateUI", "Comes from webview, do auth");
    }

    protected final void initView() {
        super.initView();
        setMMTitle(aPr());
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    public void a(State state) {
        x.i("MicroMsg.FreeWifi.FreeWifiNoAuthStateUI", "now network state : %s", new Object[]{state.toString()});
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
            x.i("MicroMsg.FreeWifi.FreeWifiNoAuthStateUI", "it is authing now");
            return;
        }
        this.jma = true;
        aPt();
        int d = d.d(this.ssid, this.eSH, this.jlR, this.jlS);
        a aOa = k.aOa();
        aOa.ssid = this.ssid;
        aOa.bIQ = this.bIQ;
        aOa.jid = m.E(getIntent());
        aOa.jie = m.G(getIntent());
        aOa.jif = k$b.AddNetwork.jiQ;
        aOa.jig = k$b.AddNetwork.name;
        aOa.result = d;
        aOa.bVU = m.H(getIntent());
        aOa.jic = this.bPS;
        aOa.jih = this.bPg;
        aOa.aOc().aOb();
    }

    protected int aPq() {
        if (!d.BY(this.ssid)) {
            return 1;
        }
        d.a(this.ssid, 2, getIntent());
        return 2;
    }
}
