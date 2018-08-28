package com.tencent.mm.plugin.location.ui.impl;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.sdk.platformtools.x;

class b$1 implements OnTouchListener {
    final /* synthetic */ b kIl;

    b$1(b bVar) {
        this.kIl = bVar;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        x.i("MicroMsg.MMBaseMapUI", "map action " + action);
        switch (action) {
            case 0:
                this.kIl.jUm = motionEvent.getX();
                this.kIl.hlo = motionEvent.getY();
                break;
            case 1:
                if (Math.abs(motionEvent.getX() - this.kIl.jUm) > 10.0f || Math.abs(motionEvent.getY() - this.kIl.hlo) > 10.0f) {
                    this.kIl.aZZ();
                    break;
                }
        }
        return false;
    }
}
