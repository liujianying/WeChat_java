package com.tencent.mm.plugin.scanner.ui;

import com.tencent.mm.R;
import com.tencent.mm.plugin.scanner.ui.BaseScanUI.10;
import com.tencent.mm.plugin.scanner.util.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

class BaseScanUI$10$1 implements c {
    final /* synthetic */ 10 mHX;

    BaseScanUI$10$1(10 10) {
        this.mHX = 10;
    }

    public final void a(l lVar) {
        lVar.eR(0, R.l.add_qrcode_as_shortcut);
        if (this.mHX.mHW != null) {
            lVar.eR(1, R.l.self_qrcode_gallery);
        }
        if (i.btj()) {
            lVar.eR(2, R.l.scan_history_ttile);
            x.i("MicroMsg.scanner.BaseScanUI", "show history list");
        }
    }
}
