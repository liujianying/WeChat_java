package com.tencent.mm.plugin.sns.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SnsCommentUI$3 implements OnMenuItemClickListener {
    final /* synthetic */ SnsCommentUI nVX;

    SnsCommentUI$3(SnsCommentUI snsCommentUI) {
        this.nVX = snsCommentUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.nVX.YC();
        this.nVX.finish();
        return true;
    }
}
