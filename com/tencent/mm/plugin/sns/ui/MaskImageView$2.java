package com.tencent.mm.plugin.sns.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class MaskImageView$2 implements OnTouchListener {
    final /* synthetic */ MaskImageView nOL;

    MaskImageView$2(MaskImageView maskImageView) {
        this.nOL = maskImageView;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (MaskImageView.a(this.nOL)) {
            return this.nOL.d(view, motionEvent);
        }
        return false;
    }
}
