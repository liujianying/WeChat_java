package com.tencent.mm.plugin.account.ui;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.ag;

class RegByMobileRegAIOUI$13 extends ag {
    final /* synthetic */ RegByMobileRegAIOUI eVb;

    RegByMobileRegAIOUI$13(RegByMobileRegAIOUI regByMobileRegAIOUI) {
        this.eVb = regByMobileRegAIOUI;
    }

    public final void handleMessage(Message message) {
        if ((RegByMobileRegAIOUI.r(this.eVb) == null || RegByMobileRegAIOUI.r(this.eVb).isShowing()) && !RegByMobileRegAIOUI.s(this.eVb)) {
            RegByMobileRegAIOUI.a(this.eVb, RegByMobileRegAIOUI.t(this.eVb) + 2);
            RegByMobileRegAIOUI.u(this.eVb).setProgress(RegByMobileRegAIOUI.t(this.eVb));
            if (RegByMobileRegAIOUI.t(this.eVb) < RegByMobileRegAIOUI.u(this.eVb).getMax()) {
                sendEmptyMessageDelayed(0, 10);
                return;
            }
            RegByMobileRegAIOUI.u(this.eVb).setIndeterminate(true);
            if (!RegByMobileRegAIOUI.s(this.eVb)) {
                if (RegByMobileRegAIOUI.r(this.eVb) != null) {
                    RegByMobileRegAIOUI.r(this.eVb).dismiss();
                }
                RegByMobileRegAIOUI.v(this.eVb);
            }
        }
    }
}
