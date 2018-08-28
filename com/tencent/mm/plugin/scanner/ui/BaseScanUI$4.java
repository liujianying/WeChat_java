package com.tencent.mm.plugin.scanner.ui;

import com.tencent.mm.sdk.platformtools.x;

class BaseScanUI$4 implements Runnable {
    final /* synthetic */ BaseScanUI mHS;

    BaseScanUI$4(BaseScanUI baseScanUI) {
        this.mHS = baseScanUI;
    }

    public final void run() {
        if (BaseScanUI.f(this.mHS) != null) {
            synchronized (BaseScanUI.n(this.mHS)) {
                if (BaseScanUI.r(this.mHS) && BaseScanUI.f(this.mHS) != null) {
                    x.i("MicroMsg.scanner.BaseScanUI", "closeCamera");
                    BaseScanUI.f(this.mHS).release();
                    BaseScanUI.s(this.mHS);
                    BaseScanUI.t(this.mHS);
                    x.i("MicroMsg.scanner.BaseScanUI", "scanCamera.release() done");
                }
            }
        }
    }
}
