package com.tencent.mm.plugin.scanner.ui;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

class BaseScanUI$2 extends ag {
    final /* synthetic */ BaseScanUI mHS;

    BaseScanUI$2(BaseScanUI baseScanUI) {
        this.mHS = baseScanUI;
    }

    public final void handleMessage(Message message) {
        if (message != null && message.what == 1 && BaseScanUI.k(this.mHS) != null && BaseScanUI.l(this.mHS) != null) {
            if (BaseScanUI.a(this.mHS) && !BaseScanUI.b(this.mHS)) {
                return;
            }
            if (BaseScanUI.h(this.mHS) == null || BaseScanUI.h(this.mHS).bsm() <= 0) {
                x.w("MicroMsg.scanner.BaseScanUI", "startAnimHandler scanMode == null");
                this.mHS.bsr();
                return;
            }
            BaseScanUI.k(this.mHS).setVisibility(0);
            BaseScanUI.l(this.mHS).setRepeatCount(-1);
            BaseScanUI.l(this.mHS).setDuration(2600);
            BaseScanUI.k(this.mHS).startAnimation(BaseScanUI.l(this.mHS));
        }
    }
}
