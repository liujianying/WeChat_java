package com.tencent.mm.plugin.bottle.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class BottleWizardStep1$2 implements OnMenuItemClickListener {
    final /* synthetic */ BottleWizardStep1 hlz;

    BottleWizardStep1$2(BottleWizardStep1 bottleWizardStep1) {
        this.hlz = bottleWizardStep1;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.hlz.YC();
        this.hlz.finish();
        return true;
    }
}
