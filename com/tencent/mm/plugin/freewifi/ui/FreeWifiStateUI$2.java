package com.tencent.mm.plugin.freewifi.ui;

import android.net.NetworkInfo.State;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.al.a;

class FreeWifiStateUI$2 implements a {
    final /* synthetic */ FreeWifiStateUI jnZ;

    FreeWifiStateUI$2(FreeWifiStateUI freeWifiStateUI) {
        this.jnZ = freeWifiStateUI;
    }

    public final boolean vD() {
        if (!d.BY(this.jnZ.ssid)) {
            return true;
        }
        this.jnZ.a(State.CONNECTED);
        FreeWifiStateUI.b(this.jnZ).SO();
        return false;
    }
}
