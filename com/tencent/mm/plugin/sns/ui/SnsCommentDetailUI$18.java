package com.tencent.mm.plugin.sns.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SnsCommentDetailUI$18 implements OnMenuItemClickListener {
    final /* synthetic */ SnsCommentDetailUI nUO;

    SnsCommentDetailUI$18(SnsCommentDetailUI snsCommentDetailUI) {
        this.nUO = snsCommentDetailUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        if (SnsCommentDetailUI.b(this.nUO) != null) {
            SnsCommentDetailUI.b(this.nUO).ir(false);
        }
        this.nUO.finish();
        return true;
    }
}
