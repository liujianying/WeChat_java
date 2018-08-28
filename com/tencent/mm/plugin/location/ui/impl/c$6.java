package com.tencent.mm.plugin.location.ui.impl;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class c$6 implements OnTouchListener {
    final /* synthetic */ c kJf;

    c$6(c cVar) {
        this.kJf = cVar;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        this.kJf.YC();
        return false;
    }
}
