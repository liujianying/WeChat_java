package com.tencent.mm.plugin.appbrand.game;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class k$1 implements OnTouchListener {
    final /* synthetic */ k fAo;

    k$1(k kVar) {
        this.fAo = kVar;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        k.a(this.fAo, motionEvent);
        return true;
    }
}
