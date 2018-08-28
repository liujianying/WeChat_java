package com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class WxaLuckyMoneyPrepareUI$10 implements OnMenuItemClickListener {
    final /* synthetic */ WxaLuckyMoneyPrepareUI kMq;

    WxaLuckyMoneyPrepareUI$10(WxaLuckyMoneyPrepareUI wxaLuckyMoneyPrepareUI) {
        this.kMq = wxaLuckyMoneyPrepareUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.kMq.setResult(0, new Intent().putExtra("result_error_code", -1).putExtra("result_error_msg", "fail:system error {{user cancel}}"));
        this.kMq.finish();
        return true;
    }
}
