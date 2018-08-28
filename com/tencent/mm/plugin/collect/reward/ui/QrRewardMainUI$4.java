package com.tencent.mm.plugin.collect.reward.ui;

import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

class QrRewardMainUI$4 implements c {
    final /* synthetic */ QrRewardMainUI hWf;

    QrRewardMainUI$4(QrRewardMainUI qrRewardMainUI) {
        this.hWf = qrRewardMainUI;
    }

    public final void a(l lVar) {
        lVar.a(1, this.hWf.getString(i.qr_reward_menu_avatar), QrRewardMainUI.k(this.hWf) ? this.hWf.getString(i.qr_reward_select_menu) : "");
        lVar.a(2, this.hWf.getString(i.qr_reward_menu_wording), !QrRewardMainUI.k(this.hWf) ? this.hWf.getString(i.qr_reward_select_menu) : "");
    }
}
