package com.tencent.mm.plugin.luckymoney.ui;

import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.plugin.luckymoney.b.k.a;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNewYearSendUI.1;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;

class LuckyMoneyNewYearSendUI$1$1 implements a {
    final /* synthetic */ 1 kWy;

    LuckyMoneyNewYearSendUI$1$1(1 1) {
        this.kWy = 1;
    }

    public final void a(keep_SceneResult keep_sceneresult, String str, boolean z) {
        if (z) {
            x.i("MicroMsg.LuckyMoneyNewYearSendUI", "upload image success, to send HB");
            LuckyMoneyNewYearSendUI.a(this.kWy.kWx, keep_sceneresult.field_fileId);
            LuckyMoneyNewYearSendUI.b(this.kWy.kWx, keep_sceneresult.field_aesKey);
            LuckyMoneyNewYearSendUI.a(this.kWy.kWx, keep_sceneresult.field_fileLength);
            LuckyMoneyNewYearSendUI.j(this.kWy.kWx).post(new 1(this));
            return;
        }
        LuckyMoneyNewYearSendUI.j(this.kWy.kWx).post(new Runnable() {
            public final void run() {
                x.i("MicroMsg.LuckyMoneyNewYearSendUI", "upload image fail!");
                if (LuckyMoneyNewYearSendUI.k(LuckyMoneyNewYearSendUI$1$1.this.kWy.kWx) != null && LuckyMoneyNewYearSendUI.k(LuckyMoneyNewYearSendUI$1$1.this.kWy.kWx).isShowing()) {
                    LuckyMoneyNewYearSendUI.k(LuckyMoneyNewYearSendUI$1$1.this.kWy.kWx).hide();
                }
                h.bA(LuckyMoneyNewYearSendUI$1$1.this.kWy.kWx, LuckyMoneyNewYearSendUI$1$1.this.kWy.kWx.getString(a$i.lucky_money_upload_image_fail_tips));
            }
        });
    }
}
