package android.support.v7.widget.a;

import android.support.v4.view.o;
import android.support.v7.widget.RecyclerView$t;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;

class a$b extends SimpleOnGestureListener {
    final /* synthetic */ a Yc;

    private a$b(a aVar) {
        this.Yc = aVar;
    }

    /* synthetic */ a$b(a aVar, byte b) {
        this(aVar);
    }

    public final boolean onDown(MotionEvent motionEvent) {
        return true;
    }

    public final void onLongPress(MotionEvent motionEvent) {
        View p = this.Yc.p(motionEvent);
        if (p != null) {
            RecyclerView$t aP = this.Yc.Sa.aP(p);
            if (aP != null && a$a.C(this.Yc.Sa) && o.c(motionEvent, 0) == this.Yc.cF) {
                int b = o.b(motionEvent, this.Yc.cF);
                float d = o.d(motionEvent, b);
                float e = o.e(motionEvent, b);
                this.Yc.XH = d;
                this.Yc.XI = e;
                a aVar = this.Yc;
                this.Yc.XM = 0.0f;
                aVar.XL = 0.0f;
                this.Yc.XP.ho();
                this.Yc.d(aP, 2);
            }
        }
    }
}
