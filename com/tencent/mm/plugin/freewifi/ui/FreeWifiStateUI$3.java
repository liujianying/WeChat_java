package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;

class FreeWifiStateUI$3 implements a {
    final /* synthetic */ FreeWifiStateUI jnZ;
    private int joa = -999999999;

    FreeWifiStateUI$3(FreeWifiStateUI freeWifiStateUI) {
        this.jnZ = freeWifiStateUI;
    }

    public final void a(String str, l lVar) {
        FreeWifiStateUI.a(this.jnZ, this.jnZ.aPq());
        if (this.joa != FreeWifiStateUI.a(this.jnZ)) {
            this.joa = FreeWifiStateUI.a(this.jnZ);
            this.jnZ.ph(FreeWifiStateUI.a(this.jnZ));
        }
    }
}
