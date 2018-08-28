package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;

class SnsNotifyBanner$1 implements OnClickListener {
    final /* synthetic */ SnsNotifyBanner nZd;

    SnsNotifyBanner$1(SnsNotifyBanner snsNotifyBanner) {
        this.nZd = snsNotifyBanner;
    }

    public final void onClick(View view) {
        this.nZd.setVisibility(8);
    }
}
