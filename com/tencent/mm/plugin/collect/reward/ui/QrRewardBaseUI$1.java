package com.tencent.mm.plugin.collect.reward.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class QrRewardBaseUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ QrRewardBaseUI hVk;

    QrRewardBaseUI$1(QrRewardBaseUI qrRewardBaseUI) {
        this.hVk = qrRewardBaseUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.hVk.YC();
        this.hVk.Wq();
        this.hVk.finish();
        return false;
    }
}
