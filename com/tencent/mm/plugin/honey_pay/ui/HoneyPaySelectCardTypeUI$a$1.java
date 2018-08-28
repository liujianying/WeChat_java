package com.tencent.mm.plugin.honey_pay.ui;

import android.content.Context;
import com.tencent.mm.plugin.wallet_core.ui.m.a;
import com.tencent.mm.protocal.c.alq;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.ui.e;

class HoneyPaySelectCardTypeUI$a$1 implements a {
    final /* synthetic */ alq kmo;
    final /* synthetic */ HoneyPaySelectCardTypeUI.a kmp;
    final /* synthetic */ Context val$context;

    HoneyPaySelectCardTypeUI$a$1(HoneyPaySelectCardTypeUI.a aVar, alq alq, Context context) {
        this.kmp = aVar;
        this.kmo = alq;
        this.val$context = context;
    }

    public final void aCb() {
        x.i("MicroMsg.HoneyPaySelectCardTypeUI", "click oper text");
        if (!bi.oW(this.kmo.rIy.url)) {
            e.l(this.val$context, this.kmo.rIy.url, false);
        }
    }
}
