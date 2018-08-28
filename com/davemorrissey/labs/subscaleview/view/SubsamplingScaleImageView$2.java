package com.davemorrissey.labs.subscaleview.view;

import android.os.Handler.Callback;
import android.os.Message;

class SubsamplingScaleImageView$2 implements Callback {
    final /* synthetic */ SubsamplingScaleImageView abb;

    SubsamplingScaleImageView$2(SubsamplingScaleImageView subsamplingScaleImageView) {
        this.abb = subsamplingScaleImageView;
    }

    public final boolean handleMessage(Message message) {
        if (message.what == 1 && SubsamplingScaleImageView.b(this.abb) != null) {
            SubsamplingScaleImageView.c(this.abb);
            SubsamplingScaleImageView.a(this.abb, SubsamplingScaleImageView.b(this.abb));
            this.abb.performLongClick();
            SubsamplingScaleImageView.d(this.abb);
        }
        return true;
    }
}
