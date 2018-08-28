package com.tencent.mm.plugin.luckymoney.f2f.ui;

import com.tencent.mm.plugin.luckymoney.particles.a.a;
import com.tencent.mm.plugin.luckymoney.particles.b;
import com.tencent.mm.plugin.wxpay.a$e;
import java.util.Random;

class LuckyMoneyF2FQRCodeUI$10 implements b {
    final /* synthetic */ LuckyMoneyF2FQRCodeUI kOv;

    LuckyMoneyF2FQRCodeUI$10(LuckyMoneyF2FQRCodeUI luckyMoneyF2FQRCodeUI) {
        this.kOv = luckyMoneyF2FQRCodeUI;
    }

    public final com.tencent.mm.plugin.luckymoney.particles.a.b b(Random random) {
        int nextInt = random.nextInt(100);
        if (nextInt < 16) {
            if (LuckyMoneyF2FQRCodeUI.i(this.kOv) == null) {
                LuckyMoneyF2FQRCodeUI.a(this.kOv, LuckyMoneyF2FQRCodeUI.a(this.kOv, a$e.lucky_money_f2f_firework_ribbon_1, 36));
            }
            return new a(LuckyMoneyF2FQRCodeUI.i(this.kOv));
        } else if (nextInt < 33) {
            if (LuckyMoneyF2FQRCodeUI.j(this.kOv) == null) {
                LuckyMoneyF2FQRCodeUI.b(this.kOv, LuckyMoneyF2FQRCodeUI.a(this.kOv, a$e.lucky_money_f2f_firework_ribbon_2, 36));
            }
            return new a(LuckyMoneyF2FQRCodeUI.j(this.kOv));
        } else if (nextInt < 50) {
            if (LuckyMoneyF2FQRCodeUI.k(this.kOv) == null) {
                LuckyMoneyF2FQRCodeUI.c(this.kOv, LuckyMoneyF2FQRCodeUI.a(this.kOv, a$e.lucky_money_f2f_firework_ribbon_3, 36));
            }
            return new a(LuckyMoneyF2FQRCodeUI.k(this.kOv));
        } else if (nextInt < 70) {
            if (LuckyMoneyF2FQRCodeUI.l(this.kOv) == null) {
                LuckyMoneyF2FQRCodeUI.d(this.kOv, LuckyMoneyF2FQRCodeUI.a(this.kOv, a$e.lucky_money_f2f_firework_leaf_top_1, 36));
            }
            return new a(LuckyMoneyF2FQRCodeUI.l(this.kOv));
        } else if (nextInt < 90) {
            if (LuckyMoneyF2FQRCodeUI.m(this.kOv) == null) {
                LuckyMoneyF2FQRCodeUI.e(this.kOv, LuckyMoneyF2FQRCodeUI.a(this.kOv, a$e.lucky_money_f2f_firework_leaf_top_2, 36));
            }
            return new a(LuckyMoneyF2FQRCodeUI.m(this.kOv));
        } else {
            if (LuckyMoneyF2FQRCodeUI.n(this.kOv) == null) {
                LuckyMoneyF2FQRCodeUI.f(this.kOv, LuckyMoneyF2FQRCodeUI.a(this.kOv, a$e.lucky_money_f2f_firework_leaf_top_3, 36));
            }
            return new a(LuckyMoneyF2FQRCodeUI.n(this.kOv));
        }
    }
}
