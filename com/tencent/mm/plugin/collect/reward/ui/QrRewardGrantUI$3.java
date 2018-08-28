package com.tencent.mm.plugin.collect.reward.ui;

import android.view.View;
import android.view.View.OnClickListener;

class QrRewardGrantUI$3 implements OnClickListener {
    final /* synthetic */ QrRewardGrantUI hVG;

    QrRewardGrantUI$3(QrRewardGrantUI qrRewardGrantUI) {
        this.hVG = qrRewardGrantUI;
    }

    public final void onClick(View view) {
        QrRewardGrantUI.c(this.hVG).setChecked(!QrRewardGrantUI.c(this.hVG).isChecked());
    }
}
