package com.tencent.mm.plugin.freewifi.ui;

import android.net.NetworkInfo.State;
import com.tencent.mm.R;
import com.tencent.mm.plugin.freewifi.d.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.sdk.platformtools.x;

@Deprecated
public class FreewifiActivateWeChatNoAuthStateUI extends FreeWifiActivateNoAuthStateUI {
    private int bMF;
    private String joq;
    private String jor;

    protected final String aPr() {
        return getString(R.l.free_wifi_title);
    }

    public final void a(State state) {
        x.i("MicroMsg.FreeWifi.FreewifiActivateWeChatNoAuthStateUI", "now network state : %s", new Object[]{state.toString()});
        if (state == State.CONNECTED && d.BY(this.ssid) && this.jma) {
            aPu();
            this.jma = false;
            this.joq = d.aOx();
            this.jor = d.aOz();
            this.bMF = d.aOy();
            x.i("MicroMsg.FreeWifi.FreewifiActivateWeChatNoAuthStateUI", "now has connect the ap, check from server rssi is :  %d, mac : %s, ssid is : %s", new Object[]{Integer.valueOf(this.bMF), this.joq, this.jor});
            new a(this.jkH, this.joq, this.jor, this.bMF, this.bxk, m.E(getIntent())).b(new 1(this));
        }
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected final int aPq() {
        j.aOJ();
        int BX = d.BX(this.ssid);
        x.i("MicroMsg.FreeWifi.FreewifiActivateWeChatNoAuthStateUI", "get connect state = %d", new Object[]{Integer.valueOf(BX)});
        if (BX == 0) {
            return -2014;
        }
        return BX;
    }
}
