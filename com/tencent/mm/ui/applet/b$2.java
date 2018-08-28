package com.tencent.mm.ui.applet;

import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;

class b$2 implements OnGestureListener {
    final /* synthetic */ b trE;

    b$2(b bVar) {
        this.trE = bVar;
    }

    public final boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    public final void onShowPress(MotionEvent motionEvent) {
    }

    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        this.trE.direction = f2 >= 0.0f ? 0 : 1;
        return false;
    }

    public final void onLongPress(MotionEvent motionEvent) {
    }

    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }
}
