package com.tencent.mm.plugin.location.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class m$1 implements OnTouchListener {
    final /* synthetic */ m kHj;

    m$1(m mVar) {
        this.kHj = mVar;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.kHj.jUm = motionEvent.getX();
                this.kHj.hlo = motionEvent.getY();
                m.a(this.kHj, System.currentTimeMillis());
                m.a(this.kHj, false);
                break;
            case 1:
                if (!m.a(this.kHj) && System.currentTimeMillis() - m.b(this.kHj) < 200) {
                    m.c(this.kHj);
                    break;
                }
            case 2:
                if (Math.abs(motionEvent.getX() - this.kHj.jUm) > 10.0f || Math.abs(motionEvent.getY() - this.kHj.hlo) > 10.0f) {
                    m.a(this.kHj, true);
                    break;
                }
        }
        return false;
    }
}
