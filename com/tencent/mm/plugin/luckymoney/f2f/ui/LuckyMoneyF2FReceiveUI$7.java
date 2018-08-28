package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.wallet_core.c.a;

class LuckyMoneyF2FReceiveUI$7 implements a {
    final /* synthetic */ LuckyMoneyF2FReceiveUI kON;

    LuckyMoneyF2FReceiveUI$7(LuckyMoneyF2FReceiveUI luckyMoneyF2FReceiveUI) {
        this.kON = luckyMoneyF2FReceiveUI;
    }

    public final Intent n(int i, Bundle bundle) {
        this.kON.finish();
        return null;
    }
}
