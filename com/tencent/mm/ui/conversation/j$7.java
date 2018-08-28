package com.tencent.mm.ui.conversation;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class j$7 implements OnTouchListener {
    final /* synthetic */ j ure;

    j$7(j jVar) {
        this.ure = jVar;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.ure.hideVKB();
                j.f(this.ure)[0] = (int) motionEvent.getRawX();
                j.f(this.ure)[1] = (int) motionEvent.getRawY();
                break;
        }
        return false;
    }
}
