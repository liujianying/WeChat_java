package com.tencent.mm.plugin.location.ui.impl;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.x;

class c$1 implements OnTouchListener {
    private float kJd;
    private short kJe = (short) 0;
    final /* synthetic */ c kJf;

    c$1(c cVar) {
        this.kJf = cVar;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (!c.a(this.kJf)) {
            return true;
        }
        switch (motionEvent.getAction()) {
            case 0:
                x.d("MicroMsg.MMPoiMapUI", "newpoi action down %s", new Object[]{Float.valueOf(motionEvent.getRawY())});
                this.kJd = motionEvent.getRawY();
                c.a(this.kJf, false);
                break;
            case 1:
                x.d("MicroMsg.MMPoiMapUI", "newpoi action up ");
                c.a(this.kJf, false);
                break;
            case 2:
                x.d("MicroMsg.MMPoiMapUI", "newpoi action move %s", new Object[]{Float.valueOf(motionEvent.getRawY())});
                if (c.b(this.kJf)) {
                    x.d("MicroMsg.MMPoiMapUI", "newpoi blocked");
                    c.c(this.kJf).setSelection(0);
                }
                float rawY = this.kJd - motionEvent.getRawY();
                if (Math.abs(rawY) < ((float) b.b(this.kJf.activity, 20.0f))) {
                    this.kJe = (short) 0;
                } else if (rawY > 0.0f) {
                    this.kJe = (short) 1;
                } else {
                    this.kJe = (short) -1;
                }
                if ((this.kJf.baa() <= c.d(this.kJf) && this.kJe == (short) 1) || ((!c.c(this.kJf).getScroll2Top() && this.kJe == (short) -1 && this.kJf.baa() < c.e(this.kJf)) || (this.kJe == (short) -1 && this.kJf.baa() >= c.e(this.kJf)))) {
                    return false;
                }
                if (!c.a(this.kJf) || this.kJe == (short) 0) {
                    return true;
                }
                x.d("MicroMsg.MMPoiMapUI", "newpoi start play isUP %s", new Object[]{Short.valueOf(this.kJe)});
                if (this.kJe == (short) 1) {
                    c.b(this.kJf, true);
                    return false;
                }
                c.b(this.kJf, false);
                return false;
        }
        return false;
    }
}
