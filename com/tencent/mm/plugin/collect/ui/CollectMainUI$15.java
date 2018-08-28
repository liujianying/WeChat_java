package com.tencent.mm.plugin.collect.ui;

import com.tencent.mm.plugin.wallet_core.ui.m.a;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.ui.base.h;

class CollectMainUI$15 implements a {
    final /* synthetic */ CollectMainUI hYN;

    CollectMainUI$15(CollectMainUI collectMainUI) {
        this.hYN = collectMainUI;
    }

    public final void aCb() {
        if (CollectMainUI.b(this.hYN) == 1) {
            CollectMainUI.c(this.hYN);
            h.a(this.hYN.mController.tml, this.hYN.getString(a$i.collect_material_guide_click_text), "", this.hYN.getString(a$i.collect_material_guide_apply_text), this.hYN.getString(a$i.app_cancel), true, new 1(this), new 2(this));
        } else {
            CollectMainUI.e(this.hYN);
        }
        com.tencent.mm.plugin.report.service.h.mEJ.h(13944, new Object[]{Integer.valueOf(5)});
    }
}
