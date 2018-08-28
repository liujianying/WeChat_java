package com.tencent.mm.plugin.sns.ui;

import android.view.ViewTreeObserver.OnPreDrawListener;

class SnsOnlineVideoActivity$10 implements OnPreDrawListener {
    final /* synthetic */ SnsOnlineVideoActivity nZl;

    SnsOnlineVideoActivity$10(SnsOnlineVideoActivity snsOnlineVideoActivity) {
        this.nZl = snsOnlineVideoActivity;
    }

    public final boolean onPreDraw() {
        SnsOnlineVideoActivity.c(this.nZl).getViewTreeObserver().removeOnPreDrawListener(this);
        SnsOnlineVideoActivity.m(this.nZl).a(SnsOnlineVideoActivity.c(this.nZl), SnsOnlineVideoActivity.h(this.nZl), new 1(this));
        return true;
    }
}
