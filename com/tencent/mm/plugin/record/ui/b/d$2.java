package com.tencent.mm.plugin.record.ui.b;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class d$2 implements OnTouchListener {
    final /* synthetic */ d mtI;

    d$2(d dVar) {
        this.mtI = dVar;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.mtI.hpr = (int) motionEvent.getRawX();
            this.mtI.hps = (int) motionEvent.getRawY();
        }
        return false;
    }
}
