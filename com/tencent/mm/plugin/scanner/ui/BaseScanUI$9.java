package com.tencent.mm.plugin.scanner.ui;

import android.os.Message;
import com.tencent.mm.plugin.scanner.util.h;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

class BaseScanUI$9 extends ag {
    final /* synthetic */ BaseScanUI mHS;

    BaseScanUI$9(BaseScanUI baseScanUI) {
        this.mHS = baseScanUI;
    }

    public final void handleMessage(Message message) {
        if (BaseScanUI.f(this.mHS) != null && BaseScanUI.m(this.mHS) && !BaseScanUI.G(this.mHS) && message.what == 0) {
            BaseScanUI.a(this.mHS, System.currentTimeMillis());
            h f = BaseScanUI.f(this.mHS);
            BaseScanUI baseScanUI = this.mHS;
            if (f.ddt != null && f.iOl) {
                try {
                    f.btf();
                    f.ddt.autoFocus(baseScanUI);
                } catch (RuntimeException e) {
                    x.w("MicroMsg.scanner.ScanCamera", "autoFocus() " + e.getMessage());
                }
            }
        }
    }
}
