package com.tencent.mm.plugin.collect.reward.ui;

import android.widget.Toast;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.collect.reward.a.a.a;
import com.tencent.mm.plugin.collect.reward.a.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class QrRewardMainUI$15 implements a {
    final /* synthetic */ QrRewardMainUI hWf;
    final /* synthetic */ b hWk;

    QrRewardMainUI$15(QrRewardMainUI qrRewardMainUI, b bVar) {
        this.hWf = qrRewardMainUI;
        this.hWk = bVar;
    }

    public final void i(l lVar) {
        x.e("MicroMsg.QrRewardMainUI", "get code error: %s, %s", new Object[]{Integer.valueOf(this.hWk.hUX.hUm), this.hWk.hUX.hUn});
        if (!bi.oW(this.hWk.hUX.hUn)) {
            Toast.makeText(this.hWf, this.hWk.hUX.hUn, 0).show();
        }
        if (!this.hWk.hUY) {
            QrRewardMainUI.a(this.hWf, false);
        }
    }
}
