package com.tencent.mm.plugin.luckymoney.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.wallet_core.ui.e;

class LuckyMoneyPrepareUI$32 implements OnMenuItemClickListener {
    final /* synthetic */ LuckyMoneyPrepareUI kWX;

    LuckyMoneyPrepareUI$32(LuckyMoneyPrepareUI luckyMoneyPrepareUI) {
        this.kWX = luckyMoneyPrepareUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        if (LuckyMoneyPrepareUI.d(this.kWX) == null || bi.oW(LuckyMoneyPrepareUI.d(this.kWX).kPH)) {
            e.l(this.kWX.mController.tml, "https://hkwallet.moneydata.hk/hybrid/www/weixin/hongbao_hk_v2/zh_hk/faq.shtml", false);
        } else {
            e.l(this.kWX.mController.tml, LuckyMoneyPrepareUI.d(this.kWX).kPH, false);
        }
        return true;
    }
}
