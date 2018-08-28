package com.tencent.mm.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class BaseActivity$1 implements OnMenuItemClickListener {
    final /* synthetic */ BaseActivity tgA;

    BaseActivity$1(BaseActivity baseActivity) {
        this.tgA = baseActivity;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.tgA.finish();
        return true;
    }
}
