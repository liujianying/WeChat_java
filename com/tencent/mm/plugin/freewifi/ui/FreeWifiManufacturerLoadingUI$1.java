package com.tencent.mm.plugin.freewifi.ui;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.ag;

class FreeWifiManufacturerLoadingUI$1 extends ag {
    int i = 0;
    final /* synthetic */ FreeWifiManufacturerLoadingUI jnE;

    FreeWifiManufacturerLoadingUI$1(FreeWifiManufacturerLoadingUI freeWifiManufacturerLoadingUI) {
        this.jnE = freeWifiManufacturerLoadingUI;
    }

    public final void handleMessage(Message message) {
        if (message.what == 1) {
            if (this.i >= FreeWifiManufacturerLoadingUI.a(this.jnE).length) {
                this.i = 0;
            }
            FreeWifiManufacturerLoadingUI.b(this.jnE).setImageResource(FreeWifiManufacturerLoadingUI.a(this.jnE)[this.i]);
            this.i++;
        } else if (message.what == 2) {
            FreeWifiManufacturerLoadingUI.b(this.jnE).setImageResource(FreeWifiManufacturerLoadingUI.a(this.jnE)[FreeWifiManufacturerLoadingUI.a(this.jnE).length - 1]);
        } else if (message.what == 3 && message.obj != null && (message.obj instanceof String)) {
            FreeWifiManufacturerLoadingUI.c(this.jnE).setText(message.obj.toString());
        }
        super.handleMessage(message);
    }
}
