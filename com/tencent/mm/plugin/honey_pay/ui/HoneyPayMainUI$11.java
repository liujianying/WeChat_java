package com.tencent.mm.plugin.honey_pay.ui;

import android.os.Bundle;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.honey_pay.model.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.h.a;

class HoneyPayMainUI$11 implements a {
    final /* synthetic */ HoneyPayMainUI klC;
    final /* synthetic */ com.tencent.mm.plugin.honey_pay.a.a klH;

    HoneyPayMainUI$11(HoneyPayMainUI honeyPayMainUI, com.tencent.mm.plugin.honey_pay.a.a aVar) {
        this.klC = honeyPayMainUI;
        this.klH = aVar;
    }

    public final void g(int i, int i2, String str, l lVar) {
        if (this.klH.kjA.rrT != null) {
            x.i(this.klC.TAG, "do realname guide");
            Bundle bundle = new Bundle();
            bundle.putString("realname_verify_process_jump_activity", ".ui.HoneyPayMainUI");
            c.a(this.klC, bundle, this.klH.kjA.rrT);
        }
    }
}
