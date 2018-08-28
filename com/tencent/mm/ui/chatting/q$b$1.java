package com.tencent.mm.ui.chatting;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.ui.chatting.q.b;

class q$b$1 implements OnTouchListener {
    final /* synthetic */ b tJI;

    q$b$1(b bVar) {
        this.tJI = bVar;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (b.b(this.tJI) != null) {
            b.b(this.tJI).onTouch(b.c(this.tJI), motionEvent);
        }
        return false;
    }
}
