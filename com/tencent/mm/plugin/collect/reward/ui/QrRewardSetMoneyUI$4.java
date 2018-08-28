package com.tencent.mm.plugin.collect.reward.ui;

import android.content.Intent;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.collect.reward.a.a$a;
import com.tencent.mm.plugin.collect.reward.a.g;

class QrRewardSetMoneyUI$4 implements a$a {
    final /* synthetic */ QrRewardSetMoneyUI hWL;
    final /* synthetic */ g hWM;

    QrRewardSetMoneyUI$4(QrRewardSetMoneyUI qrRewardSetMoneyUI, g gVar) {
        this.hWL = qrRewardSetMoneyUI;
        this.hWM = gVar;
    }

    public final void i(l lVar) {
        QrRewardSetMoneyUI.a(this.hWL, this.hWM.hVd.mwO);
        QrRewardSetMoneyUI.b(this.hWL, this.hWM.hVd.desc);
        Intent intent = new Intent();
        intent.putExtra("key_desc", this.hWM.hVd.desc);
        intent.putExtra("key_photo_url", this.hWM.hVd.mwO);
        intent.putExtra("key_photo_aeskey", this.hWM.hVd.rqa);
        intent.putExtra("key_photo_width", this.hWM.hVd.rqf);
        intent.putExtra("key_icon_width", this.hWM.hVd.rqb);
        intent.putExtra("key_return_from_first", QrRewardSetMoneyUI.c(this.hWL));
        this.hWL.setResult(-1, intent);
        this.hWL.finish();
    }
}
