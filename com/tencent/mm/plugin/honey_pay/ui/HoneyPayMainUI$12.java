package com.tencent.mm.plugin.honey_pay.ui;

import android.os.Bundle;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.honey_pay.a.a;
import com.tencent.mm.plugin.honey_pay.model.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.h$a;

class HoneyPayMainUI$12 implements h$a {
    final /* synthetic */ HoneyPayMainUI klC;
    final /* synthetic */ a klH;

    HoneyPayMainUI$12(HoneyPayMainUI honeyPayMainUI, a aVar) {
        this.klC = honeyPayMainUI;
        this.klH = aVar;
    }

    public final void g(int i, int i2, String str, l lVar) {
        if (this.klH.kjA.rrT != null) {
            x.i(this.klC.TAG, "do realname guide");
            Bundle bundle = new Bundle();
            bundle.putString("realname_verify_process_jump_activity", ".ui.HoneyPayMainUI");
            c.a(this.klC, bundle, this.klH.kjA.rrT);
            return;
        }
        HoneyPayMainUI.b(this.klC, this.klH.kjA.rrU);
    }
}
