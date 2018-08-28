package com.tencent.mm.plugin.aa.ui;

import android.content.Intent;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.aa.ui.a.a;
import com.tencent.mm.plugin.report.service.h;

class PaylistAAUI$11 implements a {
    final /* synthetic */ PaylistAAUI eEl;

    PaylistAAUI$11(PaylistAAUI paylistAAUI) {
        this.eEl = paylistAAUI;
    }

    public final void We() {
        Intent intent = new Intent();
        intent.putExtra("key_scene_balance_manager", 0);
        d.b(this.eEl, "wallet", ".balance.ui.WalletBalanceManagerUI", intent);
        h.mEJ.h(13721, new Object[]{Integer.valueOf(4), Integer.valueOf(4)});
    }
}
