package com.tencent.mm.plugin.luckymoney.ui;

import android.support.v7.app.ActionBarActivity;
import com.tencent.mm.g.a.hg;
import com.tencent.mm.plugin.luckymoney.b.f;
import com.tencent.mm.plugin.luckymoney.b.o;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.sdk.platformtools.x;

class LuckyMoneyDetailUI$8 implements Runnable {
    final /* synthetic */ hg kUx;
    final /* synthetic */ f kUy;
    final /* synthetic */ LuckyMoneyDetailUI kVo;

    LuckyMoneyDetailUI$8(LuckyMoneyDetailUI luckyMoneyDetailUI, hg hgVar, f fVar) {
        this.kVo = luckyMoneyDetailUI;
        this.kUx = hgVar;
        this.kUy = fVar;
    }

    public final void run() {
        if (this.kUx.bQy.bQA) {
            x.i("MicroMsg.LuckyMoneyDetailUI", "Get res Ok, path=" + this.kUx.bQy.bQB);
            ActionBarActivity actionBarActivity = this.kVo.mController.tml;
            o.e(LuckyMoneyDetailUI.v(this.kVo), this.kUx.bQy.bQB, e.lucky_money_busi_default_avatar);
            return;
        }
        x.i("MicroMsg.LuckyMoneyDetailUI", "Get res fail & load from url.");
        o.a(LuckyMoneyDetailUI.v(this.kVo), this.kUy.kPM, this.kUy.kQg);
    }
}
