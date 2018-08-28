package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Intent;
import com.tencent.mm.pluginsdk.ui.applet.q.a;

class SelectLuckyMoneyContactUI$1 implements a {
    final /* synthetic */ Intent heh;
    final /* synthetic */ SelectLuckyMoneyContactUI kXW;

    SelectLuckyMoneyContactUI$1(SelectLuckyMoneyContactUI selectLuckyMoneyContactUI, Intent intent) {
        this.kXW = selectLuckyMoneyContactUI;
        this.heh = intent;
    }

    public final void a(boolean z, String str, int i) {
        if (z) {
            this.kXW.setResult(-1, this.heh);
            this.kXW.finish();
        }
    }
}
