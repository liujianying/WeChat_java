package com.tencent.mm.plugin.collect.reward.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

class QrRewardMainUI$11 implements OnClickListener {
    final /* synthetic */ QrRewardMainUI hWf;

    QrRewardMainUI$11(QrRewardMainUI qrRewardMainUI) {
        this.hWf = qrRewardMainUI;
    }

    public final void onClick(View view) {
        x.d("MicroMsg.QrRewardMainUI", "click avatar");
        this.hWf.YC();
        QrRewardMainUI.a(this.hWf);
    }
}
