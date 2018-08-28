package com.tencent.mm.plugin.sns.ui;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

class SnsCommentDetailUI$10 implements OnScrollListener {
    final /* synthetic */ SnsCommentDetailUI nUO;

    SnsCommentDetailUI$10(SnsCommentDetailUI snsCommentDetailUI) {
        this.nUO = snsCommentDetailUI;
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1) {
            this.nUO.YC();
            SnsCommentDetailUI.s(this.nUO);
        }
    }
}
