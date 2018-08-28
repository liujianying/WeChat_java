package com.tencent.mm.plugin.freewifi.ui;

import android.net.NetworkInfo.State;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.al.a;

class FreeWifiActivateStateUI$2 implements a {
    final /* synthetic */ FreeWifiActivateStateUI jmf;

    FreeWifiActivateStateUI$2(FreeWifiActivateStateUI freeWifiActivateStateUI) {
        this.jmf = freeWifiActivateStateUI;
    }

    public final boolean vD() {
        if (!d.BY(this.jmf.ssid)) {
            return true;
        }
        this.jmf.a(State.CONNECTED);
        FreeWifiActivateStateUI.b(this.jmf).SO();
        return false;
    }
}
