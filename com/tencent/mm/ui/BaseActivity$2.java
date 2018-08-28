package com.tencent.mm.ui;

import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;

class BaseActivity$2 implements OnClickListener {
    final /* synthetic */ OnMenuItemClickListener hBy;
    final /* synthetic */ BaseActivity tgA;

    BaseActivity$2(BaseActivity baseActivity, OnMenuItemClickListener onMenuItemClickListener) {
        this.tgA = baseActivity;
        this.hBy = onMenuItemClickListener;
    }

    public final void onClick(View view) {
        this.hBy.onMenuItemClick(null);
    }
}
