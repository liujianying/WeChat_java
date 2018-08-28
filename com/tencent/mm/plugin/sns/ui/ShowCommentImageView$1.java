package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;

class ShowCommentImageView$1 implements OnClickListener {
    final /* synthetic */ OnClickListener nRi;
    final /* synthetic */ ShowCommentImageView nRj;

    ShowCommentImageView$1(ShowCommentImageView showCommentImageView, OnClickListener onClickListener) {
        this.nRj = showCommentImageView;
        this.nRi = onClickListener;
    }

    public final void onClick(View view) {
        ShowCommentImageView.a(this.nRj, true);
        this.nRi.onClick(view);
    }
}
