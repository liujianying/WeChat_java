package com.tencent.mm.pluginsdk.ui.chat;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class n$2 implements OnTouchListener {
    final /* synthetic */ n qNT;

    n$2(n nVar) {
        this.qNT = nVar;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return n.a(this.qNT, view, motionEvent);
    }
}
