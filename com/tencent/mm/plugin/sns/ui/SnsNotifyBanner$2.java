package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;

class SnsNotifyBanner$2 implements OnClickListener {
    final /* synthetic */ SnsNotifyBanner nZd;

    SnsNotifyBanner$2(SnsNotifyBanner snsNotifyBanner) {
        this.nZd = snsNotifyBanner;
    }

    public final void onClick(View view) {
        if (SnsNotifyBanner.a(this.nZd) != null) {
            if (this.nZd.nZb > 0) {
                this.nZd.nZb = 0;
            }
            this.nZd.setVisibility(8);
        }
    }
}
