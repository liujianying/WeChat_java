package com.tencent.mm.plugin.honey_pay.ui;

import android.os.Bundle;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.honey_pay.a.e;
import com.tencent.mm.plugin.honey_pay.model.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.h.a;

class HoneyPayReceiveCardUI$7 implements a {
    final /* synthetic */ HoneyPayReceiveCardUI kmc;
    final /* synthetic */ e kmd;

    HoneyPayReceiveCardUI$7(HoneyPayReceiveCardUI honeyPayReceiveCardUI, e eVar) {
        this.kmc = honeyPayReceiveCardUI;
        this.kmd = eVar;
    }

    public final void g(int i, int i2, String str, l lVar) {
        if (this.kmd.kjE.rrT != null) {
            x.i(this.kmc.TAG, "do real name");
            Bundle bundle = new Bundle();
            bundle.putString("realname_verify_process_jump_activity", ".ui.HoneyPayReceiveCardUI");
            c.a(this.kmc, bundle, this.kmd.kjE.rrT);
        }
        h.mEJ.e(875, 5, 1);
    }
}
