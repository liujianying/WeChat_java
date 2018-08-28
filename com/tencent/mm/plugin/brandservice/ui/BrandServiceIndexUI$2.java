package com.tencent.mm.plugin.brandservice.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class BrandServiceIndexUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ BrandServiceIndexUI hpc;

    BrandServiceIndexUI$2(BrandServiceIndexUI brandServiceIndexUI) {
        this.hpc = brandServiceIndexUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.hpc.finish();
        return true;
    }
}
