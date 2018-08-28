package com.tencent.mm.plugin.brandservice.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class EnterpriseBizContactPlainListUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ EnterpriseBizContactPlainListUI hpF;

    EnterpriseBizContactPlainListUI$2(EnterpriseBizContactPlainListUI enterpriseBizContactPlainListUI) {
        this.hpF = enterpriseBizContactPlainListUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.hpF.YC();
        this.hpF.finish();
        return true;
    }
}
