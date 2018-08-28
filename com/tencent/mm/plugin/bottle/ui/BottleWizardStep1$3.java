package com.tencent.mm.plugin.bottle.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class BottleWizardStep1$3 implements OnMenuItemClickListener {
    final /* synthetic */ BottleWizardStep1 hlz;

    BottleWizardStep1$3(BottleWizardStep1 bottleWizardStep1) {
        this.hlz = bottleWizardStep1;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.hlz.startActivity(new Intent().setClass(this.hlz, BottleWizardStep2.class));
        this.hlz.finish();
        return true;
    }
}
