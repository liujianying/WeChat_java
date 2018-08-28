package com.tencent.mm.plugin.luckymoney.appbrand.ui;

import android.content.Intent;
import com.tencent.mm.plugin.luckymoney.appbrand.ui.d.a;

class WxaLuckyMoneyBaseUI$1 implements Runnable {
    final /* synthetic */ Class fev;
    final /* synthetic */ Intent kLn;
    final /* synthetic */ a kLo;
    final /* synthetic */ WxaLuckyMoneyBaseUI kLp;

    WxaLuckyMoneyBaseUI$1(WxaLuckyMoneyBaseUI wxaLuckyMoneyBaseUI, Class cls, Intent intent, a aVar) {
        this.kLp = wxaLuckyMoneyBaseUI;
        this.fev = cls;
        this.kLn = intent;
        this.kLo = aVar;
    }

    public final void run() {
        this.kLp.a(this.fev, this.kLn, this.kLo);
    }
}
