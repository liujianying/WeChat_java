package com.tencent.mm.plugin.luckymoney.f2f.ui;

import com.tencent.mm.plugin.luckymoney.f2f.ui.ShuffleView.b;

class LuckyMoneyF2FQRCodeUI$5 implements b {
    final /* synthetic */ LuckyMoneyF2FQRCodeUI kOv;

    LuckyMoneyF2FQRCodeUI$5(LuckyMoneyF2FQRCodeUI luckyMoneyF2FQRCodeUI) {
        this.kOv = luckyMoneyF2FQRCodeUI;
    }

    public final void cM(int i, int i2) {
        int[] I;
        if (i2 == 8) {
            LuckyMoneyF2FQRCodeUI.F(this.kOv).eR("music" + (i + 1) + ".m4a");
            I = LuckyMoneyF2FQRCodeUI.I(this.kOv);
            I[4] = I[4] + 1;
            return;
        }
        LuckyMoneyF2FQRCodeUI.F(this.kOv).eR("touch_card.m4a");
        I = LuckyMoneyF2FQRCodeUI.I(this.kOv);
        I[2] = I[2] + 1;
    }

    public final void rZ(int i) {
        LuckyMoneyF2FQRCodeUI.J(this.kOv);
        int[] I;
        if (i != 8) {
            LuckyMoneyF2FQRCodeUI.F(this.kOv).eR("select_card.m4a");
            I = LuckyMoneyF2FQRCodeUI.I(this.kOv);
            I[3] = I[3] + 1;
            return;
        }
        I = LuckyMoneyF2FQRCodeUI.I(this.kOv);
        I[5] = I[5] + 1;
    }

    public final void cN(int i, int i2) {
        if (i2 == 8) {
            LuckyMoneyF2FQRCodeUI.F(this.kOv).eR("music" + (i + 1) + ".m4a");
        } else {
            LuckyMoneyF2FQRCodeUI.F(this.kOv).eR("select_card.m4a");
        }
    }
}
