package com.tencent.mm.plugin.collect.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class CollectBillUI$5 implements OnMenuItemClickListener {
    final /* synthetic */ CollectBillUI hXA;

    CollectBillUI$5(CollectBillUI collectBillUI) {
        this.hXA = collectBillUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.hXA.startActivity(new Intent(this.hXA.mController.tml, CollectBillListUI.class));
        return false;
    }
}
