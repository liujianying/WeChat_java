package com.tencent.mm.plugin.scanner.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.scanner.b;
import com.tencent.mm.sdk.platformtools.x;

class p$2 implements OnClickListener {
    final /* synthetic */ p mLr;

    p$2(p pVar) {
        this.mLr = pVar;
    }

    public final void onClick(View view) {
        if (this.mLr.mKp == null) {
            x.e("MicroMsg.scanner.ScanModeQRCode", "toMyQRCodeOnclickListener scanUICallback == null");
            return;
        }
        h.mEJ.h(11264, new Object[]{Integer.valueOf(3)});
        b.ezn.bf(this.mLr.mKp.getContext());
    }
}
