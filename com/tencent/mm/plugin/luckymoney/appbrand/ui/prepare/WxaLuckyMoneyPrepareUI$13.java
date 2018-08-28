package com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.wallet_core.ui.e;

class WxaLuckyMoneyPrepareUI$13 implements OnMenuItemClickListener {
    final /* synthetic */ WxaLuckyMoneyPrepareUI kMq;

    WxaLuckyMoneyPrepareUI$13(WxaLuckyMoneyPrepareUI wxaLuckyMoneyPrepareUI) {
        this.kMq = wxaLuckyMoneyPrepareUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        e.l(this.kMq.mController.tml, "https://kf.qq.com/touch/scene_product.html?scene_id=kf7", false);
        return true;
    }
}
