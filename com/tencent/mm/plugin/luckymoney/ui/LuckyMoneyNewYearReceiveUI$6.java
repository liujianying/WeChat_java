package com.tencent.mm.plugin.luckymoney.ui;

import com.tencent.mm.plugin.luckymoney.b.ag;
import com.tencent.mm.plugin.wallet_core.id_verify.util.a.a;
import com.tencent.mm.sdk.platformtools.x;

class LuckyMoneyNewYearReceiveUI$6 implements a {
    final /* synthetic */ LuckyMoneyNewYearReceiveUI kWg;
    final /* synthetic */ ag kWk;

    LuckyMoneyNewYearReceiveUI$6(LuckyMoneyNewYearReceiveUI luckyMoneyNewYearReceiveUI, ag agVar) {
        this.kWg = luckyMoneyNewYearReceiveUI;
        this.kWk = agVar;
    }

    public final boolean a(int i, int i2, String str, boolean z) {
        x.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "showDisclaimerDialog resultCode=" + i + ";errCode=" + i2 + ";errMsg=" + str + ";hadAgree = " + z);
        if (i == 1) {
            this.kWg.finish();
        } else if (i == 2) {
            LuckyMoneyNewYearReceiveUI.a(this.kWg, this.kWk.msgType, this.kWk.bxk, this.kWk.kLZ, this.kWk.ceR, this.kWk.kRC);
        } else if (i == 0 && z) {
            LuckyMoneyNewYearReceiveUI.a(this.kWg, this.kWk.msgType, this.kWk.bxk, this.kWk.kLZ, this.kWk.ceR, this.kWk.kRC);
        }
        return true;
    }
}
