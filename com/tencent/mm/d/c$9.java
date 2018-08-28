package com.tencent.mm.d;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.graphics.RectF;
import com.tencent.mm.sdk.platformtools.x;

class c$9 implements AnimatorListener {
    final /* synthetic */ c bCc;

    public c$9(c cVar) {
        this.bCc = cVar;
    }

    public final void onAnimationStart(Animator animator) {
        c.a(this.bCc, false);
        this.bCc.bBQ = true;
        c.b(this.bCc, true);
    }

    public final void onAnimationEnd(Animator animator) {
        x.i("MicroMsg.CropArtist", "onAnimationEnd");
        c.f(this.bCc);
        if (c.g(this.bCc) == 0) {
            c.b(this.bCc, false);
            RectF rectF = new RectF();
            rectF.set(c.d(this.bCc));
            c.e(this.bCc).mapRect(rectF);
            c.e(this.bCc).reset();
            c.d(this.bCc).set((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
            this.bCc.vR();
        }
        c.a(this.bCc, 200, false, true);
    }

    public final void onAnimationCancel(Animator animator) {
    }

    public final void onAnimationRepeat(Animator animator) {
    }
}
