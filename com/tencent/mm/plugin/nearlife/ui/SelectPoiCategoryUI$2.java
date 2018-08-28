package com.tencent.mm.plugin.nearlife.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SelectPoiCategoryUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ SelectPoiCategoryUI lEA;

    SelectPoiCategoryUI$2(SelectPoiCategoryUI selectPoiCategoryUI) {
        this.lEA = selectPoiCategoryUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.lEA.setResult(0, null);
        this.lEA.finish();
        return true;
    }
}
