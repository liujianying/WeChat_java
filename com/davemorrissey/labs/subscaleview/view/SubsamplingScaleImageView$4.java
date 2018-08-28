package com.davemorrissey.labs.subscaleview.view;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

class SubsamplingScaleImageView$4 extends SimpleOnGestureListener {
    final /* synthetic */ SubsamplingScaleImageView abb;

    SubsamplingScaleImageView$4(SubsamplingScaleImageView subsamplingScaleImageView) {
        this.abb = subsamplingScaleImageView;
    }

    public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        this.abb.performClick();
        return true;
    }
}
