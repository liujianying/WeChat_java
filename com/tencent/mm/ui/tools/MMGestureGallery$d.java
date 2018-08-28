package com.tencent.mm.ui.tools;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

class MMGestureGallery$d extends SimpleOnGestureListener {
    final /* synthetic */ MMGestureGallery uAo;

    private MMGestureGallery$d(MMGestureGallery mMGestureGallery) {
        this.uAo = mMGestureGallery;
    }

    /* synthetic */ MMGestureGallery$d(MMGestureGallery mMGestureGallery, byte b) {
        this(mMGestureGallery);
    }

    public final boolean onDoubleTap(MotionEvent motionEvent) {
        return true;
    }
}
