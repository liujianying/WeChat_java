package com.tencent.mm.ui.chatting;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.ui.chatting.b.b.m;

class y$15 implements OnTouchListener {
    final /* synthetic */ y tMm;
    boolean tMq = false;

    y$15(y yVar) {
        this.tMm = yVar;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        y.g(this.tMm);
        if (motionEvent.getAction() == 0) {
            this.tMq = true;
        } else if (motionEvent.getAction() == 1) {
            this.tMq = false;
        }
        if (this.tMq && this.tMm.tMg) {
            m mVar = (m) this.tMm.bAG.O(m.class);
            if (!(mVar == null || mVar.cvb() == null)) {
                mVar.cvb().r(0, -1, false);
            }
        }
        return false;
    }
}
