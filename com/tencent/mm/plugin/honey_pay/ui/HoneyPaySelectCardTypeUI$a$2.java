package com.tencent.mm.plugin.honey_pay.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.honey_pay.ui.HoneyPaySelectCardTypeUI.a;
import com.tencent.mm.protocal.c.alq;
import com.tencent.mm.sdk.platformtools.x;

class HoneyPaySelectCardTypeUI$a$2 implements OnClickListener {
    final /* synthetic */ alq kmo;
    final /* synthetic */ a kmp;

    HoneyPaySelectCardTypeUI$a$2(a aVar, alq alq) {
        this.kmp = aVar;
        this.kmo = alq;
    }

    public final void onClick(View view) {
        x.i("MicroMsg.HoneyPaySelectCardTypeUI", "card type clicked");
        if (HoneyPaySelectCardTypeUI.a(this.kmp.kmj) != null) {
            HoneyPaySelectCardTypeUI.a(this.kmp.kmj, HoneyPaySelectCardTypeUI.a(this.kmp.kmj));
            return;
        }
        HoneyPaySelectCardTypeUI.a(this.kmp.kmj, this.kmo.huV);
        HoneyPaySelectCardTypeUI.b(this.kmp.kmj);
    }
}
