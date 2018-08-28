package com.tencent.mm.plugin.luckymoney.ui;

import android.graphics.Bitmap;
import com.tencent.mm.plugin.luckymoney.b.o;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

class LuckyMoneyNewYearReceiveUI$5 implements Runnable {
    final /* synthetic */ LuckyMoneyNewYearReceiveUI kWg;

    LuckyMoneyNewYearReceiveUI$5(LuckyMoneyNewYearReceiveUI luckyMoneyNewYearReceiveUI) {
        this.kWg = luckyMoneyNewYearReceiveUI;
    }

    public final void run() {
        if (new File(LuckyMoneyNewYearReceiveUI.h(this.kWg)).exists()) {
            final Bitmap aE = o.aE(LuckyMoneyNewYearReceiveUI.h(this.kWg), true);
            ah.A(new Runnable() {
                public final void run() {
                    LuckyMoneyNewYearReceiveUI.i(LuckyMoneyNewYearReceiveUI$5.this.kWg).setImageBitmap(aE);
                }

                public final String toString() {
                    return super.toString() + "|renderView";
                }
            });
            return;
        }
        x.e("MicroMsg.LuckyMoneyNewYearReceiveUI", "ljd:updateImageView() imagePath:" + LuckyMoneyNewYearReceiveUI.h(this.kWg) + " is not exist!");
    }
}
