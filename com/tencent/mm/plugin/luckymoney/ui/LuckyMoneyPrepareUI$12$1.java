package com.tencent.mm.plugin.luckymoney.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.12;
import com.tencent.mm.plugin.wallet_core.model.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.ui.e;

class LuckyMoneyPrepareUI$12$1 implements OnClickListener {
    final /* synthetic */ a kWY;
    final /* synthetic */ 12 kWZ;

    LuckyMoneyPrepareUI$12$1(12 12, a aVar) {
        this.kWZ = 12;
        this.kWY = aVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.i("MicroMsg.LuckyMoneyPrepareUI", "goto h5: %s", new Object[]{this.kWY.hUt});
        e.l(this.kWZ.kWX.mController.tml, this.kWY.hUt, false);
        LuckyMoneyPrepareUI.a(this.kWZ.kWX, false);
    }
}
