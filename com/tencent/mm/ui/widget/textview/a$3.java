package com.tencent.mm.ui.widget.textview;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class a$3 implements OnTouchListener {
    final /* synthetic */ a uPp;

    a$3(a aVar) {
        this.uPp = aVar;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        this.uPp.uPf = (int) motionEvent.getX();
        this.uPp.uPg = (int) motionEvent.getY();
        return false;
    }
}
