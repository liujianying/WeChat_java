package com.tencent.mm.plugin.gallery.view;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

class MultiGestureImageView$c extends SimpleOnGestureListener {
    final /* synthetic */ MultiGestureImageView jFj;

    private MultiGestureImageView$c(MultiGestureImageView multiGestureImageView) {
        this.jFj = multiGestureImageView;
    }

    /* synthetic */ MultiGestureImageView$c(MultiGestureImageView multiGestureImageView, byte b) {
        this(multiGestureImageView);
    }

    public final boolean onDoubleTap(MotionEvent motionEvent) {
        return true;
    }
}
