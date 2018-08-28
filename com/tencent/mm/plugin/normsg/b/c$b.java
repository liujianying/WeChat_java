package com.tencent.mm.plugin.normsg.b;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

final class c$b implements OnTouchListener {
    private final OnTouchListener lGV;

    c$b(OnTouchListener onTouchListener) {
        this.lGV = onTouchListener;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        synchronized (c.ajb()) {
            if (c.ajb().containsKey(view)) {
                synchronized (c.QV()) {
                    c.QV().put(view, Boolean.valueOf(true));
                }
            }
        }
        if (this.lGV != null) {
            return this.lGV.onTouch(view, motionEvent);
        }
        return false;
    }
}
