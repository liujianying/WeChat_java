package com.tencent.mm.plugin.freewifi.ui;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.ag;

class FreeWifiNetCheckUI$1 extends ag {
    int i = 0;
    final /* synthetic */ FreeWifiNetCheckUI jnK;

    FreeWifiNetCheckUI$1(FreeWifiNetCheckUI freeWifiNetCheckUI) {
        this.jnK = freeWifiNetCheckUI;
    }

    public final void handleMessage(Message message) {
        if (message.what == 1) {
            if (this.i >= FreeWifiNetCheckUI.a(this.jnK).length) {
                this.i = 0;
            }
            this.jnK.jnv.setImageResource(FreeWifiNetCheckUI.a(this.jnK)[this.i]);
            this.i++;
        } else if (message.what == 2) {
            this.jnK.jnv.setImageResource(FreeWifiNetCheckUI.a(this.jnK)[FreeWifiNetCheckUI.a(this.jnK).length - 1]);
        }
        super.handleMessage(message);
    }
}
