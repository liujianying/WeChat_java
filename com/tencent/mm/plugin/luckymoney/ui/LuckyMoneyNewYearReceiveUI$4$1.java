package com.tencent.mm.plugin.luckymoney.ui;

import android.text.TextUtils;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNewYearReceiveUI.4;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;

class LuckyMoneyNewYearReceiveUI$4$1 implements Runnable {
    final /* synthetic */ keep_SceneResult dPf;
    final /* synthetic */ boolean kWh;
    final /* synthetic */ 4 kWi;

    LuckyMoneyNewYearReceiveUI$4$1(4 4, boolean z, keep_SceneResult keep_sceneresult) {
        this.kWi = 4;
        this.kWh = z;
        this.dPf = keep_sceneresult;
    }

    public final void run() {
        if (this.kWh) {
            x.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "the download image data is success!");
            if (!TextUtils.isEmpty(this.dPf.field_fileId) && this.dPf.field_fileId.equals(LuckyMoneyNewYearReceiveUI.e(this.kWi.kWg))) {
                LuckyMoneyNewYearReceiveUI.f(this.kWi.kWg);
                return;
            }
            return;
        }
        x.e("MicroMsg.LuckyMoneyNewYearReceiveUI", "download image fail!");
        h.bA(this.kWi.kWg, this.kWi.kWg.getString(i.lucky_money_download_image_fail_tips));
    }
}
