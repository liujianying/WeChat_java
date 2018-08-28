package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.mm.R;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiPcUI.2;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.ui.base.h;

class FreeWifiPcUI$2$1 implements a {
    final /* synthetic */ 2 jnT;

    FreeWifiPcUI$2$1(2 2) {
        this.jnT = 2;
    }

    public final boolean vD() {
        FreeWifiPcUI.a(this.jnT.jnS, h.a(this.jnT.jnS.mController.tml, this.jnT.jnS.getString(R.l.connect_state_connecting_ing), true, new 1(this)));
        return true;
    }
}
