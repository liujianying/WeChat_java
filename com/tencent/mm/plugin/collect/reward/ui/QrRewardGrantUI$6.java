package com.tencent.mm.plugin.collect.reward.ui;

import android.widget.Toast;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.collect.reward.a.a.a;
import com.tencent.mm.plugin.collect.reward.a.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class QrRewardGrantUI$6 implements a {
    final /* synthetic */ QrRewardGrantUI hVG;
    final /* synthetic */ e hVH;

    QrRewardGrantUI$6(QrRewardGrantUI qrRewardGrantUI, e eVar) {
        this.hVG = qrRewardGrantUI;
        this.hVH = eVar;
    }

    public final void i(l lVar) {
        x.e("MicroMsg.QrRewardGrantUI", "place order error: %s, %s", new Object[]{Integer.valueOf(this.hVH.hVb.hUm), this.hVH.hVb.hUn});
        if (!bi.oW(this.hVH.hVb.hUn)) {
            Toast.makeText(this.hVG, this.hVH.hVb.hUn, 0).show();
        }
    }
}
