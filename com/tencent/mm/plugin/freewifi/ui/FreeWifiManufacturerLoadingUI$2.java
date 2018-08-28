package com.tencent.mm.plugin.freewifi.ui;

import android.view.View;
import android.view.View.OnClickListener;

class FreeWifiManufacturerLoadingUI$2 implements OnClickListener {
    final /* synthetic */ FreeWifiManufacturerLoadingUI jnE;

    FreeWifiManufacturerLoadingUI$2(FreeWifiManufacturerLoadingUI freeWifiManufacturerLoadingUI) {
        this.jnE = freeWifiManufacturerLoadingUI;
    }

    public final void onClick(View view) {
        this.jnE.jnD.postDelayed(new 1(this), 0);
        this.jnE.aPF();
    }
}
