package com.tencent.mm.plugin.sns.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SnsStrangerCommentDetailUI$4 implements OnMenuItemClickListener {
    final /* synthetic */ SnsStrangerCommentDetailUI obC;

    SnsStrangerCommentDetailUI$4(SnsStrangerCommentDetailUI snsStrangerCommentDetailUI) {
        this.obC = snsStrangerCommentDetailUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.obC.finish();
        return true;
    }
}
