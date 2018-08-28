package com.tencent.mm.plugin.luckymoney.ui;

import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.plugin.luckymoney.b.k.a;

class LuckyMoneyNewYearReceiveUI$4 implements a {
    final /* synthetic */ LuckyMoneyNewYearReceiveUI kWg;

    LuckyMoneyNewYearReceiveUI$4(LuckyMoneyNewYearReceiveUI luckyMoneyNewYearReceiveUI) {
        this.kWg = luckyMoneyNewYearReceiveUI;
    }

    public final void a(keep_SceneResult keep_sceneresult, String str, boolean z) {
        LuckyMoneyNewYearReceiveUI.g(this.kWg).post(new 1(this, z, keep_sceneresult));
    }
}
